package com.zaman.pdfdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;


public class MainActivity extends AppCompatActivity {

    public PDFView pdfView;
    public float zoomValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("Android Socket Programming.pdf")
                // .spacing(10)
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)

                .enableDoubletap(true)
                .defaultPage(0)
                .load();
    }

    public void nextPage(View view) {

        pdfView.jumpTo(pdfView.getCurrentPage() + 1, true);
    }

    public void prevPage(View view) {

        pdfView.jumpTo(pdfView.getCurrentPage() - 1, true);
    }

    public void zoomIn(View view) {
        ++zoomValue;
        pdfView.zoomTo(zoomValue);
        pdfView.loadPages();

    }

    public void zoomOut(View view) {

        if (zoomValue != 1) {
            --zoomValue;
            pdfView.zoomTo(zoomValue);
            pdfView.loadPages();
        }

    }
}