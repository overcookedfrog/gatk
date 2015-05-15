/*
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

package org.broadinstitute.gatk.tools.walkers.varianteval.evaluators;

import org.broadinstitute.gatk.utils.contexts.AlignmentContext;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.tools.walkers.varianteval.util.Analysis;
import org.broadinstitute.gatk.tools.walkers.varianteval.util.DataPoint;
import htsjdk.variant.vcf.VCFConstants;
import org.broadinstitute.gatk.utils.exceptions.ReviewedGATKException;
import htsjdk.variant.variantcontext.Allele;
import htsjdk.variant.variantcontext.VariantContext;

import java.util.Collection;
import java.util.Set;

/**
 * The Broad Institute
 * SOFTWARE COPYRIGHT NOTICE AGREEMENT
 * This software and its documentation are copyright 2009 by the
 * Broad Institute/Massachusetts Institute of Technology. All rights are reserved.
 * <p/>
 * This software is supplied without any warranty or guaranteed support whatsoever. Neither
 * the Broad Institute nor MIT can be responsible for its use, misuse, or functionality.
 */
@Analysis(description = "Assess site accuracy and sensitivity of callset against follow-up validation assay")
public class ValidationReport extends VariantEvaluator implements StandardEval {
    // todo -- note this isn't strictly allele away.  It's really focused on sites.  A/T call at a validated A/G site is currently counted as a TP
    @DataPoint(description = "nComp", format = "%d") public int nComp = 0;
    @DataPoint(description = "TP", format = "%d") public int TP = 0;
    @DataPoint(description = "FP", format = "%d") public int FP = 0;
    @DataPoint(description = "FN", format = "%d") public int FN = 0;
    @DataPoint(description = "TN", format = "%d") public int TN = 0;

    @DataPoint(description = "Sensitivity", format = "%.2f") public double sensitivity = 0;
    @DataPoint(description = "Specificity", format = "%.2f") public double specificity = 0;
    @DataPoint(description = "PPV", format = "%.2f") public double PPV = 0;
    @DataPoint(description = "FDR", format = "%.2f") public double FDR = 0;

    @DataPoint(description = "CompMonoEvalNoCall", format = "%d") public int CompMonoEvalNoCall = 0;
    @DataPoint(description = "CompMonoEvalFiltered", format = "%d") public int CompMonoEvalFiltered = 0;
    @DataPoint(description = "CompMonoEvalMono", format = "%d") public int CompMonoEvalMono = 0;
    @DataPoint(description = "CompMonoEvalPoly", format = "%d") public int CompMonoEvalPoly = 0;

    @DataPoint(description = "CompPolyEvalNoCall", format = "%d") public int CompPolyEvalNoCall = 0;
    @DataPoint(description = "CompPolyEvalFiltered", format = "%d") public int CompPolyEvalFiltered = 0;
    @DataPoint(description = "CompPolyEvalMono", format = "%d") public int CompPolyEvalMono = 0;
    @DataPoint(description = "CompPolyEvalPoly", format = "%d") public int CompPolyEvalPoly = 0;

    @DataPoint(description = "CompFiltered", format = "%d") public int CompFiltered = 0;
    @DataPoint(description = "Eval and comp have different alleles", format = "%d") public int nDifferentAlleleSites = 0;

    private static final boolean TREAT_ALL_SITES_IN_EVAL_VCF_AS_CALLED = true;
    private static final boolean REQUIRE_IDENTICAL_ALLELES = false;

    private enum SiteStatus { NO_CALL, FILTERED, MONO, POLY }

    // Counts of ValidationSiteStatus x CallSiteStatus
    final int[][] counts = new int[SiteStatus.values().length][SiteStatus.values().length];

    @Override public int getComparisonOrder() { return 2; }

