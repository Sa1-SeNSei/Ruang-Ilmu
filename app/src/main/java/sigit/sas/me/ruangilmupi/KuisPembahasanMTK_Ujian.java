package sigit.sas.me.ruangilmupi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class KuisPembahasanMTK_Ujian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_pembahasan_mtk__ujian);
        PDFView SoalPembahasanMTK_Ujian = (PDFView) findViewById(R.id.pdfpembahasanMTK_Ujian);

        SoalPembahasanMTK_Ujian.fromAsset("Pembahasan_MTK_Ujian.pdf").load();
    }
}
