/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 ("BROAD") and the LICENSEE and is effective at the date the downloading is completed ("EFFECTIVE DATE").
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
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system ("PHONE-HOME") which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2016 Broad Institute, Inc.
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

package org.broadinstitute.gatk.queue.qscripts.techdev

import org.broadinstitute.gatk.queue.QScript
import org.broadinstitute.gatk.utils.commandline.{Output, Argument, Hidden}
import org.broadinstitute.gatk.queue.util.QScriptUtils
import org.broadinstitute.gatk.queue.extensions.gatk._
import org.broadinstitute.gatk.queue.extensions.gatk.SplitByRG
import org.broadinstitute.gatk.queue.extensions.picard._
import htsjdk.samtools.{SAMReadGroupRecord, SAMFileReader, SAMFileHeader}
import org.broadinstitute.gatk.utils.baq.BAQ.CalculationMode
import collection.JavaConversions._
import org.broadinstitute.gatk.utils.exceptions.ReviewedGATKException
import htsjdk.samtools.SAMFileHeader.SortOrder
import org.broadinstitute.gatk.tools.walkers.indels.IndelRealigner.ConsensusDeterminationModel
import org.broadinstitute.gatk.tools.walkers.techdev.SplitByRG
import org.broadinstitute.gatk.utils.ValidationExclusion

class FullProcessingPipeline extends QScript {
  qscript =>

  @Input(doc="input BAM/FASTQ files -- one per -I, no bam lists",
    fullName="input", shortName="I", required=true)
  var input: Seq[File] = _

  @Argument(doc="BWA Read Group string -- one per -G same order as the -I inputs",
    fullName="read_group", shortName="G", required=false)
  var rg: Seq[String] = _

  @Argument(doc="if the input is list of paired fastq fils, it should be given without the _1.fq.gz or _2.fq.gz suffix",
    fullName="two_fastq_files_input", shortName="input2Files", required=false)
  var two_fastq_files: Boolean = false

  @Input(doc="Reference fasta file to process with",
    fullName="reference", shortName="R", required=false)
  var reference = new File("/seq/references/Homo_sapiens_assembly19/v1/Homo_sapiens_assembly19.fasta")

  @Input(doc="Alternative fasta file in case your input is not using the same reference as the processing pipeline target",
    fullName="alternative_reference", shortName = "AR", required = false)
  var alternative_reference: File = null

  @Input(doc="dbsnp ROD to use (must be in VCF format)",
    fullName="dbsnp", shortName="D", required=false)
  var dbSNP: Seq[File] = if (reference.getName.equals("/seq/references/Homo_sapiens_assembly19/v1/Homo_sapiens_assembly19.fasta")) Seq(new File("/humgen/gsa-hpprojects/GATK/bundle/current/b37/dbsnp_138.b37.vcf")) else null

  @Argument(doc="Final root name of the BAM file",
    fullName="project", shortName="p", required=false)
  var project: String = ""

  @Argument(doc="hard clip illumina adapter sequence",
    fullName="hard_clip_adapter", shortName="adapter", required=false)
  var clipAdapter:Boolean = false

  @Argument(doc="single ended fastq file",
    fullName="singleEndedfastQ", shortName="se", required=false)
  var singleEnded = false

  @Argument(doc="Mark Duplicates",
    fullName="mark_duplicates", shortName="dedup", required=false)
  var do_dedup = false

  @Argument(doc="Split N Cigar Reads",
    fullName="splitNCigarReads", shortName="splitReads", required=false)
  var splitNCigarReads = false


  @Argument(doc="sampleName",
    fullName="sampleName", shortName="sn", required=false)
  var argSampleName : String = "sample1"

  @Hidden
  @Argument(doc="Skip reverting the bam",
    fullName = "skip_revert", shortName = "skip_revert", required=false)
  var skip_revert: Boolean = false

  @Hidden
  @Argument (doc="use 2-pass STAR aliger",
    fullName = "use2passStarAligner", shortName = "stars", required = false, exclusiveOf = "useStarAligner")
  var use2PassStarAligner: Boolean = false

