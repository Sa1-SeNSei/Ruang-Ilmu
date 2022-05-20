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

public class fragmentKuisIPA1 extends Fragment implements View.OnClickListener {

    View fragmentLayout;
    Animation myAnim;
    View layout;
    View mainlayout;
    Button btnA, btnB, btnC, btnD;
    LinkedList<Button> buttonk = new LinkedList<Button>();

    ImageButton btnexit, btnnext, btnexplain;
    private ImageView bpw;
    private PopupWindow pw;
    ViewGroup.LayoutParams layoutParams;

    JustifyTextView soal;
    TextView restNumber;
    TextView currentNumber;
    TextView penjelasan;

    String[] pilihan;
    String[] penjelasankuis;
    int[] jumlahpilhan;
    String[] soalString;
    int[] jawabanPiliihanKuis;


    Integer restNumb;
    Integer currentNumb;
    SharedPreferences userData;

    int soalDikerjakan;
    SharedPreferences.Editor editor;

    Integer score ;

    int levelku;
    String namaTersimpan ;


    Integer score_ipa_lat1;


    public TextView skore;

    private RecyclerView recyclerViewImageSoal;
    private ImageSoalAdapter imageSoalAdapter;
    private List<List<Drawable>> imageSoalList = new ArrayList<>();


    public fragmentKuisIPA1(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_kuis_ipa1,container,false);
        btnA = fragmentLayout.findViewById(R.id.A);
        btnB = fragmentLayout.findViewById(R.id.B);
        btnC = fragmentLayout.findViewById(R.id.C);
        btnD = fragmentLayout.findViewById(R.id.D);
        btnexit = fragmentLayout.findViewById(R.id.exit);
        btnnext = fragmentLayout.findViewById(R.id.next);
        btnexplain = fragmentLayout.findViewById(R.id.explain);
        recyclerViewImageSoal = fragmentLayout.findViewById(R.id.recycler_image);

        imageSoalAdapter = new ImageSoalAdapter();
        recyclerViewImageSoal.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewImageSoal.setAdapter(imageSoalAdapter);

        View kuisku = inflater.inflate(R.layout.activity_kuis,container, false);


        skore = (TextView) kuisku.findViewById(R.id.score);

        buttonk.add(btnA);
        buttonk.add(btnB);
        buttonk.add(btnC);
        buttonk.add(btnD);
        soalString = getResources().getStringArray(R.array.ipa_latihan1);
        pilihan = getResources().getStringArray(R.array.ipa_latihan1_pilihan);
        jumlahpilhan = getResources().getIntArray(R.array.jumlahpilihan1);
        penjelasankuis = getResources().getStringArray(R.array.penjelasan_ipa_latihan1);
        jawabanPiliihanKuis = getResources().getIntArray(R.array.jawaban_ipa_latihan1);

        soal = fragmentLayout.findViewById(R.id.soal);

        //mengambil bobot soal di string dengan array

        //String[] bobotipa1 = getResources().getStringArray(R.array.bobotsoal1);

        //bobotkuissoal1 = getResources().getIntArray(R.array.bobotsoal1);

        //Jumlah Soal
        restNumber = fragmentLayout.findViewById(R.id.rest);
        //Soal yang di kerjakan
        currentNumber = fragmentLayout.findViewById(R.id.current);

        restNumb = 10;//Ganti ini sesuai jumlah soal
        currentNumb =0;

        initImageSoal();

        myAnim = AnimationUtils.loadAnimation(getContext(),R.anim.grind);


//        Button spoiler11 = (Button) fragmentLayout.findViewById(R.id.spoiler1_1);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

        btnexit.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        btnexplain.setOnClickListener(this);

        View fragmentPopup = inflater.inflate(R.layout.popup_penjelasan,container,false);

