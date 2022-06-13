package sigit.sas.me.ruangilmupi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class KuisPembahasanINDO_Ujian extends AppCompatActivity {
    PDFView SoalPembahasanIndo_Ujian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_pembahasan_indo__ujian);

        SoalPembahasanIndo_Ujian=(PDFView) findViewById(R.id.pdfpembahasanINDO_Ujian);

        SoalPembahasanIndo_Ujian.fromAsset("Pembahasan_B.Indo_Ujian.pdf").load();
    }
}