  @Hidden
  @Argument (doc="use 1-pass STAR aliger",
    fullName = "useStarAligner", shortName = "star", required = false, exclusiveOf = "use2passStarAligner")
  var use1passStarAligner: Boolean = false

  @Hidden
  @Argument (doc="the path to STAR aliger",
    fullName = "starAlignerPath", shortName = "starPath", required = false)
  var starAlingerPath: String = "/humgen/gsa-hpprojects/dev/ami/RNA/star/STAR_2.3.0e/"

  @Hidden
  @Argument (doc="the path to STAR genome dir",
    fullName = "starGenomeDir", shortName = "starGenomeDir", required = false)
  var starGenomeDir: String = "/humgen/gsa-hpprojects/dev/ami/RNA/star/hg19_broad/"


  @Hidden
  @Argument(doc="skip converting the bam file to fastq",
    fullName = "skip_convert_to_fastq", shortName = "skip_bam2fastq", required=false)
  var skip_bam2fastq: Boolean = false

  @Hidden
  @Argument(doc="only process the minimum possible to get an analizable bam",
    shortName="fly", required=false)
  var flyThrough = false

  @Hidden
  @Argument(doc="Number of threads to use with aligner",
    shortName="t", required=false)
  var threads = 8

  @Hidden
  @Argument(doc="How many ways to scatter/gather",
    fullName="scatter_gather", shortName="sg", required=false)
  var nContigs: Int = -1

  @Hidden
  @Argument(doc="Define the default platform for Count Covariates -- useful for techdev purposes only.",
    fullName="default_platform", shortName="dp", required=false)
  var defaultPlatform: String = ""

  @Hidden
  @Argument(doc="keep intermediate files",
    fullName="keepIntermediate", shortName="keepIntermediate", required=false)
  var keepIntermediateFiles = false

  @Hidden
  @Argument(doc = "chang MQ 255 to 60 (for TopHat output)",
    fullName = "change_MQ_255_to_60", shortName = "MQ255to60", required = false)
  var change255to60 = false

  @Hidden
  @Argument(doc = "Do not check that the bam samples names are the same. Use it when there is no RG info in the input",
    fullName = "doNotCheckSampleNames", shortName = "doNotCheckSampleNames", required = false)
  var doNotCheckSampleNames = false

  @Hidden
  @Argument(doc = "allow running in unsafe mode and keep cigar strings with N's",
    fullName = "allow_N_cigar_reads", shortName = "allow_Ns", required = false, exclusiveOf = "filter_N_cigar_reads")
  var allow_N_cigar_reads = false

  @Hidden
  @Argument(doc = "filter all reads with N's in their cigar string",
    fullName = "filter_N_cigar_reads", shortName = "filter_Ns", required = false, exclusiveOf = "allow_N_cigar_reads")
  var filter_N_cigar_reads = false

  @Hidden
  @Argument(doc = "fix mis-encoded quality scores",
    fullName = "fixMisencodedQualityScores", shortName = "fixQualityScores", required = false)
  var fixMisencodedQualityScores = false

 val cleaningModel: ConsensusDeterminationModel = ConsensusDeterminationModel.USE_READS

  def script() {
    // keep a record of the number of contigs in the first bam file in the list
    if (qscript.nContigs < 0)
      qscript.nContigs = QScriptUtils.getNumberOfContigs(qscript.input(0))

    val bams =
      if(!skip_bam2fastq)
      {
        if(!use2PassStarAligner && !use1passStarAligner){
          val fastqs_with_rgs = if (input(0).toString.endsWith(".bam")) {
            convert_to_fastq(revert_bam(splitIfMultipleReadGroups(input)))
          } else {
          input zip rg
          }

          // BAM files generated by the pipeline
          if(two_fastq_files) {
            println("here!!!!!!!!!!!!!!")
            align_2files(fastqs_with_rgs)
          }
          else
            (align_interleved(fastqs_with_rgs))
        }
        else{
          starAlign(input)
        }
      }
      else{
        input
      }


    // assert that all bams are from the same sample.
    val sampleName =
      if(doNotCheckSampleNames)
        qscript.argSampleName
      else
        getSampleName(input)

    val sortedBam  = new File(project + ".sorted.bam")
    val readyToRealign = splitRNAseqReadsIfNeeded(
          dedupIfNeeded(
           addRGIfNeeded(sortedBam,sampleName)))
    val cleanedBam = swapExt(readyToRealign, ".bam", ".clean.bam")
    val recalBam   = swapExt(cleanedBam, ".bam", ".recal.bam")
    //val reducedBam = swapExt(recalBam, ".bam", ".reduced.bam")

    // Accessory files
    val targetIntervals = new File(project + ".intervals")
    val recalFile       = new File(project + ".grp")

    add(
      merge(bams, sortedBam),
      target(readyToRealign, targetIntervals),
      clean(readyToRealign, targetIntervals, cleanedBam),
      bqsr(cleanedBam, recalFile),
      printreads(cleanedBam, recalFile, recalBam)
    )

    //if (do_RR) add(reduce(recalBam, reducedBam))

  }



