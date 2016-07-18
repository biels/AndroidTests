package com.biel.pdfreport;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.util.Log;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Biel on 16/7/2016.
 */
public class PdfGenerator {
    private final String TAG;
    Context ctx;

    public PdfGenerator(Context ctx) {
        this.ctx = ctx;
        TAG = getClass().getName();
    }

    public File generatePdf(File dir, String fileName) {

        if(!dir.exists())dir.mkdir();
        File file = new File(dir.getPath() + File.separator + fileName);
        Document document = new Document(PageSize.A4);
        Log.i(TAG, file.getAbsolutePath());

        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
            try {
                generateDocument(pdfWriter, document, getXML());
                return file;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       return null;

    }
    protected void generateDocument(PdfWriter pdfWriter,Document document, String xml) throws IOException {
        document.open();
        document.addAuthor("Application");
        document.addCreator(ApplicationInfo.CREATOR.toString());
        document.addTitle("Title");
        document.addCreationDate();
        document.addSubject("T");
        XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
        xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(xml));
        document.close();
        Log.i(TAG, "PDF document generated");
    }
    protected String getXML(){
        DepositReport report = new DepositReport();
        return report.getXML();
    }
}
