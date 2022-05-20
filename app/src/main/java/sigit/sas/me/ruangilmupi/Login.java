package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText inputNama;
    Button btnLanjut;
    Animation myAnim;
    final String QUIZ_AKU_USERNAME= "me.sigitari.mtksd.username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputNama = (EditText) findViewById(R.id.inputNama);

        btnLanjut = (Button) findViewById(R.id.btn_lanjut);

        myAnim = AnimationUtils.loadAnimation(this, R.anim.grind);

        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");

        if(!namaTersimpan.equals("0")){
//            inputUmur.setSelection(umurTersimpan-10);
            inputNama.setText(namaTersimpan);

        }
    }
    public void lanjutClick(View v){
        btnLanjut.startAnimation(myAnim);

        if(inputNama.getText().toString().matches(".+")) {
            String namaUser = inputNama.getText().toString();

            SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = userData.edit();
//            Intent svc=new Intent(this, soundManager.class);

            boolean BGM = userData.getBoolean(getString(R.string.QUIZ_AKU_BGM), true);
            soundManager.start(getApplicationContext());



            boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX),true);
            if(sfxOn){
                editor.putBoolean(getString(R.string.QUIZ_AKU_SFX),true);
                editor.commit();
            }

            //SCORE IPA
            int skoreIPA_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
            editor.commit();
            if (skoreIPA_lat1 == 0) {
                editor.putInt(getString(R.string.SCORE_IPA_Latihan1), 0);
                editor.commit();
            }
            int skoreIPA_lat2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
            editor.commit();
            if (skoreIPA_lat2 == 0) {
                editor.putInt(getString(R.string.SCORE_IPA_Latihan2), 0);
                editor.commit();
            }
            int skoreIPA_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);
            editor.commit();
            if (skoreIPA_ujian == 0) {
                editor.putInt(getString(R.string.SCORE_IPA_Ujian), 0);
                editor.commit();
            }
            //SCORE MTK
            int skoreMTK_lat1 = userData.getInt(getString(R.string.SCORE_MTK_Latihan1), 0);
            editor.commit();
            if (skoreMTK_lat1 == 0) {
                editor.putInt(getString(R.string.SCORE_MTK_Latihan1), 0);
                editor.commit();
            }
            int skoreMTK_lat2 = userData.getInt(getString(R.string.SCORE_MTK_Latihan2), 0);
            editor.commit();
            if (skoreMTK_lat2 == 0) {
                editor.putInt(getString(R.string.SCORE_MTK_Latihan2), 0);
                editor.commit();
            }
            int skoreMTK_ujian = userData.getInt(getString(R.string.SCORE_MTK_Ujian), 0);
            editor.commit();
            if (skoreMTK_ujian == 0) {
                editor.putInt(getString(R.string.SCORE_MTK_Ujian), 0);
                editor.commit();
            }
            //SCORE INDO
            int skoreINDO_lat1 = userData.getInt(getString(R.string.SCORE_INDO_Latihan1), 0);
            editor.commit();
            if (skoreINDO_lat1 == 0) {
                editor.putInt(getString(R.string.SCORE_INDO_Latihan1), 0);
                editor.commit();
            }
            int skoreINDO_lat2 = userData.getInt(getString(R.string.SCORE_INDO_Latihan2), 0);
            editor.commit();
            if (skoreINDO_lat2 == 0) {
                editor.putInt(getString(R.string.SCORE_INDO_Latihan2), 0);
                editor.commit();
            }
            int skoreINDO_ujian = userData.getInt(getString(R.string.SCORE_INDO_Ujian), 0);
            editor.commit();
            if (skoreINDO_ujian == 0) {
                editor.putInt(getString(R.string.SCORE_INDO_Ujian), 0);
                editor.commit();
            }
            int level = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
            if (level == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
                editor.commit();
            }

            int SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL1), -1);
            editor.commit();
            if (SOAL == -1) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL1), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL2), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL2), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL3), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL3), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL4), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL4), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL5), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL5), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL6), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL6), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL7), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL7), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL8), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL8), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL9), -1);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_SOAL9), -1);
                editor.commit();
            }

            SOAL = userData.getInt(getString(R.string.QUIZ_AKU_PROGRESS), 0);
            if (SOAL == 0) {
                editor.putInt(getString(R.string.QUIZ_AKU_PROGRESS), 0);
                editor.commit();
            }

            editor.putString(getString(R.string.QUIZ_AKU_USERNAME), namaUser);
            editor.commit();


            Intent intent;
            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Isi semua data diri anda",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);

    }
}