  def dedupIfNeeded(bam: File) : File = {
    if (qscript.do_dedup) {
      val dedupedBam = swapExt(bam, ".bam", ".dedup.bam")
      val metricsFile = swapExt(bam, ".bam", ".metrics")
      add(dedup(bam, dedupedBam, metricsFile))
      dedupedBam
    }
    else {
      bam
    }
  }

  def addRGIfNeeded(bam: File, sampleName: String) : File = {
    if(use2PassStarAligner || use1passStarAligner || (input(0).toString.endsWith(".bam") && getReadGroupList(qscript.input(0)).size == 0)){
      val bamWithRG = swapExt(bam, ".bam", ".RGadded.bam")
      add(addRGInfo(bam,bamWithRG,sampleName))
      bamWithRG
    }
    else {
      bam
    }

  }

  def splitRNAseqReadsIfNeeded(bam: File) : File ={
    if (splitNCigarReads) {
      val splitReadsBam = swapExt(bam,".bam",".splitReads.bam")
      add(splitRNAseqReads(bam, splitReadsBam))
      splitReadsBam
    }
    else {
      bam
    }
  }


  /****************************************************************************
    * Helper methods
    ****************************************************************************/

  def splitIfMultipleReadGroups(bams: Seq[File]): Seq[(File, String)] = {
    var outBAMs: Seq[File] = Seq()
    var bwargs: Seq[String] = Seq()
    for (bam <- bams) {
      val rgs: Seq[SAMReadGroupRecord] = getReadGroupList(bam)
      bwargs ++= getBWAReadGroupLine(bam)
      assert (rgs.size > 0, "Bam file has no read group information, please add it before starting the reprocessing pipeline")
      assert (!QScriptUtils.hasMultipleSamples(rgs), "Bam file has multiple samples, this pipeline cannot handle that. Each bam file can only have one sample")

      // if we only have one read group, no need to split.
      if (rgs.size == 1) {
        outBAMs :+= bam
      }

      // produce the list of files for each read group (as produced by the walker) and convert it to Seq[File]
      else {
        val splitBAMs = getSplitBAMList(bam)
        outBAMs ++= splitBAMs // add the list of splitted bams to the return sequence
        add(split_rgs(bam, splitBAMs))
      }
    }
    outBAMs zip bwargs  // make a Seq[ (File, String) ] in beautiful scala syntax (the order should be exactly the same as SplitRG).
  }



  def getSplitBAMList(bam: File) : Seq[File] = {
    var splitBAMs: Seq[File] = Seq()
    val reader: SAMFileReader = new SAMFileReader(bam)
    for (file <- SplitByRG.getSplitFileNamesForRgs(reader.getFileHeader).values()) {
      splitBAMs :+= file
    }
    splitBAMs
  }

  /**
   * Reverts all input bam files using Picard's RevertSAM
   *
   * @param bams input bam files
   * @return a sequence of reverted bam files
   */
  def revert_bam(bams:Seq[(File, String)]) : Seq[(File, String)] = {
    var revBams: Seq[(File, String)] = Seq()
    for ( (bam, rg) <- bams) {
      if (skip_revert) {
        revBams :+= (bam, rg)
      }
      else {
        val revertedBAM = swapExt(bam, ".bam", ".reverted.bam")
        add(revert(bam, revertedBAM))
        revBams :+= (revertedBAM, rg)
      }
    }
    revBams
  }

