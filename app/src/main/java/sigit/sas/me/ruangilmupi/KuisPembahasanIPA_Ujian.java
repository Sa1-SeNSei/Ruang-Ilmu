package sigit.sas.me.ruangilmupi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class KuisPembahasanIPA_Ujian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_pembahasan_ipa__ujian);
        PDFView SoalPembahasanIPA_Ujian = (PDFView) findViewById(R.id.pdfpembahasanIPA_Ujian);

        SoalPembahasanIPA_Ujian.fromAsset("Pembahasan_IPA_Ujian.pdf").load();
    }
}
