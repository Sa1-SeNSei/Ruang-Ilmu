package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class BukuMateri extends AppCompatActivity {
    Animation myAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_materi);

        myAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);


        Button btn_modul_materi_ipa = (Button) findViewById(R.id.btn_modul_materi_ipa);
        btn_modul_materi_ipa.setOnClickListener(new View.OnClickListener() {
            public void onClick (View argo) {
                Intent i=new Intent(getApplicationContext(), BukuMateriIPA.class);
                startActivity(i);
            }
        });

        Button btn_modul_materi_mtk = (Button) findViewById(R.id.btn_modul_materi_mtk);
        btn_modul_materi_mtk.setOnClickListener(new View.OnClickListener() {
            public void onClick (View argo) {
                Intent i=new Intent(getApplicationContext(), BukuMateriMTK.class);
                startActivity(i);
            }
        });

        Button btn_modul_materi_indonesia = (Button) findViewById(R.id.btn_modul_materi_indo);
        btn_modul_materi_indonesia.setOnClickListener(new View.OnClickListener() {
            public void onClick (View argo) {
                Intent i=new Intent(getApplicationContext(), BukuMateriIndonesia.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);
    }


    Boolean intentInitialize;

    @Override
    protected void onResume() {
        soundManager.resume();
        intentInitialize = false;
        super.onResume();

    }

    @Override
    protected void onPause() {
        if (!intentInitialize) {
            soundManager.pause();
        }
        super.onPause();
    }

    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }

}
