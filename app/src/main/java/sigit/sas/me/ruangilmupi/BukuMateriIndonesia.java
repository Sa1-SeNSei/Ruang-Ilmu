package sigit.sas.me.ruangilmupi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class BukuMateriIndonesia extends AppCompatActivity {
    PDFView BukuMateriIndonesia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_materi_indonesia);

        BukuMateriIndonesia=(PDFView) findViewById(R.id.pdfmateriIndonesia);

        BukuMateriIndonesia.fromAsset("BukuMateriIndonesiapdf.pdf").load();
    }
}
