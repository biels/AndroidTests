package com.biel.sampleoor;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biel.sampleoor.reportmodel1.ExtendedTodoListReport;
import com.biel.sampleoor.reportmodel1.TodoListReport;
import com.biel.xre.generation.XHTMLReport;
import com.biel.xre.generation.exporting.pdf.PdfReportExporter;

public class Main {
	final static Logger l = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		generateTodoListReport();
		generateExtendedTodoListReport();

	}
	public static void generateAndExport(XHTMLReport r){
		PdfReportExporter pre = new PdfReportExporter(r);
		pre.export(new File("exported"), r.getClass().getSimpleName().concat(".pdf"));
	}
	public static void generateTodoListReport(){
		l.info("Generating TodoListReport...");
		TodoListReport report = new TodoListReport();
		//Model filling
		report.getModel().getTodoList().addAll(Arrays.asList("Work 1", "Work 2", "Other things"));
		//Generation
		generateAndExport(report.getView());
	}
	public static void generateExtendedTodoListReport(){
		l.info("Generating ExtendedTodoListReport...");
		ExtendedTodoListReport report = new ExtendedTodoListReport();
		//Model filling
		report.getModel().getTodoList().addAll(Arrays.asList("Work 1", "Work 2", "Other things"));
		report.getModel().getCompletion().addAll(Arrays.asList(11,33,85));
		//Generation
		generateAndExport(report.getView());
	}
}
