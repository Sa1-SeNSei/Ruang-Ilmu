package sigit.sas.me.ruangilmupi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class fragmentKuisIPA_Ujian extends Fragment implements View.OnClickListener {

    View fragmentLayout;
    Animation myAnim;
    View layout;
    Button btnA, btnB, btnC, btnD;
    LinkedList<Button> buttonk = new LinkedList<Button>();

    ImageButton btnexit, btnnext;
    ViewGroup.LayoutParams layoutParams;

    JustifyTextView soal;
    TextView restNumber;
    TextView currentNumber;
    TextView penjelasan;

    String[] pilihan;
    int[] jumlahpilhan;
    String[] soalString;
    int[] jawabanPiliihanKuis;

    Integer restNumb;
    Integer currentNumb;
    SharedPreferences userData;

    int soalDikerjakan;
    int levelupIPA;
    SharedPreferences.Editor editor;

    Integer score ;
    int levelku;
    String namaTersimpan ;
    Integer score_ipa_ujian;

    public TextView skore;

    public fragmentKuisIPA_Ujian(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_kuis_ipa__ujian,container,false);
        btnA = fragmentLayout.findViewById(R.id.A);
        btnB = fragmentLayout.findViewById(R.id.B);
        btnC = fragmentLayout.findViewById(R.id.C);
        btnD = fragmentLayout.findViewById(R.id.D);
        btnexit = fragmentLayout.findViewById(R.id.exit);
        btnnext = fragmentLayout.findViewById(R.id.next);

        View kuisku = inflater.inflate(R.layout.activity_kuis,container, false);


        skore = (TextView) kuisku.findViewById(R.id.score);

        buttonk.add(btnA);
        buttonk.add(btnB);
        buttonk.add(btnC);
        buttonk.add(btnD);


        soalString = getResources().getStringArray(R.array.SoalIPA_Ujian);
        pilihan = getResources().getStringArray(R.array.ABC_IPA_Ujian);
        jumlahpilhan = getResources().getIntArray(R.array.JumlahPilihanIPA_Ujian);
        jawabanPiliihanKuis = getResources().getIntArray(R.array.JawabanKuisIPA_Ujian);
        soal = fragmentLayout.findViewById(R.id.soal);

        //mengambil bobot soal di string dengan array

        //String[] bobotipa1 = getResources().getStringArray(R.array.bobotsoal1);

        //bobotkuissoal1 = getResources().getIntArray(R.array.bobotsoal1);

        //Jumlah Soal
        restNumber = fragmentLayout.findViewById(R.id.rest);
        //Soal yang di kerjakan
        currentNumber = fragmentLayout.findViewById(R.id.current);

        restNumb = 20;//Ganti ini sesuai jumlah soal
        currentNumb =0;

        myAnim = AnimationUtils.loadAnimation(getContext(),R.anim.grind);


//        Button spoiler11 = (Button) fragmentLayout.findViewById(R.id.spoiler1_1);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

        btnexit.setOnClickListener(this);
        btnnext.setOnClickListener(this);


        View fragmentPopup = inflater.inflate(R.layout.popup_penjelasan,container,false);

        penjelasan = fragmentPopup.findViewById(R.id.teksPenjelasan);
        layoutParams = fragmentPopup.getLayoutParams();

        userData = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = userData.edit();

        score = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);
        score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);

        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        levelupIPA =  userData.getInt(getString(R.string.Level_IPA_UP), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        soalDikerjakan = userData.getInt(getString(R.string.Dikerjakan_IPA_Ujian),-1);
        int nomorSoalterakhir = soalDikerjakan +1;


        if(nomorSoalterakhir<restNumb)
        {
            currentNumb = nomorSoalterakhir;
        }else {currentNumb=0;}


        changeIsiKuis(currentNumb);

        score = 0;
        updateNilai();

        return fragmentLayout;
    }



    public void cleanButton(){

        btnexit.setAlpha(1f);
        btnexit.setEnabled(true);

        btnnext.setEnabled(false);
        btnnext.setAlpha(0.5f);

        for (int i =0; i < buttonk.size();i++)
        {
            buttonk.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan1, null));
            buttonk.get(i).setEnabled(true);

        }

    }


    public void changeIsiKuis(Integer nomor){

        cleanButton();

        //resNumb ini jumlah soal dell jadi ketika resNumb udah sama dengan soal yg di kerjakan langsung cek levelnya 1 atau tidak
        if(nomor <= restNumb) {
            if ( nomor >= restNumb){
                if (levelupIPA==0) {
                    levelupIPA += 100;
                    levelku += 1;
                    updateNilai();
                    Intent intent;
                    if (score >= score_ipa_ujian) {
                        score_ipa_ujian = score;
                        updateNilai();
                        if (score >= 80){
                            intent = new Intent(getContext(), ScoreLulus.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Hebat...\nKamu Lulus !", Toast.LENGTH_LONG).show();
                        }else{
                            intent = new Intent(getContext(), ScoreDiBawah80.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Yuk Pahami lagi materinya (*^_^*)", Toast.LENGTH_LONG).show();
                        }
                    }
                    if(score < score_ipa_ujian){
                        updateNilai();
                        if (score >= 80){
                            intent = new Intent(getContext(), ScoreLulus.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Hebat...\nKamu Lulus !", Toast.LENGTH_LONG).show();
                        }else{
                            intent = new Intent(getContext(), ScoreDiBawah80.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Yuk Pahami lagi materinya (*^_^*)", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                if(levelupIPA>=1){
                    Intent intent;
                    if (score >= score_ipa_ujian) {
                        score_ipa_ujian = score;
                        updateNilai();
                        if (score >= 80){
                            intent = new Intent(getContext(), ScoreLulus.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Hebat...\nKamu Lulus !", Toast.LENGTH_LONG).show();
                        }else{
                            intent = new Intent(getContext(), ScoreDiBawah80.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Yuk Pahami lagi materinya (*^_^*)", Toast.LENGTH_LONG).show();
                        }
                    }
                    if(score < score_ipa_ujian){
                        updateNilai();
                        if (score >= 80){
                            intent = new Intent(getContext(), ScoreLulus.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Hebat...\nKamu Lulus !", Toast.LENGTH_LONG).show();
                        }else{
                            intent = new Intent(getContext(), ScoreDiBawah80.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "Yuk Pahami lagi materinya (*^_^*)", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
            else {

                btnexit.setEnabled(true);
                btnexit.setAlpha(1f);
//        Memasukan Soal
                soal.setText(soalString[nomor]);
//        Memasukan restNumber (Jumlah Soal)
                restNumber.setText(restNumb.toString());
//        Current soal bertambah +1
                Integer current = nomor + 1;
                currentNumber.setText(current.toString());

//        Memasukan Pilhan

                int x = 0;

                //Jumlah Button Pilihan sebanyak berapa di string
                for (int p = 0; p < nomor; p++) {
                    x += jumlahpilhan[p];
                }

                Integer u = x;

                //Button A,B,C,D
                for (int i = 0; i < jumlahpilhan[nomor]; i++) {
                    int pilih = i + x;
                    switch (jumlahpilhan[nomor]) {

                        case 3:
                            buttonk.get(i).setText(pilihan[pilih]);
                            buttonk.get(3).setEnabled(false);
                            buttonk.get(3).setAlpha(0f);
                            break;
                        case 4:
                            for (int t = 0; t < buttonk.size(); t++) {
                                buttonk.get(t).setEnabled(true);
                                buttonk.get(t).setAlpha(1f);
                            }
                            buttonk.get(i).setText(pilihan[pilih]);
                            break;
                        case 5:

                            break;
                    }
                }
            }
        }


        else {
            Toast.makeText(getContext(), "Soal Telah Selesai !", Toast.LENGTH_SHORT).show();
            Intent intent;
            intent = new Intent(getContext(), MenuKuisBelajar.class);
            startActivity(intent);
        }
    }


// Checker


    public void checker(int jawaban, int nomor){

//        Jika jawaban benar maka Button akan berganti warna menjadi emas
        int jawabanBenar = jawabanPiliihanKuis[nomor];

        if(jawaban == jawabanBenar){
            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));

            if(nomor > soalDikerjakan) {
                soalDikerjakan++;
                //Menggunakan array bobot soal ke score
                score = score + 5;

                //score = score + bobotkuissoal1[nomor];

            } //blm di kerjakan dpt nilai soal di kerjakan + 1

            else if (nomor<=soalDikerjakan){}

            updateNilai();

            btnnext.setEnabled(true);
            btnnext.setAlpha(1f);
            playMenang();
        }
        else {

            updateNilai();

            playKalah();

            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan3, null));
            buttonk.get(jawabanBenar).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));

            btnnext.setEnabled(true);
            btnnext.setAlpha(1f);


        }

        btnexit.setEnabled(false);
        btnexit.setAlpha(0.5f);

        for (int i =0; i < buttonk.size();i++)
        {
            buttonk.get(i).setEnabled(false);
        }

//        Jika salah maka yang benar di ganti warna, dan yang dipilih berganti warna menjadi abu2
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.A:
                btnA.startAnimation(myAnim);
                checker(0,currentNumb);
                break;
            case R.id.B:
                btnB.startAnimation(myAnim);
                checker(1,currentNumb);

                break;
            case R.id.C:
                btnC.startAnimation(myAnim);
                checker(2,currentNumb);

                break;
            case R.id.D:
                btnD.startAnimation(myAnim);
                checker(3,currentNumb);

                break;
            case R.id.exit:
                btnexit.startAnimation(myAnim);
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);

                break;
            case R.id.next:
                btnnext.startAnimation(myAnim);
                currentNumb++;
                changeIsiKuis(currentNumb);
                break;

        }
    }

    public void updateNilai(){

        editor.putInt(getString(R.string.Level_IPA_UP), levelupIPA);
        editor.putInt(getString(R.string.SCORE_IPA_Ujian), score_ipa_ujian);
        editor.putInt(getString(R.string.SCORE_UTAMANYA), score);
        editor.putInt(getString(R.string.QUIZ_AKU_LEVEL), levelku);
        editor.commit();
        ((Kuis) getActivity()).cekProfil();

    }


    public void playMenang()
    {
        MediaPlayer menang;
        menang = MediaPlayer.create(getContext(), R.raw.menang);
        menang.setVolume(100,100);
        menang.setLooping(false);
        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX), true);
        if(sfxOn) menang.start();
    }

    public void playKalah()
    {
        MediaPlayer menang;
        menang = MediaPlayer.create(getContext(), R.raw.kalah);
        menang.setVolume(100,100);
        menang.setLooping(false);
        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX), true);
        if(sfxOn) menang.start();
    }

}