        penjelasan = fragmentPopup.findViewById(R.id.teksPenjelasan);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.popup_penjelasan,
                (ViewGroup) fragmentPopup.findViewById(R.id.popupanswer));

        pw = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);

        bpw = fragmentPopup.findViewById(R.id.close);

        bpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                bpw.startAnimation(animated);

                pw.dismiss();
            }
        });




        userData = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = userData.edit();

        score = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);
        score_ipa_lat1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);


        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        soalDikerjakan = userData.getInt(getString(R.string.QUIZ_AKU_SOAL1),-1);
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

    private void initImageSoal() {
        Drawable ipa_1 = getContext().getResources().getDrawable(R.drawable.ipa_1_1);
        Drawable ipa_3 = getContext().getResources().getDrawable(R.drawable.ipa_1_3);
        Drawable ipa_4 = getContext().getResources().getDrawable(R.drawable.ipa_1_4);

        List<Drawable> soal1 = new ArrayList<>();
        soal1.add(ipa_1);
        List<Drawable> soal3 = new ArrayList<>();
        soal3.add(ipa_3);
        List<Drawable> soal4 = new ArrayList<>();
        soal4.add(ipa_4);

        imageSoalList.add(soal1);
        imageSoalList.add(new ArrayList<Drawable>()); //soal2
        imageSoalList.add(soal3);
        imageSoalList.add(soal4);

        if (imageSoalList.size() < restNumb) {
            int sisa_gambar = restNumb - imageSoalList.size();
            for (int i = 0; i < sisa_gambar; i++) {
                imageSoalList.add(new ArrayList<Drawable>());
            }
        }
    }


    public void cleanButton(){

        btnexit.setAlpha(1f);
        btnexit.setEnabled(true);

        btnnext.setEnabled(false);
        btnexplain.setEnabled(false);
        btnnext.setAlpha(0.5f);
        btnexplain.setAlpha(0.5f);
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
                if (score >= score_ipa_lat1){
                    score_ipa_lat1 = score;
                    updateNilai();
                    Intent intent;
                    intent = new Intent(getContext(), ScoreLulus.class);
                    startActivity(intent);
                    Toast.makeText(getContext(), "Score yang anda dapat " + Integer.toString(score), Toast.LENGTH_SHORT).show();
                }else {
                    updateNilai();
                    Intent intent;
                    intent = new Intent(getContext(), ScoreLulus.class);
                    startActivity(intent);
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
                penjelasan.setText(penjelasankuis[nomor]);

                //Load Image
                imageSoalAdapter.submitList(imageSoalList.get(nomor) != null ? imageSoalList.get(nomor) : new ArrayList<Drawable>());
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
// jika soal ini telah di kerjakan maka gk akan dpt nilai

//        Jika jawaban benar maka Button akan berganti warna menjadi emas
        int jawabanBenar = jawabanPiliihanKuis[nomor];

        if(jawaban == jawabanBenar){
            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));

            if(nomor > soalDikerjakan) {
                soalDikerjakan++;
                //Menggunakan array bobot soal ke score
                score = score + 10;

                //score = score + bobotkuissoal1[nomor];

            } //blm di kerjakan dpt nilai soal di kerjakan + 1

            else if (nomor<=soalDikerjakan){}

            updateNilai();

            btnnext.setEnabled(true);
            btnexplain.setEnabled(true);
            btnnext.setAlpha(1f);
            btnexplain.setAlpha(1f);
            playMenang();
        }
        else {



            updateNilai();

            playKalah();

            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan3, null));
            buttonk.get(jawabanBenar).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));

            pw.showAtLocation(fragmentLayout.findViewById(R.id.kuisIPA1), Gravity.CENTER, 0, 0);

            btnnext.setEnabled(true);
            btnexplain.setEnabled(true);
            btnnext.setAlpha(1f);
            btnexplain.setAlpha(1f);

        }

        btnexplain.setEnabled(true);
        btnexplain.setAlpha(1f);
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
            case R.id.explain:
                btnexplain.startAnimation(myAnim);
                pw.showAtLocation(fragmentLayout.findViewById(R.id.kuisIPA1), Gravity.CENTER, 0, 0);
                btnnext.setEnabled(true);
                btnexplain.setEnabled(true);
                btnnext.setAlpha(1f);
                btnexplain.setAlpha(1f);
                break;

        }
    }

    public void updateNilai(){


        editor.putInt(getString(R.string.SCORE_IPA_Latihan1), score_ipa_lat1);
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