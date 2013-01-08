/*
<<<<<<< HEAD
* Copyright (c) 2012 The Broad Institute
* 
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
* THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
=======
 * Copyright (c) 2012 The Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
>>>>>>> Create LIBS using new AlignmentStateMachine infrastructure

package org.broadinstitute.sting.utils.locusiterator;

import com.google.java.contract.Ensures;
import net.sf.samtools.CigarOperator;
import net.sf.samtools.SAMRecord;
import org.apache.log4j.Logger;
import org.broadinstitute.sting.gatk.ReadProperties;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.downsampling.DownsampleType;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.GenomeLocParser;
import org.broadinstitute.sting.utils.pileup.PileupElement;
import org.broadinstitute.sting.utils.pileup.ReadBackedPileupImpl;
import org.broadinstitute.sting.utils.sam.GATKSAMRecord;
import org.broadinstitute.sting.utils.sam.ReadUtils;

import java.util.*;

/**
 * Iterator that traverses a SAM File, accumulating information on a per-locus basis
 */
public class LocusIteratorByState extends LocusIterator {
    /**
     * our log, which we want to capture anything from this class
     */
    private static Logger logger = Logger.getLogger(LocusIteratorByState.class);

    // -----------------------------------------------------------------------------------------------------------------
    //
    // member fields
    //
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Used to create new GenomeLocs.
     */
    private final GenomeLocParser genomeLocParser;
    private final ArrayList<String> samples;
    private final ReadStateManager readStates;
    private final boolean includeReadsWithDeletionAtLoci;

    private AlignmentContext nextAlignmentContext;

    // -----------------------------------------------------------------------------------------------------------------
    //
    // constructors and other basic operations
    //
    // -----------------------------------------------------------------------------------------------------------------

    public LocusIteratorByState(final Iterator<SAMRecord> samIterator,
                                final ReadProperties readInformation,
                                final GenomeLocParser genomeLocParser,
                                final Collection<String> samples) {
        this(samIterator,
                toDownsamplingInfo(readInformation),
                readInformation.includeReadsWithDeletionAtLoci(),
                genomeLocParser,
                samples,
                readInformation.keepUniqueReadListInLIBS());
    }

    protected LocusIteratorByState(final Iterator<SAMRecord> samIterator,
                                   final LIBSDownsamplingInfo downsamplingInfo,
                                   final boolean includeReadsWithDeletionAtLoci,
                                   final GenomeLocParser genomeLocParser,
                                   final Collection<String> samples,
                                   final boolean maintainUniqueReadsList) {
        this.genomeLocParser = genomeLocParser;
        this.includeReadsWithDeletionAtLoci = includeReadsWithDeletionAtLoci;
        this.samples = new ArrayList<String>(samples);
        this.readStates = new ReadStateManager(samIterator, this.samples, downsamplingInfo, maintainUniqueReadsList);

        // currently the GATK expects this LocusIteratorByState to accept empty sample lists, when
        // there's no read data.  So we need to throw this error only when samIterator.hasNext() is true
        if (this.samples.isEmpty() && samIterator.hasNext()) {
            throw new IllegalArgumentException("samples list must not be empty");
        }
    }

    @Override
    public Iterator<AlignmentContext> iterator() {
        return this;
    }

    @Override
    public void close() {
    }

    @Override
    public boolean hasNext() {
        lazyLoadNextAlignmentContext();
        return nextAlignmentContext != null;
    }

    private GenomeLoc getLocation() {
        return readStates.isEmpty() ? null : readStates.getFirst().getLocation(genomeLocParser);
    }

    // -----------------------------------------------------------------------------------------------------------------
    //
    // next() routine and associated collection operations
    //
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public AlignmentContext next() {
        lazyLoadNextAlignmentContext();
        if (!hasNext())
            throw new NoSuchElementException("LocusIteratorByState: out of elements.");
        AlignmentContext currentAlignmentContext = nextAlignmentContext;
        nextAlignmentContext = null;
        return currentAlignmentContext;
    }

