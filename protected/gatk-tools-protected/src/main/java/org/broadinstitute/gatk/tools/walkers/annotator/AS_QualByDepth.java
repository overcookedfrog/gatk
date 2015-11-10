/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 (“BROAD”) and the LICENSEE and is effective at the date the downloading is completed (“EFFECTIVE DATE”).
* 
* WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
* WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
* NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
* 
* 1. DEFINITIONS
* 1.1 PROGRAM shall mean copyright in the object code and source code known as GATK3 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute.org/gatk on the EFFECTIVE DATE.
* 
* 2. LICENSE
* 2.1 Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. LICENSEE hereby automatically grants to BROAD a non-exclusive, royalty-free, irrevocable license to any LICENSEE bug fixes or modifications to the PROGRAM with unlimited rights to sublicense and/or distribute.  LICENSEE agrees to provide any such modifications and bug fixes to BROAD promptly upon their creation.
* The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only. For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
* 2.2 No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD. LICENSEE shall ensure that all of its users agree to the terms of this Agreement. LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
* 2.3 License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.
* 
* 3. PHONE-HOME FEATURE
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system (“PHONE-HOME”) which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2015 Broad Institute, Inc.
* Notice of attribution: The GATK3 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
* LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
* 
* 5. INDEMNIFICATION
* LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
* 
* 6. NO REPRESENTATIONS OR WARRANTIES
* THE PROGRAM IS DELIVERED AS IS. BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
* IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
* 
* 7. ASSIGNMENT
* This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
* 
* 8. MISCELLANEOUS
* 8.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
* 8.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
* 8.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
* 8.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested. All notices under this Agreement shall be deemed effective upon receipt.
* 8.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter.
* 8.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
* 8.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.gatk.tools.walkers.annotator;

import htsjdk.variant.variantcontext.Allele;
import htsjdk.variant.variantcontext.Genotype;
import htsjdk.variant.variantcontext.GenotypesContext;
import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.vcf.VCFInfoHeaderLine;
import org.broadinstitute.gatk.tools.walkers.annotator.interfaces.AS_StandardAnnotation;
import org.broadinstitute.gatk.tools.walkers.annotator.interfaces.AnnotatorCompatible;
import org.broadinstitute.gatk.tools.walkers.annotator.interfaces.InfoFieldAnnotation;
import org.broadinstitute.gatk.tools.walkers.annotator.interfaces.ReducibleAnnotation;
import org.broadinstitute.gatk.utils.MathUtils;
import org.broadinstitute.gatk.utils.contexts.AlignmentContext;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.genotyper.PerReadAlleleLikelihoodMap;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.utils.variant.GATKVCFConstants;
import org.broadinstitute.gatk.utils.variant.GATKVCFHeaderLines;

import java.util.*;

/**
 * Per-allele call confidence normalized by depth of sample reads supporting the allele
 *
 * <p>This annotation puts the variant confidence QUAL score into perspective by normalizing for the amount of coverage available. Because each read contributes a little to the QUAL score, variants in regions with deep coverage can have artificially inflated QUAL scores, giving the impression that the call is supported by more evidence than it really is. To compensate for this, we normalize the variant confidence by depth, which gives us a more objective picture of how well supported the call is.</p>
 *
 * <h3>Statistical notes</h3>
 * <p>The QD is the QUAL score normalized by allele depth (AD) for a variant. For a single sample, the HaplotypeCaller calculates the QD by taking QUAL/AD. For multiple samples, HaplotypeCaller and GenotypeGVCFs calculate the QD by taking QUAL/AD of samples with a non hom-ref genotype call. The reason we leave out the samples with a hom-ref call is to not penalize the QUAL for the other samples with the variant call.</p>
 * <p>Here is a single sample example:</p>
 * <pre>2	37629	.	C	G	1063.77	.	AC=2;AF=1.00;AN=2;DP=31;FS=0.000;MLEAC=2;MLEAF=1.00;MQ=58.50;QD=34.32;SOR=2.376	GT:AD:DP:GQ:PL:QSS	1/1:0,31:31:93:1092,93,0:0,960</pre>
 <p>QUAL/AD = 1063.77/31 = 34.32 = QD</p>
 * <p>Here is a multi-sample example:</p>
 * <pre>10	8046	.	C	T	4107.13	.	AC=1;AF=0.167;AN=6;BaseQRankSum=-3.717;DP=1063;FS=1.616;MLEAC=1;MLEAF=0.167;QD=11.54
 GT:AD:DP:GQ:PL:QSS	0/0:369,4:373:99:0,1007,12207:10548,98	    0/0:331,1:332:99:0,967,11125:9576,27	    0/1:192,164:356:99:4138,0,5291:5501,4505</pre>
 * <p>QUAL/AD = 4107.13/356 = 11.54 = QD</p>
 * <p>Note that currently, when HaplotypeCaller is run with `-ERC GVCF`, the QD calculation is invoked before AD itself has been calculated, due to a technical constraint. In that case, HaplotypeCaller uses the number of overlapping reads from the haplotype likelihood calculation in place of AD to calculate QD, which generally yields a very similar number. This does not cause any measurable problems, but can cause some confusion since the number may be slightly different than what you would expect to get if you did the calculation manually. For that reason, this behavior will be modified in an upcoming version.</p>
 *
 * <h3>Caveat</h3>
 * <p>This annotation can only be calculated for sites for which at least one sample was genotyped as carrying a variant allele.</p>
 *
 * <h3>Related annotations</h3>
 * <ul>
 *     <li><b><a href="https://www.broadinstitute.org/gatk/guide/tooldocs/org_broadinstitute_gatk_tools_walkers_annotator_Coverage.php">Coverage</a></b> gives the filtered depth of coverage for each sample and the unfiltered depth across all samples.</li>
 *     <li><b><a href="https://www.broadinstitute.org/gatk/guide/tooldocs/org_broadinstitute_gatk_tools_walkers_annotator_DepthPerAlleleBySample.php">DepthPerAlleleBySample</a></b> calculates depth of coverage for each allele per sample (AD).</li>
 * </ul>
 */
