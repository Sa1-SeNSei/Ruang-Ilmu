package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class Kuis extends AppCompatActivity {


    Animation myAnim;

    TextView namaAkun;

    TextView scoreAkun;


    public TextView skore,skore_layout1,skore_layout2,skore_layout3,skore_layout4,skore_layout5,skore_layout6,skore_layout7;
    public ImageView levelImage;

    LinkedList<Drawable> level = new LinkedList<Drawable>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        intentInitialize = false;
        myAnim = AnimationUtils.loadAnimation(this, R.anim.grind);

        Intent intent = getIntent();


        Intent intentIPA = getIntent();
        MenuKuisBelajar.FragmentToLaunch fragmentToLaunchIPA = (MenuKuisBelajar.FragmentToLaunch)
                intentIPA.getSerializableExtra(getString(R.string.KuisFragmentIPA));



        Intent intentMTK = getIntent();

        MenuKuisBelajar.FragmentToLaunch fragmentToLaunchMTK = (MenuKuisBelajar.FragmentToLaunch)
                intentMTK.getSerializableExtra(getString(R.string.KuisFragmentMTK));
        Intent intentINDO = getIntent();
        MenuKuisBelajar.FragmentToLaunch fragmentToLaunchINDO = (MenuKuisBelajar.FragmentToLaunch)
                intentINDO.getSerializableExtra(getString(R.string.KuisFragmentINDO));


        namaAkun = (TextView) findViewById(R.id.akun);

        skore = (TextView) findViewById(R.id.score);


        levelImage = (ImageView) findViewById(R.id.level);


        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentManager fragmentManagerIPA = getSupportFragmentManager();
        FragmentManager fragmentManagerMTK = getSupportFragmentManager();
        FragmentManager fragmentManagerINDO = getSupportFragmentManager();

        //Fragment transaction pakenya support.v4.app.fragmenttransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        FragmentTransaction fragmentTransactionIPA = fragmentManagerIPA.beginTransaction();
        FragmentTransaction fragmentTransactionMTK = fragmentManagerMTK.beginTransaction();
        FragmentTransaction fragmentTransactionINDO = fragmentManagerINDO.beginTransaction();

        cekProfil();
        switch (fragmentToLaunchIPA) {
            case Materi_IPA_1:
                fragmentKuisIPA1 fragMateri1 = new fragmentKuisIPA1();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri1, "KUIS_IPA_1_FRAGMENT");
                break;

            case Materi_IPA_2:
                fragmentKuisIPA2 fragMateri2 = new fragmentKuisIPA2();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri2, "KUIS_IPA_2_FRAGMENT");
                break;

            case Materi_IPA_3:
                fragmentKuisIPA_Ujian fragMateri3 = new fragmentKuisIPA_Ujian();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri3, "KUIS_IPA_3_FRAGMENT");
                break;

            case Materi_MTK_1:
                fragmentKuisMTK1 fragMateriMtk1 = new fragmentKuisMTK1();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateriMtk1, "KUIS_MTK_1_FRAGMENT");
                break;

            case Materi_MTK_2:
                fragmentKuisMTK2 fragMateriMtk2 = new fragmentKuisMTK2();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateriMtk2, "KUIS_MTK_2_FRAGMENT");
                break;

            case Materi_MTK_3:
                fragmentKuisMTK_Ujian fragMateriMtk_Ujian = new fragmentKuisMTK_Ujian();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateriMtk_Ujian, "KUIS_MTK_3_FRAGMENT");
                break;

            case Materi_INDO_1:
                fragmentKuisINDO1 fragMateriIndo1 = new fragmentKuisINDO1();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateriIndo1, "KUIS_MTK_1_FRAGMENT");
                break;

            case Materi_INDO_2:
                fragmentKuisINDO2 fragMateriIndo2 = new fragmentKuisINDO2();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateriIndo2, "KUIS_MTK_2_FRAGMENT");
                break;

            case Materi_INDO_3:
                fragmentKuisINDO_Ujian fragMateriIndo_Ujian = new fragmentKuisINDO_Ujian();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateriIndo_Ujian, "KUIS_MTK_3_FRAGMENT");
                break;


           /* case Materi_MTK_3:
                fragmentKuisMTK_Ujian fragMateriMtk3 = new fragmentKuisMTK_Ujian();
                fragmentTransactionIPA.add(R.id.fragment_kuis, fragMateriMtk3, "KUIS_IPA_1_FRAGMENT");
                break;*/


        }

        fragmentTransaction.commit();
        fragmentTransactionIPA.commit();
    }
    public void cekProfil(){
        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = userData.edit();
        Integer bobotkuis1 = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);

        Integer score= userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);

        Integer score_ipa_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        Integer score_ipa_lat2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        Integer score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);

        int levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        String namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");



        skore.setText(score.toString());

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
            default:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.leveldewa, null));
                break;
        }


//        levelImage.setImageDrawable(level.get(levelku));
        namaAkun.setText(namaTersimpan);


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MenuKuisBelajar.class);
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