    /**
     * Creates the next alignment context from the given state.  Note that this is implemented as a lazy load method.
     * nextAlignmentContext MUST BE null in order for this method to advance to the next entry.
     */
    private void lazyLoadNextAlignmentContext() {
        while (nextAlignmentContext == null && readStates.hasNext()) {
            readStates.collectPendingReads();

            final GenomeLoc location = getLocation();
            final Map<String, ReadBackedPileupImpl> fullPileup = new HashMap<String, ReadBackedPileupImpl>();

            // TODO: How can you determine here whether the current pileup has been downsampled?
            boolean hasBeenSampled = false;

            for (final String sample : samples) {
                final Iterator<AlignmentStateMachine> iterator = readStates.iterator(sample);
                final List<PileupElement> pile = new ArrayList<PileupElement>(readStates.size(sample));

                int size = 0;                                                           // number of elements in this sample's pileup
                int nDeletions = 0;                                                     // number of deletions in this sample's pileup
                int nMQ0Reads = 0;                                                      // number of MQ0 reads in this sample's pileup (warning: current implementation includes N bases that are MQ0)

                while (iterator.hasNext()) {
                    final AlignmentStateMachine state = iterator.next();                   // state object with the read/offset information
                    final GATKSAMRecord read = (GATKSAMRecord) state.getRead();     // the actual read
                    final CigarOperator op = state.getCigarOperator();       // current cigar operator

                    if (op == CigarOperator.N)                                      // N's are never added to any pileup
                        continue;

                    if (!filterBaseInRead(read, location.getStart())) {
                        if ( op == CigarOperator.D ) {
                            if ( ! includeReadsWithDeletionAtLoci )
                                continue;
                            nDeletions++;
                        }

                        pile.add(new PileupElement(read, state.getReadOffset(),
                                state.getCurrentCigarElement(), state.getCurrentCigarElementOffset(),
                                state.getOffsetIntoCurrentCigarElement()));
                        size++;

                        if ( read.getMappingQuality() == 0 )
                            nMQ0Reads++;
                    }
                }

                if (pile.size() != 0)                                             // if this pileup added at least one base, add it to the full pileup
                    fullPileup.put(sample, new ReadBackedPileupImpl(location, pile, size, nDeletions, nMQ0Reads));
            }

            updateReadStates();                                                   // critical - must be called after we get the current state offsets and location
            if (!fullPileup.isEmpty())                                            // if we got reads with non-D/N over the current position, we are done
                nextAlignmentContext = new AlignmentContext(location, new ReadBackedPileupImpl(location, fullPileup), hasBeenSampled);
        }
    }

    private void updateReadStates() {
        for (final String sample : samples) {
            Iterator<AlignmentStateMachine> it = readStates.iterator(sample);
            while (it.hasNext()) {
                AlignmentStateMachine state = it.next();
                CigarOperator op = state.stepForwardOnGenome();
                if (op == null) {
                    // we discard the read only when we are past its end AND indel at the end of the read (if any) was
                    // already processed. Keeping the read state that returned null upon stepForwardOnGenome() is safe
                    // as the next call to stepForwardOnGenome() will return null again AND will clear hadIndel() flag.
                    it.remove();                                                // we've stepped off the end of the object
                }
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    //
    // getting the list of reads
    //
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Transfer current list of all unique reads that have ever been used in any pileup, clearing old list
     *
     * This list is guaranteed to only contain unique reads, even across calls to the this function.  It is
     * literally the unique set of reads ever seen.
     *
     * The list occurs in the same order as they are encountered in the underlying iterator.
     *
     * Takes the maintained list of submitted reads, and transfers it to the caller of this
     * function.  The old list of set to a new, cleanly allocated list so the caller officially
     * owns the list returned by this call.  This is the only way to clear the tracking
     * of submitted reads, if enabled.
     *
     * The purpose of this function is allow users of LIBS to keep track of all of the reads pulled off the
     * underlying SAMRecord iterator and that appeared at any point in the list of SAMRecordAlignmentState for
     * any reads.  This function is intended to allow users to efficiently reconstruct the unique set of reads
     * used across all pileups.  This is necessary for LIBS to handle because attempting to do
     * so from the pileups coming out of LIBS is extremely expensive.
     *
     * This functionality is only available if LIBS was created with the argument to track the reads
     *
     * @throws UnsupportedOperationException if called when keepingSubmittedReads is false
     *
     * @return the current list
     */
    @Ensures("result != null")
    public List<SAMRecord> transferReadsFromAllPreviousPileups() {
        return readStates.transferSubmittedReads();
    }

    /**
     * Get the underlying list of tracked reads.  For testing only
     * @return a non-null list
     */
    @Ensures("result != null")
    protected List<SAMRecord> getReadsFromAllPreviousPileups() {
        return readStates.getSubmittedReads();
    }

    // -----------------------------------------------------------------------------------------------------------------
    //
    // utility functions
    //
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Generic place to put per-base filters appropriate to LocusIteratorByState
     *
     * @param rec
     * @param pos
     * @return
     */
    private boolean filterBaseInRead(GATKSAMRecord rec, long pos) {
        return ReadUtils.isBaseInsideAdaptor(rec, pos);
    }

    /**
     * Create a LIBSDownsamplingInfo object from the requested info in ReadProperties
     *
     * LIBS will invoke the Reservoir and Leveling downsamplers on the read stream if we're
     * downsampling to coverage by sample. SAMDataSource will have refrained from applying
     * any downsamplers to the read stream in this case, in the expectation that LIBS will
     * manage the downsampling. The reason for this is twofold: performance (don't have to
     * split/re-assemble the read stream in SAMDataSource), and to enable partial downsampling
     * of reads (eg., using half of a read, and throwing the rest away).
     *
     * @param readInfo GATK engine information about what should be done to the reads
     * @return a LIBS specific info holder about downsampling only
     */
    private static LIBSDownsamplingInfo toDownsamplingInfo(final ReadProperties readInfo) {
        final boolean performDownsampling = readInfo.getDownsamplingMethod() != null &&
                readInfo.getDownsamplingMethod().type == DownsampleType.BY_SAMPLE &&
                readInfo.getDownsamplingMethod().toCoverage != null;
        final int coverage = performDownsampling ? readInfo.getDownsamplingMethod().toCoverage : 0;

        return new LIBSDownsamplingInfo(performDownsampling, coverage);
    }
}