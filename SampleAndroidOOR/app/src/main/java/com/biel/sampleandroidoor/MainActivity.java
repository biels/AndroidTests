package com.biel.sampleandroidoor;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.biel.xre.generation.XHTMLReport;
import com.biel.xre.generation.exporting.pdf.PdfReportExporter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java8.util.Optional;
import java8.util.StringJoiner;
import java8.util.function.BinaryOperator;
import java8.util.function.Function;
import java8.util.stream.Collectors;
import java8.util.stream.RefStreams;
import java8.util.stream.StreamSupport;

public class MainActivity extends AppCompatActivity {
    final static Logger l = LoggerFactory.getLogger(MainActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Integer> b = new ArrayList<>();
        b.add(8);
        b.add(9);
        b.add(15);
        Optional<String> result = StreamSupport.stream(b).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return 3 * integer;
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "N: " + integer;
            }
        }).reduce(new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + " - " + s2;
            }
        });
        Toast toast = Toast.makeText(getApplicationContext(), result.orElse("No text"), Toast.LENGTH_LONG);
        toast.show();

        generateSampleInvoiceReport();
        TextView textView = (TextView) findViewById(R.id.text);
        String path = new File("generated").getAbsolutePath();
        l.info(path);

        textView.setText(path);
    }
    public void generateSampleInvoiceReport(){
        l.info("Generating TodoListReport...");
        SampleInvoiceReport report = new SampleInvoiceReport();

        //Model filling
        SampleInvoiceReport.SampleInvoiceModel m = report.getModel();
        List<SampleInvoiceReport.SampleInvoiceModel.ProductInfo> products = RefStreams.of(
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
                }},
                m.new ProductInfo() {{
                    name = "Product 3";
                    description = "Description of the third product";
                    amount = 3;
                    price = 80;
                }}
        ).collect(Collectors.<SampleInvoiceReport.SampleInvoiceModel.ProductInfo>toList());
        report.getModel().getProductList().getList().addAll(products);

        //Generation
        File file = generateAndExport(report.getView());

        //Presentation
        openPdfFile(file);
    }
    public File generateAndExport(XHTMLReport r){
        PdfReportExporter pre = new PdfReportExporter(r);
        return pre.export(getExternalFilesDir(null), "exported", r.getClass().getSimpleName().concat(".pdf"));
    }
    public void openPdfFile(File pdfFile){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(pdfFile), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            getApplicationContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            String msg = "You don't have any application capable of opening pdf files";
            l.error(msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
