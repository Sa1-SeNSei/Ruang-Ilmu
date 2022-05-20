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

public class SettingSound extends AppCompatActivity {

    Animation myAnim;
    SharedPreferences userData;
    SharedPreferences.Editor editor;
    Button sfx;
    Button bgm;

    boolean bgmOn;
    boolean sfxOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_sound);
        setContentView(R.layout.activity_setting_sound);
        sfx = (Button) findViewById(R.id.btnSFX);
        bgm = (Button) findViewById(R.id.btnBGM);

        myAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);
        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = userData.edit();
        bgmOn = userData.getBoolean(getString(R.string.QUIZ_AKU_BGM), true);
        sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX),true);
//        Toast.makeText(getApplicationContext(), bgm, Toast.LENGTH_LONG).show();
        checkSound();
    }


    public void checkSound(){
        if(bgmOn){
            bgm.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.musikon, null));
        }
        else {
            bgm.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.musikoff, null));
        }

        if(sfxOn){
            sfx.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.sfxon, null));
        }
        else {
            sfx.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.sfxoff, null));
        }
    }

    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }

    public void onOffBGM(View view)
    {
        if(bgmOn){
            bgmOn = false;
            editor.putBoolean(getString(R.string.QUIZ_AKU_BGM), false);
            editor.commit();
            soundManager.stop();

        }
        else {
            bgmOn = true;
            editor.putBoolean(getString(R.string.QUIZ_AKU_BGM), true);
            editor.commit();
            if(soundManager.mp !=null) {soundManager.stop();  soundManager.resume();      checkSound();
                return;}
            else soundManager.start(getApplicationContext());

        }

        checkSound();

    }

    public void onOffSFX(View view)
    {

        if(sfxOn){
            sfxOn = false;
            editor.putBoolean(getString(R.string.QUIZ_AKU_SFX), false);
            editor.commit();
        }
        else {
            sfxOn = true;
            editor.putBoolean(getString(R.string.QUIZ_AKU_SFX), true);
            editor.commit();
        }

        checkSound();
    }


    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
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
        if(!intentInitialize){
            soundManager.pause();
        }

        super.onPause();
    }
}