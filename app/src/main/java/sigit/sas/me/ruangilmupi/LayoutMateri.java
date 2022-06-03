package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class LayoutMateri extends AppCompatActivity {

    Animation myAnim;
    Intent bukaKuis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_materi);

        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        intentInitialize = false;

        Intent intent = getIntent();
        MenuKuisBelajar.FragmentToLaunch fragmentToLaunchIPA = (MenuKuisBelajar.FragmentToLaunch)
                intent.getSerializableExtra(getString(R.string.MateriFragmentIPA));


        Button mulaiKuis = (Button) findViewById(R.id.mainKuis);

        FragmentManager fragmentManager = getSupportFragmentManager();


        //Fragment transaction pakenya support.v4.app.fragmenttransaction
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();

        switch (fragmentToLaunchIPA){
            case Materi_IPA_1:
                fragmentMateriIPA1 fragMateriIPA1 = new fragmentMateriIPA1();
                fragmentTransaction.add(R.id.fragment_container,fragMateriIPA1,"MATERI_1_FRAGMENT_IPA");
                bukaKuis = new Intent(getApplicationContext(), Kuis.class);
                bukaKuis.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_IPA_1);
                break;
            case Materi_IPA_2:
                fragmentMateriIPA2 fragMateriIPA2 = new fragmentMateriIPA2();
                fragmentTransaction.add(R.id.fragment_container, fragMateriIPA2,"MATERI_2_FRAGMENT_IPA");
                bukaKuis = new Intent(getApplicationContext(), Kuis.class);
                bukaKuis.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_IPA_2);
                break;


 /*           case Materi_MTK_3:
                fragmentMateriIPA3 fragMateriIPA3 = new fragmentMateriIPA3();
                fragmentTransaction.add(R.id.fragment_container, fragMateriIPA3,"MATERI_3_FRAGMENT_IPA");
                bukaKuis = new Intent(getApplicationContext(), Kuis.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), MenuKuisBelajar.FragmentToLaunchIPA.Materi_IPA_3);
                break;

*/

            case Materi_MTK_1:
                fragmentMateriMTK1 fragMateriMTK1 = new fragmentMateriMTK1();
                fragmentTransaction.add(R.id.fragment_container,fragMateriMTK1,"MATERI_1_FRAGMENT_MTK");
                bukaKuis = new Intent(getApplicationContext(), Kuis.class);
                bukaKuis.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_MTK_1);
                break;
            case Materi_MTK_2:
                fragmentMateriMTK2 fragMateriMTK2 = new fragmentMateriMTK2();
                fragmentTransaction.add(R.id.fragment_container,fragMateriMTK2,"MATERI_2_FRAGMENT_MTK");
                bukaKuis = new Intent(getApplicationContext(), Kuis.class);
                bukaKuis.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_MTK_2);
                break;

            case Materi_INDO_1:
                fragmentMateriINDO1 fragMateriINDO1 = new fragmentMateriINDO1();
                fragmentTransaction.add(R.id.fragment_container,fragMateriINDO1,"MATERI_1_FRAGMENT_MTK");
                bukaKuis = new Intent(getApplicationContext(), Kuis.class);
                bukaKuis.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_INDO_1);
                break;
            case Materi_INDO_2:
                fragmentMateriINDO2 fragMateriINDO2 = new fragmentMateriINDO2();
                fragmentTransaction.add(R.id.fragment_container,fragMateriINDO2,"MATERI_1_FRAGMENT_MTK");
                bukaKuis = new Intent(getApplicationContext(), Kuis.class);
                bukaKuis.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_INDO_2);
                break;
        }

        mulaiKuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentInitialize = true;
                startActivity(bukaKuis);
                view.startAnimation(myAnim);
            }
        });

        fragmentTransaction.commit();

    }

    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MenuKuisBelajar.class);
        intentInitialize = true;
        startActivity(intent);

    }
    public void homeMain (View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

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