  /**
   * converts bam files to interleaved fastq clipping adapters if necessary
   *
   * @param bams the input bams (should be reverted)
   * @return the sequence of interleaved fastq files and their read group strings in a tuple
   */
  def convert_to_fastq(bams:Seq[(File, String)]) : Seq[(File, String)] = {
    var fqs: Seq[(File, String)] = Seq()
    for ( (bam, rg) <- bams) {
      if (clipAdapter) {
        fqs :+= (picard_fq(bam), rg)
      }
      else {
        fqs :+= (htslib_fq(bam), rg)
      }
    }
    fqs
  }

  /**
   * alignment of interleaved fastq files
   *
   * Aligns all interleaved fastqs
   *
   * @param fqs a sequence of tuples (fastq file, read group string)
   * @return list of aligned sam files
   */
  def align_2files(fqs:Seq[(File, String)]) : Seq[File] = {
    var sams: Seq[File] = Seq()
    for ((fq, rg) <- fqs) {
      sams :+= align_fastq_2Files(fq, rg)
    }
    sams
  }


  /**
   * alignment of interleaved fastq files
   *
   * Aligns all interleaved fastqs
   *
   * @param fqs a sequence of tuples (fastq file, read group string)
   * @return list of aligned sam files
   */
  def align_interleved(fqs:Seq[(File, String)]) : Seq[File] = {
    var sams: Seq[File] = Seq()
    for ((fq, rg) <- fqs) {
      sams :+= align_fastq(fq, rg)
    }
    sams
  }

  /**
   * alignment of 1 or 2 fastq files with star
   *
   * Aligns 1 or 2 fastqs (single end or pair ends)
   *
   * @param fqs a sequence of fsatq files
   * @return list of aligned sam files
   */
  def starAlign(fqs:Seq[File]) : Seq[File] = {
    var sams: Seq[File] = Seq()
    //if (fqs.size > 2)
    //  throw ("when aligning with STAR input must be one or 2 fastq files")
    sams :+= star_align_fastq(fqs)
    sams
  }

  /**
   * convert to fastq without clipping adapters (using htslib)
   *
   * @param bam input bam
   * @return output interleaved fastq
   */
  def htslib_fq(bam: File): File = {
    val fq = swapExt(bam, ".bam", ".fq.gz")
    add(bam2fq(bam, fq))
    fq
  }

  /**
   * convert to fastq and clip adapter sequence (using picard)
   *
   * @param bam input bam
   * @return output interleaved fastq
   */
  def picard_fq(bam: File): File = {
    val queryBAM = swapExt(bam,".bam",".query.bam")
    val markedBAM = swapExt(bam,".bam",".adaptor_marked.bam")
    val fq = swapExt(bam,".bam",".clipped.fq")

    add (
      sortSam(bam, queryBAM, SortOrder.queryname),
      mark_adaptor(queryBAM, markedBAM),
      sam2fq(markedBAM, fq)
    )
    fq
  }


  /**
   * aligns pair end gziped fastq files (not interleaved)
   *
   * @param fq the fastq file without '_1.fq' or '_2.fq' suffix
   * @param rg the read group string
   * @return the aligned sam file
   */
  def align_fastq_2Files(fq: File, rg: String): File = {
    val suffix = "_1.fq.gz"
    val lastIndex = fq.getAbsolutePath.length - 11
    val baseName = fq.getAbsolutePath.substring(0,lastIndex)
    val alignedSam = swapExt(fq, suffix, ".aligned.sam")
    add(bwa_2files(fq, baseName+"_1.fastq.gz", baseName+"_2.fastq.gz", rg, alignedSam, qscript.threads))
    alignedSam
  }

  /**
   * aligns an interleaved fastq file
   *
   * @param fq the fastq file
   * @param rg the read group string
   * @return the aligned sam file
   */
  def align_fastq(fq: File, rg: String): File = {
    var suffix = ".fq"
    if(fq.getName.endsWith("gz"))
      suffix = ".fq.gz"
    val alignedSam = swapExt(fq, suffix, ".aligned.sam")
    add(bwa_interleaved(fq, rg, alignedSam, qscript.threads))
    alignedSam
  }

