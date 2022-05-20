package sigit.sas.me.ruangilmupi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class KuisIPA_UjianPenjelasan extends AppCompatActivity {
    PDFView BukuMateriIPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_ipa__ujian_penjelasan);

        BukuMateriIPA=(PDFView) findViewById(R.id.pdfmateriIPA);

        BukuMateriIPA.fromAsset("BukuMateriIPApdf.pdf").load();
    }
}
