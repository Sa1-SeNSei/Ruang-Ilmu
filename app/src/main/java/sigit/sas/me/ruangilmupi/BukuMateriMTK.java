package sigit.sas.me.ruangilmupi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class BukuMateriMTK extends AppCompatActivity {
    PDFView BukuMateriMTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_materi_mtk);

        BukuMateriMTK=(PDFView) findViewById(R.id.pdfmateriMTK);

        BukuMateriMTK.fromAsset("BukuMateriMTKpdf.pdf").load();
    }
}