  /**
   * aligns fastq file/s with STAR
   *
   * param fqs the fastq file/s
   * @return the aligned sam file
   */
  def star_align_fastq(fqs: Seq[File]): File = {
    val alignedSam1pass = new File(project+".star.1pass.Aligned.out.sam")
    val SJ_file1pass = new File(project+".star.1pass.SJ.out.tab")
    val alignedSam2pass = new File(project+".star.2pass.Aligned.out.sam")
    val SJ_file2pass = new File(project+".star.2pass.SJ.out.tab")
    val dummyFile = new File("dummy")
    val star1pass = star(fqs, alignedSam1pass, SJ_file1pass, qscript.threads, false, new File("dd"))
    val starBuildGenome = star_buildGenome_2pass(star1pass.sjFile ,qscript.threads, dummyFile)
    val star2pass = star(fqs, alignedSam2pass, SJ_file2pass, qscript.threads, true, dummyFile)
    add(star1pass,
       starBuildGenome,
       star2pass)
    alignedSam2pass
  }


  /**
   *
   * parses the read group line from a bam file and returns all it's read groups
   * in the string format used by BWA
   *
   * @param bam the input bam file
   * @return a list of all read groups
   */
  def getBWAReadGroupLine (bam:File): Seq[String] = {
    var rgs: Seq[String] = Seq()
    for (rg: SAMReadGroupRecord <- getReadGroupList(bam)) {
      val id = "@RG\tID:" + rg.getId
      val lb = if (rg.getLibrary != null) {"\\tLB:" + rg.getLibrary} else {""}
      val pl = if (rg.getPlatform != null) {"\\tPL:" + rg.getPlatform} else {""}
      val pu = if (rg.getPlatformUnit != null) {"\\tPU:" + rg.getPlatformUnit} else {""}
      val sm = if (rg.getSample != null) {"\\tSM:" + rg.getSample} else {""}
      val cn = if (rg.getSequencingCenter != null) {"\\tCN:" + rg.getSequencingCenter} else {""}
      val ds = if (rg.getDescription != null) {"\\tDS:" + rg.getDescription} else {""}

      rgs :+= "'" + id + lb + pl + pu + sm + cn + ds + "'" // we only do 1 readgroup per bam file
    }
    rgs
  }

  /**
   * Extracts the sample name from all BAM files and checks that they all match
   * (in this pipeline, all bams must be from the same sample -- run multiple samples in parallel processess)
   *
   * @param bams all input bams
   * @return the sample name
   * @throws ReviewedGATKException if the sample names are not the same across all files
   */
  def getSampleName (bams:Seq[File]): String = {
    val sample = getReadGroupList(bams(0))(0).getSample  // first read group of the first bam file in the list -- happy to blow up if this fails.
    for (bam <- bams) {
      for (rg: SAMReadGroupRecord <- getReadGroupList(bam)) {
        if (rg.getSample != sample)
          throw new ReviewedGATKException(String.format("BAM file %s contains multiple samples, this pipeline cannot handle that", bam.getName))
      }
    }
    sample
  }

  /**
   * Gets the list of read groups from a BAM file (converts it neatly to a scala Sequence)
   *
   * @param bam the input bam file
   * @return a sequence of read group records
   */
  def getReadGroupList(bam:File): Seq[SAMReadGroupRecord] = {
    val samReader = new SAMFileReader(bam)
    val header = samReader.getFileHeader
    header.getReadGroups
  }

  case class bam2fq (@Input inBam: File, @Output outFQ: File) extends CommandLineFunction with ExternalCommonArgs {
    def commandLine = "htscmd bamshuf -uOn 128 " + inBam + " " + outFQ + ".tmp" + " | htscmd bam2fq -a - | gzip > " + outFQ
    this.memoryLimit = 8
    this.analysisName = "FastQ"
  }

  case class bwa_interleaved (@Input inFQ: File, inRG: String, @Output outSAM: File, threads: Int) extends CommandLineFunction with ExternalCommonArgs{
    def se_pe_option :String = if (singleEnded) "" else " -p "
    def commandLine = "bwa mem "+ se_pe_option +" -M -t " + threads + " -R '" + inRG + "' " + reference + " " + inFQ + " > " + outSAM
    this.memoryLimit = 8
    this.nCoresRequest = threads
    this.analysisName = "BWA"
  }

