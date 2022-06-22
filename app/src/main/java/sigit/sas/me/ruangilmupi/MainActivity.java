package sigit.sas.me.ruangilmupi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation myAnim;
    PopupWindow popUpReset;
    LayoutInflater inflater;
    TextView teksOut;

    private Button yes,no;
    ViewGroup.LayoutParams layoutParams;
    View layout;
    View mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentInitialize = false;

        //Button UI

        final Button btnModul = (Button) findViewById(R.id.btn_modul);
        final Button btnQuiz = (Button) findViewById(R.id.btn_kuis);
        final Button btnSetting = (Button) findViewById(R.id.btn_setting);
        //final Button btnAbout = (Button) findViewById(R.id.btn_about);
        final Button btnNama = (Button) findViewById(R.id.btn_akun);
        final  Button btn_aboutme = (Button) findViewById(R.id.btn_aboutme);
        final Button btnExit = (Button) findViewById(R.id.btn_exit);


        myAnim = AnimationUtils.loadAnimation(this, R.anim.grind);

        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        btnNama.setText(namaTersimpan);


        inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View fragmentPopup = inflater.inflate(R.layout.pop_up_reset, (ViewGroup) findViewById(R.id.main_background),false);
        teksOut = (TextView) fragmentPopup.findViewById(R.id.textOut);
        teksOut.setText("Keluar dari aplikasi?");

        layoutParams = fragmentPopup.getLayoutParams();
        layout = inflater.inflate(R.layout.pop_up_reset,
                (ViewGroup) fragmentPopup.findViewById(R.id.popupanswer));

        popUpReset = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);

        yes = fragmentPopup.findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                yes untuk reset
                Animation animated;
                animated = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);
                yes.startAnimation(animated);
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentInitialize = true;
                soundManager.pause();
                startActivity(startMain);

//                editor.clear().commit();

//                updateScore();
                popUpReset.dismiss();
            }
        });

        no = fragmentPopup.findViewById(R.id.no);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                no
                Animation animated;
                animated = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);
                no.startAnimation(animated);

                popUpReset.dismiss();
            }
        });
/*
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAbout.startAnimation(myAnim);
                Intent intent;
                intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
            }
        });
*/
        btnModul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnModul.startAnimation(myAnim);
                Intent intent;
                intent = new Intent(getApplicationContext(), BukuMateri.class);
                startActivity(intent);
            }
        });

        btn_aboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_aboutme.startAnimation(myAnim);
                Intent intent;
                intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnExit.startAnimation(myAnim);
                popUpReset.showAtLocation(findViewById(R.id.main_background), Gravity.CENTER, 0, 0);

            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnQuiz.startAnimation(myAnim);
                Intent intent;
                intent = new Intent(getApplicationContext(), MenuKuisBelajar.class);
                intentInitialize = true;
                startActivity(intent);
            }
        });


        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSetting.startAnimation(myAnim);
                Intent intent;
                intent = new Intent(getApplicationContext(), SettingSound.class);
                intentInitialize = true;
                startActivity(intent);
            }
        });
        btnNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNama.startAnimation(myAnim);
                Intent intentku = new Intent(getApplicationContext(), Akun.class);
                intentInitialize = true;
                startActivity(intentku);
            }
        });

/*        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnVideo.startAnimation(myAnim);
                Intent intentku = new Intent(getApplicationContext(), videoPembelajaran.class);
                intentInitialize = true;
                startActivity(intentku);
            }
        });*/
    }

/*

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
*/



//    @Override
//    protected void onNewIntent(Intent intent) {
//        if(intent.getCategories().contains(Intent.CATEGORY_HOME)){
//            soundManager.pause();
//        }
//        super.onNewIntent(intent);
//    }

    @Override
    public void onBackPressed() {

        popUpReset.showAtLocation(findViewById(R.id.main_background), Gravity.CENTER, 0, 0);

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