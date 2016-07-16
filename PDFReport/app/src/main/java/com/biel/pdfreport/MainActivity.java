package com.biel.pdfreport;

import android.content.ActivityNotFoundException;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGeneratePDF = (Button) findViewById(R.id.btnGeneratePDF);
        btnGeneratePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfGenerator pdfGenerator = new PdfGenerator(getApplicationContext());
                ContextWrapper c = new ContextWrapper(getApplicationContext());
                File filesDir = c.getFilesDir();
                File file = pdfGenerator.generatePdf(filesDir, "sample.pdf");

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                try {
                    getApplicationContext().startActivity(intent);
                } catch (ActivityNotFoundException e) {

                }
            }
        });

    }
}