  case class bwa_2files (@Input inFQ: File, inFQ1: String, inFQ2: String, inRG: String, @Output outSAM: File, threads: Int) extends CommandLineFunction with ExternalCommonArgs{
    def commandLine = "bwa mem -M -t " + threads + " -R '" + inRG + "' " + reference + " " + inFQ1 + " " + inFQ2 + " > " + outSAM
    this.memoryLimit = 8
    this.nCoresRequest = threads
    this.analysisName = "BWA"
  }


  case class star (@Input inFQs: Seq[File], @Output outSAM: File, @Output sjFile: File, threads: Int, secondPass: Boolean, @Input dummyFile: File) extends CommandLineFunction with ExternalCommonArgs{
    var genomeDir : String = ""
    if (secondPass)
      genomeDir =  "Genome-2-pass"
    else
      genomeDir = qscript.starGenomeDir
    var fastq_string: String = ""
    for(file:File <- inFQs){
      logger.info("addind fastq file: "+file.getName())
      val new_fastq_string = fastq_string + " " + file.getName()
      fastq_string = new_fastq_string
    }
    var pass = ""
    if (secondPass)
      pass = "2pass."
    else
      pass = "1pass."
    def commandLine = starAlingerPath + "STAR --genomeDir "+genomeDir+" --readFilesIn "+fastq_string+" --outFileNamePrefix "+project+".star." + pass
  }

  case class star_buildGenome_2pass (@Input sjFile: File, threads: Int, @Output dummyFile: File) extends CommandLineFunction with ExternalCommonArgs{
    def commandLine = "mkdir -p Genome-2-pass ; "+ starAlingerPath + "STAR --runMode genomeGenerate --genomeDir $PWD/Genome-2-pass --genomeFastaFiles "+ qscript.reference +" --sjdbFileChrStartEnd "+sjFile+" --sjdbOverhang 75"
  }

  case class mark_adaptor(@Input inBAM: File, @Output outBAM: File) extends CommandLineFunction with ExternalCommonArgs {
    def commandLine = "java -Dsamjdk.compression_level=1 -XX:GCTimeLimit=50 -XX:GCHeapFreeLimit=10 -Xmx4000m -jar /seq/software/picard/current/bin/MarkIlluminaAdapters.jar INPUT=" + inBAM + " OUTPUT=" + outBAM + " PE=true ADAPTERS=DUAL_INDEXED M=" + outBAM + ".adapter_metrics"
    this.memoryLimit = 4
    this.analysisName = "ADAPTER"
  }


  /****************************************************************************
    * Classes (GATK Walkers)
    ****************************************************************************/

  // General arguments to non-GATK tools
  trait ExternalCommonArgs extends CommandLineFunction {
    this.memoryLimit = 4
    if(keepIntermediateFiles)
      this.isIntermediate = false
    else
      this.isIntermediate = true
  }

  // General arguments to GATK walkers
  trait CommandLineGATKArgs extends CommandLineGATK with ExternalCommonArgs {
    this.reference_sequence = qscript.reference
    if(qscript.change255to60)
      this.read_filter :+= "ReassignOneMappingQuality"
    if(allow_N_cigar_reads)
      this.unsafe = ValidationExclusion.TYPE.ALLOW_N_CIGAR_READS

  }

  trait SAMargs extends PicardBamFunction with ExternalCommonArgs {
    this.maxRecordsInRam = 100000
  }

  trait SplitByRGAltRefMixin extends CommandLineGATK with ExternalCommonArgs {
    this.reference_sequence = if (qscript.alternative_reference != null) { qscript.alternative_reference} else {reference_sequence}
  }


  case class revert (inBam: File, outBam: File) extends RevertSam with SAMargs {
    this.output = outBam
    this.input :+= inBam
  }

  case class sam2fq (inBAM: File, outFQ: File) extends SamToFastq with SAMargs {
    this.input :+= inBAM
    this.fastq = outFQ
    this.interleave = true
    this.clippingAction = "X"
    this.clippingAttribute = "XT"
  }

