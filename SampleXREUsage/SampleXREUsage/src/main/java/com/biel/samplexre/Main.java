package com.biel.samplexre;

import java.io.File;

import com.biel.samplexre.reportmodel1.DealReport;
import com.biel.xre.generation.XHTMLReport;
import com.biel.xre.generation.exporting.pdf.PdfReportExporter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create and export reports
		// 1. Total oxidation WWTP sample
		// 2. Complex layout sample
		reportModel1();
	}
	public static void generateAndExport(XHTMLReport r){
		PdfReportExporter pre = new PdfReportExporter(r);
		pre.export(new File("exported"), r.getClass().getSimpleName().concat(".pdf"));
	}
	public static void reportModel1(){
		DealReport r = new DealReport();
		
		generateAndExport(r);
	}

}
