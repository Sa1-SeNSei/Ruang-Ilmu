package sigit.sas.me.ruangilmupi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Akun extends AppCompatActivity {


    Animation myAnim;
    SharedPreferences userData;
    SharedPreferences.Editor editor;
    Integer score, levelku;
    Integer score_ipa_lat1,score_ipa_lat2,score_ipa_ujian;
    Integer score_mtk_lat1,score_mtk_lat2,score_mtk_ujian;
    Integer score_indo_lat1,score_indo_lat2,score_indo_ujian;


    Integer point_exp;
    ProgressBar progressbar;



    Integer nilaibobot;
    //    Integer umur;
    String namaTersimpan;
    //    Boolean gender;

    TextView namaAkun, skor;

    TextView skore_ipa_lat1,skore_ipa_lat2,skore_ipa_ujian;
    TextView skore_mtk_lat1,skore_mtk_lat2,skore_mtk_ujian;
    TextView skore_indo_lat1,skore_indo_lat2,skore_indo_ujian;

    Boolean bgm,sfx;


    ImageView levelImage;

    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        intentInitialize = false;

        inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        levelImage = (ImageView) findViewById(R.id.level);
        editor = userData.edit();
        score = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);

        score_ipa_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        score_ipa_lat2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);

        score_ipa_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        score_ipa_lat2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);

        score_ipa_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        score_ipa_lat2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);


        //Progress bar EXP point
        point_exp = userData.getInt(getString(R.string.Point_EXP), 0);


        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");

        bgm = userData.getBoolean(getString(R.string.QUIZ_AKU_BGM),false);
        sfx = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX),false);

        namaAkun = (TextView) findViewById(R.id.namaAkun);
        skore_ipa_lat1 = (TextView) findViewById(R.id.score_ipa_latihan1);
        skore_ipa_lat2 = (TextView) findViewById(R.id.score_ipa_latihan2);
        skore_ipa_ujian = (TextView) findViewById(R.id.score_ipa_ujian);

        skore_mtk_lat1 = (TextView) findViewById(R.id.score_mtk_latihan1);
        skore_mtk_lat2 = (TextView) findViewById(R.id.score_mtk_latihan2);
        skore_mtk_ujian = (TextView) findViewById(R.id.score_mtk_ujian);

        skore_indo_lat1 = (TextView) findViewById(R.id.score_indo_latihan1);
        skore_indo_lat2 = (TextView) findViewById(R.id.score_indo_latihan2);
        skore_indo_ujian = (TextView) findViewById(R.id.score_indo_ujian);

        namaAkun.setText(namaTersimpan.toString());
        skore_ipa_lat1.setText(score_ipa_lat1.toString());
        skore_ipa_lat2.setText(score_ipa_lat2.toString());
        skore_ipa_ujian.setText(score_ipa_ujian.toString());



        switch (levelku)
        {
            case 0:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level1, null));
                break;
            case 1:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level2, null));
                break;
            case 2:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level3, null));
                break;
            case 3:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level4, null));
                break;
            case 4:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level5, null));
                break;
            case 5:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level6, null));
                break;
            case 6:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level7, null));
                break;
            case 7:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level8, null));
                break;
            case 8:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level9, null));
                break;
            default:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.leveldewa, null));
                break;
        }

    }


    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);
    }

    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }

    public void updateScore(){

        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = userData.edit();
//            Intent svc=new Intent(this, soundManager.class);

        boolean BGM = userData.getBoolean(getString(R.string.QUIZ_AKU_BGM), true);
//        soundManager.start(getApplicationContext());



        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX),true);
        if(sfxOn){
            editor.putBoolean(getString(R.string.QUIZ_AKU_SFX),true);
            editor.commit();
        }

        int score = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);
        if (score == 0) {
            editor.putInt(getString(R.string.SCORE_UTAMANYA), 0);
            editor.commit();
        }


        int nilaibobot = userData.getInt(getString(R.string.Array_Bobot1), 0);
        if (nilaibobot == 0) {
//            editor.putInt(getString(R.string.Array_Bobot1), 0);
            editor.commit();
        }

        //Score untuk IPA
        int score_ipa_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        if (score_ipa_lat1 == 0) {
            editor.putInt(getString(R.string.SCORE_IPA_Latihan1), 0);
            editor.commit();
        }
        int score_ipa_lat2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        if (score_ipa_lat2 == 0) {
            editor.putInt(getString(R.string.SCORE_IPA_Latihan2), 0);
            editor.commit();
        }
        int score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);
        if (score_ipa_ujian == 0) {
            editor.putInt(getString(R.string.SCORE_IPA_Ujian), 0);
            editor.commit();
        }
        //Score untuk MTK
        int score_mtk_lat1 = userData.getInt(getString(R.string.SCORE_MTK_Latihan1), 0);
        if (score_mtk_lat1== 0) {
            editor.putInt(getString(R.string.SCORE_MTK_Latihan1), 0);
            editor.commit();
        }
        int score_mtk_lat2 = userData.getInt(getString(R.string.SCORE_MTK_Latihan2), 0);
        if (score_mtk_lat2 == 0) {
            editor.putInt(getString(R.string.SCORE_MTK_Latihan2), 0);
            editor.commit();
        }
        int score_mtk_ujian = userData.getInt(getString(R.string.SCORE_MTK_Ujian), 0);
        if (score_mtk_ujian == 0) {
            editor.putInt(getString(R.string.SCORE_MTK_Ujian), 0);
            editor.commit();
        }
        //Score untuk INDO
        int score_indo_lat1 = userData.getInt(getString(R.string.SCORE_INDO_Latihan1), 0);
        if (score_indo_lat1 == 0) {
            editor.putInt(getString(R.string.SCORE_INDO_Latihan1), 0);
            editor.commit();
        }
        int score_indo_lat2 = userData.getInt(getString(R.string.SCORE_INDO_Latihan2), 0);
        if (score_indo_lat2 == 0) {
            editor.putInt(getString(R.string.SCORE_INDO_Latihan2), 0);
            editor.commit();
        }
        int score_indo_ujian = userData.getInt(getString(R.string.SCORE_INDO_Ujian), 0);
        if (score_indo_ujian == 0) {
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

        editor.putString(getString(R.string.QUIZ_AKU_USERNAME), namaTersimpan);
        editor.commit();

        editor.putInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        editor.putString(getString(R.string.QUIZ_AKU_USERNAME), namaTersimpan);


        editor.putBoolean(getString(R.string.QUIZ_AKU_BGM), bgm);
        editor.putBoolean(getString(R.string.QUIZ_AKU_SFX), sfx);

        editor.commit();

        this.score = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);

        this.nilaibobot = userData.getInt(getString(R.string.Array_Bobot1), 0);

        this.score_ipa_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        this.score_ipa_lat2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        this.score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);

        this.score_mtk_lat1 = userData.getInt(getString(R.string.SCORE_MTK_Latihan1), 0);
        this.score_mtk_lat2 = userData.getInt(getString(R.string.SCORE_MTK_Latihan2), 0);
        this.score_mtk_ujian = userData.getInt(getString(R.string.SCORE_MTK_Ujian), 0);

        this.score_indo_lat1 = userData.getInt(getString(R.string.SCORE_INDO_Latihan1), 0);
        this.score_indo_lat2 = userData.getInt(getString(R.string.SCORE_INDO_Latihan2), 0);
        this.score_indo_ujian = userData.getInt(getString(R.string.SCORE_INDO_Ujian), 0);

        this.point_exp = userData.getInt(getString(R.string.Point_EXP), 0);

        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");


        namaAkun.setText(namaTersimpan.toString());
        skore_ipa_lat1.setText(this.score_ipa_lat1.toString());
        skore_ipa_lat2.setText(this.score_ipa_lat2.toString());
        skore_ipa_ujian.setText(this.score_ipa_ujian.toString());

        skore_mtk_lat1.setText(this.score_mtk_lat1.toString());
        skore_mtk_lat2.setText(this.score_mtk_lat2.toString());
        skore_mtk_ujian.setText(this.score_mtk_ujian.toString());

        skore_indo_lat1.setText(this.score_mtk_lat1.toString());
        skore_indo_lat2.setText(this.score_mtk_lat2.toString());
        skore_indo_ujian.setText(this.score_mtk_ujian.toString());



        switch (levelku)
        {
            case 0:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level1, null));
                break;
            case 1:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level2, null));
                break;
            case 2:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level3, null));
                break;
            case 3:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level4, null));
                break;
            case 4:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level5, null));
                break;
            case 5:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level6, null));
                break;
            case 6:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level7, null));
                break;
            case 7:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level8, null));
                break;
            case 8:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level9, null));
                break;
            default:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.leveldewa, null));
                break;
        }
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
        if(!intentInitialize){
            soundManager.pause();
        }

        super.onPause();
    }
}
