package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class About extends AppCompatActivity {
    Animation myAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        myAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);

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