    @Override
    public void finalizeEvaluation() {
        for ( SiteStatus x : SiteStatus.values() )
            CompFiltered += getCounts(SiteStatus.FILTERED, x);

        CompMonoEvalNoCall = getCounts(SiteStatus.MONO, SiteStatus.NO_CALL);
        CompMonoEvalFiltered = getCounts(SiteStatus.MONO, SiteStatus.FILTERED);
        CompMonoEvalMono = getCounts(SiteStatus.MONO, SiteStatus.MONO);
        CompMonoEvalPoly = getCounts(SiteStatus.MONO, SiteStatus.POLY);

        CompPolyEvalNoCall = getCounts(SiteStatus.POLY, SiteStatus.NO_CALL);
        CompPolyEvalFiltered = getCounts(SiteStatus.POLY, SiteStatus.FILTERED);
        CompPolyEvalMono = getCounts(SiteStatus.POLY, SiteStatus.MONO);
        CompPolyEvalPoly = getCounts(SiteStatus.POLY, SiteStatus.POLY);

        TP = CompPolyEvalPoly;
        FN = CompPolyEvalNoCall + CompPolyEvalFiltered + CompPolyEvalMono;
        FP = CompMonoEvalPoly;
        TN = CompMonoEvalNoCall + CompMonoEvalFiltered + CompMonoEvalMono;

        for ( SiteStatus x : SiteStatus.values() )
            for ( SiteStatus y : SiteStatus.values() )
                nComp += getCounts(x, y);

        if ( nComp != TP + FN + FP + TN + CompFiltered )
            throw new ReviewedGATKException("BUG: nComp != TP + FN + FP + TN + CompFiltered!");

        sensitivity = (100.0 * TP) / (TP + FN);
        specificity = (TN+FP > 0) ? (100.0 * TN) / (TN + FP) : 100.0;
        PPV = (100.0 * TP) / (TP + FP);
        FDR = (100.0 * FP) / (FP + TP);
    }

    private int getCounts(SiteStatus comp, SiteStatus eval) {
        return counts[comp.ordinal()][eval.ordinal()];
    }

    @Override
    public void update2(VariantContext eval, VariantContext comp, RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if ( comp != null ) { // we only need to consider sites in comp
            if ( REQUIRE_IDENTICAL_ALLELES && (eval != null && haveDifferentAltAlleles(eval, comp)))
                nDifferentAlleleSites++;
            else {
                SiteStatus evalStatus = calcSiteStatus(eval);
                final Set<String> evalSamples = getWalker().getSampleNamesForEvaluation();
                if ( comp.hasGenotypes() && ! evalSamples.isEmpty() && comp.hasGenotypes(evalSamples) )
                    // if we have genotypes in both eval and comp, subset comp down just the samples in eval
                    comp = comp.subContextFromSamples(evalSamples, false);
                SiteStatus compStatus = calcSiteStatus(comp);
                counts[compStatus.ordinal()][evalStatus.ordinal()]++;
            }
        }
    }

    //
    // helper routines
    //
    private SiteStatus calcSiteStatus(VariantContext vc) {
        if ( vc == null ) return SiteStatus.NO_CALL;
        if ( vc.isFiltered() ) return SiteStatus.FILTERED;
        if ( vc.isMonomorphicInSamples() ) return SiteStatus.MONO;
        if ( vc.hasGenotypes() ) return SiteStatus.POLY;  // must be polymorphic if isMonomorphicInSamples was false and there are genotypes

        if ( vc.hasAttribute(VCFConstants.ALLELE_COUNT_KEY) ) {
            int ac = 0;
            if ( vc.getNAlleles() > 2 ) {
                return SiteStatus.POLY;
            }
            else
                ac = vc.getAttributeAsInt(VCFConstants.ALLELE_COUNT_KEY, 0);
            return ac > 0 ? SiteStatus.POLY : SiteStatus.MONO;
        } else {
            return TREAT_ALL_SITES_IN_EVAL_VCF_AS_CALLED ? SiteStatus.POLY : SiteStatus.NO_CALL; // we can't figure out what to do
        }
    }



    private boolean haveDifferentAltAlleles(VariantContext eval, VariantContext comp) {
        Collection<Allele> evalAlts = eval.getAlternateAlleles();
        Collection<Allele> compAlts = comp.getAlternateAlleles();
        if ( evalAlts.size() != compAlts.size() ) {
            return true;
        } else {
            // same size => every alt from eval must be in comp
            for ( Allele a : evalAlts ) {
                if ( ! compAlts.contains(a) ) {
//                    System.out.printf("Different alleles: %s:%d eval=%s comp=%s\n\t\teval=%s\n\t\tcomp=%s%n",
//                            eval.getChr(), eval.getStart(), eval.getAlleles(), comp.getAlleles(), eval, comp);
                    return true;
                }
            }

            return false;
        }
    }
}