public class AS_QualByDepth extends InfoFieldAnnotation implements ReducibleAnnotation, AS_StandardAnnotation {

    @Override
    public List<String> getKeyNames() { return Arrays.asList(GATKVCFConstants.AS_QUAL_BY_DEPTH_KEY); }

    @Override
    public String getRawKeyName() { return GATKVCFConstants.AS_QUAL_KEY; }

    public List<VCFInfoHeaderLine> getDescriptions() {
        //We only have the finalized key name here because the raw key is internal to GenotypeGVCFs and won't get output in any VCF
        return Arrays.asList(GATKVCFHeaderLines.getInfoLine(getKeyNames().get(0)));
    }

    public Map<String, Object> annotate(final RefMetaDataTracker tracker,
                                        final AnnotatorCompatible walker,
                                        final ReferenceContext ref,
                                        final Map<String, AlignmentContext> stratifiedContexts,
                                        final VariantContext vc,
                                        final Map<String, PerReadAlleleLikelihoodMap> perReadAlleleLikelihoodMap ) {
        return null;
    }

    private List<Integer> getAlleleDepths(final GenotypesContext genotypes) {
        int numAlleles = -1;
        for (final Genotype genotype : genotypes) {
            if (genotype.hasAD()) {
                numAlleles = genotype.getAD().length;
                break;
            }
        }
        if (numAlleles == -1) //no genotypes have AD
            return null;
        Integer[] alleleDepths = new Integer[numAlleles];
        for (int i = 0; i < alleleDepths.length; i++) {
            alleleDepths[i] = 0;
        }
        for (final Genotype genotype : genotypes) {
            // we care only about genotypes with variant alleles
            if ( !genotype.isHet() && !genotype.isHomVar() )
                continue;

            // if we have the AD values for this sample, let's make sure that the variant depth is greater than 1!
            if ( genotype.hasAD() ) {
                final int[] AD = genotype.getAD();
                final int totalADdepth = (int) MathUtils.sum(AD);
                if ( totalADdepth - AD[0] > 1 ) {
                    for (int i = 0; i < AD.length; i++) {
                        alleleDepths[i] += AD[i];
                    }
                }
            }
        }
        return Arrays.asList(alleleDepths);
    }

    @Override
    public Map<String, Object> annotateRawData(RefMetaDataTracker tracker, AnnotatorCompatible walker, ReferenceContext ref, Map<String, AlignmentContext> stratifiedContexts, VariantContext vc, Map<String, PerReadAlleleLikelihoodMap> stratifiedPerReadAlleleLikelihoodMap) {
        return null;
    }

    @Override
    public Map<String, Object> combineRawData(List<Allele> allelesList, List<? extends ReducibleAnnotationData> listOfRawData) {
        return null;
    }

    @Override
    public Map<String, Object> finalizeRawData(VariantContext vc, VariantContext originalVC) {
        //we need to use the AS_QUAL value that was added to the VC by the GenotypingEngine
        if ( !vc.hasAttribute(GATKVCFConstants.AS_QUAL_KEY) )
            return null;

        final GenotypesContext genotypes = vc.getGenotypes();
        if ( genotypes == null || genotypes.isEmpty() )
            return null;

        final List<Integer> standardDepth = getAlleleDepths(genotypes);

        //Parse the VC's allele-specific qual values
        List<Object> alleleQualObjList = vc.getAttributeAsList(GATKVCFConstants.AS_QUAL_KEY);
        if (alleleQualObjList.size() != vc.getNAlleles() -1)
            throw new IllegalStateException("Number of AS_QUAL values doesn't match the number of alternate alleles.");
        List<Double> alleleQualList = new ArrayList<>();
        for (final Object obj : alleleQualObjList) {
            alleleQualList.add(Double.parseDouble(obj.toString()));
        }

        // Don't normalize indel length for AS_QD because it will only be called from GenotypeGVCFs, never UG
        List<Double> QDlist = new ArrayList<>();
        double refDepth = (double)standardDepth.get(0);
        for (int i = 0; i < alleleQualList.size(); i++) {
            double AS_QD = -10.0 * alleleQualList.get(i) / ((double)standardDepth.get(i+1) + refDepth); //+1 to skip the reference field of the AD, add ref counts to each to match biallelic case
            // Hack: see note in the fixTooHighQD method below
            AS_QD = QualByDepth.fixTooHighQD(AS_QD);
            QDlist.add(AS_QD);
        }

        final Map<String, Object> map = new HashMap<>();
        map.put(getKeyNames().get(0), AnnotationUtils.encodeValueList(QDlist, "%.2f"));
        return map;
    }

    @Override
    public void calculateRawData(VariantContext vc, Map<String, PerReadAlleleLikelihoodMap> pralm, ReducibleAnnotationData rawAnnotations) {
        //note that the "raw data" used here is calculated by the GenotypingEngine in GenotypeGVCFs and stored in the AS_QUAL info field
    }
}
