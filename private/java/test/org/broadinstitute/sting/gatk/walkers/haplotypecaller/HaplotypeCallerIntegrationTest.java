package org.broadinstitute.sting.gatk.walkers.haplotypecaller;

import org.broadinstitute.sting.WalkerTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class HaplotypeCallerIntegrationTest extends WalkerTest {
    final static String REF = b37KGReference;
    final String NA12878_BAM = validationDataLocation + "NA12878.HiSeq.b37.chr20.10_11mb.bam";
    final String CEUTRIO_BAM = validationDataLocation + "CEUTrio.HiSeq.b37.chr20.10_11mb.bam";
    final String INTERVALS_FILE = validationDataLocation + "NA12878.HiSeq.b37.chr20.10_11mb.test.intervals";
    final String RECAL_FILE = validationDataLocation + "NA12878.kmer.7.subset.recal_data.csv";

    private void HCTest(String bam, String args, String md5) {
        final String base = String.format("-T HaplotypeCaller -R %s -I %s -L %s -recalFile %s", REF, bam, INTERVALS_FILE, RECAL_FILE) + " -NO_HEADER -o %s";
        final WalkerTestSpec spec = new WalkerTestSpec(base + " " + args, Arrays.asList(md5));
        executeTest("testHaplotypeCaller: args=" + args, spec);
    }

    @Test(enabled = false)
    public void testHaplotypeCallerMultiSample() {
        HCTest(CEUTRIO_BAM, "-rf UnmappedRead", "0884d3d07942d65c02d58044d01ec437");
    }

    @Test(enabled = false)
    public void testHaplotypeCallerSingleSample() {
        HCTest(NA12878_BAM, "-rf UnmappedRead", "9bb2bb8e5ed08eca1345c5d86721b47b");
    }
}
