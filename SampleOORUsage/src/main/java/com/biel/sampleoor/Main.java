package com.biel.sampleoor;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biel.sampleoor.reportmodel1.ExtendedTodoListReport;
import com.biel.sampleoor.reportmodel1.TodoListReport;
import com.biel.sampleoor.reportmodel2.SampleInvoiceReport;
import com.biel.sampleoor.reportmodel2.SampleInvoiceReport.SampleInvoiceModel;
import com.biel.sampleoor.reportmodel2.SampleInvoiceReport.SampleInvoiceModel.ProductInfo;
import com.biel.xre.generation.XHTMLReport;
import com.biel.xre.generation.exporting.pdf.PdfReportExporter;

public class Main {
	final static Logger l = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		generateSampleInvoiceReport();
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
	public static void generateSampleInvoiceReport(){
		l.info("Generating TodoListReport...");
		SampleInvoiceReport report = new SampleInvoiceReport();
		//Model filling
		SampleInvoiceModel m = report.getModel();
		Stream.of(
				m.new ProductInfo() {{ 
					name = "Product 1";
					description = "Description of the first product";
					amount = 4;
					price = 50;
				}},
				m.new ProductInfo() {{ 
					name = "Product 2";
					description = "Description of the second product";
					amount = 3;
					price = 80;
				}} 
				)
		.forEach(p -> m.getProductList().getList().add(p));


		//Generation
		generateAndExport(report.getView());
	}
}
