package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class ScoreLulus extends AppCompatActivity {

    SharedPreferences userData;

    TextView life, score;
    ImageView levelImage;

    LinkedList<Drawable> level = new LinkedList<Drawable>();

    Animation myanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_lulus);

        score = (TextView) findViewById(R.id.score);
        intentInitialize = false;

        myanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grind);

        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Integer skor = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);


        score.setText(skor.toString());


        final Button lanjut = (Button) findViewById(R.id.btn_lanjut);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanjut.startAnimation(myanim);
                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
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