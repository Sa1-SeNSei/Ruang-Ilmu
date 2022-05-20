package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class Score extends AppCompatActivity {

    SharedPreferences userData;

    TextView life, score, score_perlayout1,score_perlayout2,score_perlayout3,score_perlayout4,score_perlayout5,score_perlayout6,score_perlayout7;
    Integer score_ipa_lat1,score_ipa_lat2,score_ipa_ujian;
    Integer score_mtk_lat1,score_mtk_lat2,score_mtk_ujian;
    Integer score_indo_lat1,score_indo_lat2,score_indo_ujian;

    ImageView levelImage;

    LinkedList<Drawable> level = new LinkedList<Drawable>();

    Animation myanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score = (TextView) findViewById(R.id.score);

/*
        score_perlayout1 = (TextView) findViewById(R.id.score_perlayout1);
        score_perlayout2= (TextView) findViewById(R.id.score_perlayout2);
        score_perlayout3= (TextView) findViewById(R.id.score_perlayout3);
        score_perlayout4 = (TextView) findViewById(R.id.score_perlayout4);
        score_perlayout5 = (TextView) findViewById(R.id.score_perlayout6);
        score_perlayout6 = (TextView) findViewById(R.id.score_perlayout6);
        score_perlayout7 = (TextView) findViewById(R.id.score_perlayout7);
*/

        levelImage = (ImageView) findViewById(R.id.level);
        intentInitialize = false;


        myanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grind);

        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level1, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level2, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level3, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level4, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level5, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level6, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level7, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level8, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level9, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.leveldewa, null));


        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Integer skor = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);

/*

        Integer skor1 = userData.getInt(getString(R.string.QUIZ_AKU_SCORE_KUIS1), 0);
        Integer skor2 = userData.getInt(getString(R.string.QUIZ_AKU_SCORE_KUIS2), 0);
        Integer skor3 = userData.getInt(getString(R.string.QUIZ_AKU_SCORE_KUIS3), 0);
        Integer skor4 = userData.getInt(getString(R.string.QUIZ_AKU_SCORE_KUIS4), 0);
        Integer skor5 = userData.getInt(getString(R.string.QUIZ_AKU_SCORE_KUIS5), 0);
        Integer skor6 = userData.getInt(getString(R.string.QUIZ_AKU_SCORE_KUIS6), 0);
        Integer skor7 = userData.getInt(getString(R.string.QUIZ_AKU_SCORE_KUIS7), 0);
*/

        Integer levelText = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL),0);


        score.setText(skor.toString());

/*
        score_perlayout1.setText(skor1.toString());
        score_perlayout2.setText(skor2.toString());
        score_perlayout3.setText(skor3.toString());
        score_perlayout4.setText(skor4.toString());
        score_perlayout5.setText(skor5.toString());
        score_perlayout6.setText(skor6.toString());
        score_perlayout7.setText(skor7.toString());
*/


        levelImage.setImageDrawable(level.get(levelText));

        final Button lanjut = (Button) findViewById(R.id.btn_lanjut);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanjut.startAnimation(myanim);
                Intent intent;
                intent = new Intent(getApplicationContext(), MenuKuisBelajar.class);
                intentInitialize = true;

                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

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