  case class sortSam (inBam: File, outBam: File, sortOrderP: SortOrder) extends SortSam with SAMargs {
    this.input :+= inBam
    this.output = outBam
    this.sortOrder = sortOrderP
  }

  case class merge (inBams: Seq[File], outBam: File) extends MergeSamFiles with SAMargs {
    this.input = inBams
    this.output = outBam
    this.sortOrder = SAMFileHeader.SortOrder.coordinate
  }

  case class addRGInfo (inBam: File, outBam: File, sampleName: String) extends AddOrReplaceReadGroups with SAMargs {
    this.input :+= inBam
    this.output = outBam
    this.RGID = "1"
    this.RGPL = "illumina"
    this.RGLB = "bar"
    this.RGPU = "run"
    this.RGSM = sampleName

  }

//  This is how this should be if Queue accepted a list of outputs... unfortunately it doesn't
//
  case class split_rgs(inBam: File, @Output outBams: Seq[File]) extends org.broadinstitute.gatk.queue.extensions.gatk.SplitByRG with CommandLineGATKArgs {
    this.input_file :+= inBam
  }

  case class dedup (inBam: File, outBam: File, metricsFile: File) extends MarkDuplicates with ExternalCommonArgs {
    this.input :+= inBam
    this.output = outBam
    this.metrics = metricsFile
  }

  case class splitRNAseqReads(inBam: File, outBam: File) extends SplitNCigarReads with CommandLineGATKArgs {
    this.input_file :+= inBam
    this.out = outBam
    this.scatterCount = nContigs
    if(fixMisencodedQualityScores)
      this.fix_misencoded_quality_scores = true
    if(!allow_N_cigar_reads)  //we must allow N in the cigar string for RNA data, but we add it here just if it was not added for all the other walkers
      this.unsafe = ValidationExclusion.TYPE.ALLOW_N_CIGAR_READS
  }

  case class target (inBams: File, outIntervals: File) extends RealignerTargetCreator with CommandLineGATKArgs {
    this.input_file :+= inBams
    this.out = outIntervals
    this.mismatchFraction = 0.0
    if(qscript.dbSNP != null)
      this.known ++= qscript.dbSNP
    this.scatterCount = nContigs
    if (filter_N_cigar_reads)
      this.filter_reads_with_N_cigar = true
  }

  case class clean (inBams: File, tIntervals: File, outBam: File) extends IndelRealigner with CommandLineGATKArgs {
    this.input_file :+= inBams
    this.targetIntervals = tIntervals
    this.out = outBam
    this.dcov = 250
    if(qscript.dbSNP != null)
      this.known ++= qscript.dbSNP
    this.consensusDeterminationModel = qscript.cleaningModel
    this.compress = 0
    this.read_filter :+= "BadCigar"
    this.filter_bases_not_stored = true
    this.scatterCount = nContigs
  }

  case class bqsr (inBam: File, outRecalFile: File) extends BaseRecalibrator with CommandLineGATKArgs {
    if (qscript.dbSNP != null)
      this.knownSites ++= qscript.dbSNP
    else
      this.run_without_dbsnp_potentially_ruining_quality = true
    this.covariate ++= Seq("ReadGroupCovariate", "QualityScoreCovariate", "CycleCovariate", "ContextCovariate")
    this.input_file :+= inBam
    this.out = outRecalFile
    if (!defaultPlatform.isEmpty) this.default_platform = defaultPlatform
    if (qscript.flyThrough) {this.intervalsString :+= "1"}
    this.scatterCount = nContigs
  }

  case class printreads (inBam: File, inRecalFile: File, outBam: File) extends PrintReads with CommandLineGATKArgs {
    this.input_file :+= inBam
    this.BQSR = inRecalFile
    this.baq = CalculationMode.CALCULATE_AS_NECESSARY
    this.out = outBam
    this.scatterCount = nContigs
    this.isIntermediate = false
  }

//  case class reduce (inBam: File, outBam: File) extends ReduceReads with CommandLineGATKArgs {
//    this.input_file :+= inBam
//    this.out = outBam
//    this.scatterCount = nContigs
//    this.isIntermediate = false
//    this.memoryLimit = 8
//  }
}