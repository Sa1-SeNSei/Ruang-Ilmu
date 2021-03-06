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

public class fragmentKuisMTK_Ujian extends Fragment implements View.OnClickListener {

    View fragmentLayout;
    Animation myAnim;
    View layout;
    View mainlayout;
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
    int levelupMTK;
    SharedPreferences.Editor editor;

    Integer score ;

    int levelku;
    String namaTersimpan ;

    Integer score_mtk_ujian;

    public TextView skore;

    private RecyclerView recyclerViewImageSoal;
    private ImageSoalAdapter imageSoalAdapter;
    private List<List<Drawable>> imageSoalList = new ArrayList<>();

    public fragmentKuisMTK_Ujian(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_kuis_mtk__ujian,container,false);
        btnA = fragmentLayout.findViewById(R.id.A);
        btnB = fragmentLayout.findViewById(R.id.B);
        btnC = fragmentLayout.findViewById(R.id.C);
        btnD = fragmentLayout.findViewById(R.id.D);
        btnexit = fragmentLayout.findViewById(R.id.exit);
        btnnext = fragmentLayout.findViewById(R.id.next);
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
        soalString = getResources().getStringArray(R.array.SoalMTK_Ujian);
        pilihan = getResources().getStringArray(R.array.ABC_MTK_Ujian);
        jumlahpilhan = getResources().getIntArray(R.array.JumlahPilihanMTK_Ujian);
        jawabanPiliihanKuis = getResources().getIntArray(R.array.JawabanKuisMTK_Ujian);

        soal = fragmentLayout.findViewById(R.id.soal);
        restNumber = fragmentLayout.findViewById(R.id.rest);
        currentNumber = fragmentLayout.findViewById(R.id.current);

        restNumb = 20;//Ganti ini sesuai jumlah soal
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


        View fragmentPopup = inflater.inflate(R.layout.popup_penjelasan,container,false);

        penjelasan = fragmentPopup.findViewById(R.id.teksPenjelasan);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.popup_penjelasan,
                (ViewGroup) fragmentPopup.findViewById(R.id.popupanswer));


        userData = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = userData.edit();

        score = userData.getInt(getString(R.string.SCORE_UTAMANYA), 0);
        score_mtk_ujian = userData.getInt(getString(R.string.SCORE_MTK_Ujian), 0);


        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        levelupMTK =  userData.getInt(getString(R.string.Level_MTK_UP), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        soalDikerjakan = userData.getInt(getString(R.string.Dikerjakan_MTK_Ujian),-1);
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
        Drawable mtk_ujian_5 = getContext().getResources().getDrawable(R.drawable.mtk_ujian_5);
        Drawable mtk_ujian_6 = getContext().getResources().getDrawable(R.drawable.mtk_ujian_6);
        Drawable mtk_ujian_7 = getContext().getResources().getDrawable(R.drawable.mtk_ujian_7);
        Drawable mtk_ujian_8 = getContext().getResources().getDrawable(R.drawable.mtk_ujian_8);
        Drawable mtk_ujian_9 = getContext().getResources().getDrawable(R.drawable.mtk_ujian_9);
        Drawable mtk_ujian_11 = getContext().getResources().getDrawable(R.drawable.mtk_ujian_11);

        List<Drawable> soal5 = new ArrayList<>();
        soal5.add(mtk_ujian_5);
        List<Drawable> soal6 = new ArrayList<>();
        soal6.add(mtk_ujian_6);
        List<Drawable> soal7 = new ArrayList<>();
        soal7.add(mtk_ujian_7);
        List<Drawable> soal8 = new ArrayList<>();
        soal8.add(mtk_ujian_8);
        List<Drawable> soal9 = new ArrayList<>();
        soal9.add(mtk_ujian_9);
        List<Drawable> soal11 = new ArrayList<>();
        soal11.add(mtk_ujian_11);

        imageSoalList.add(new ArrayList<Drawable>());
        imageSoalList.add(new ArrayList<Drawable>());
        imageSoalList.add(new ArrayList<Drawable>());
        imageSoalList.add(new ArrayList<Drawable>());
        imageSoalList.add(soal5);
        imageSoalList.add(soal6);
        imageSoalList.add(soal7);
        imageSoalList.add(soal8);
        imageSoalList.add(soal9);
        imageSoalList.add(new ArrayList<Drawable>());
        imageSoalList.add(soal11);

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
                if (levelupMTK==0) {
                    levelupMTK += 100;
                    levelku += 1;
                    updateNilai();
                    Intent intent;
                    if (score >= score_mtk_ujian) {
                        score_mtk_ujian = score;
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
                    if(score < score_mtk_ujian){
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
                if(levelupMTK>=1){
                    Intent intent;
                    if (score >= score_mtk_ujian) {
                        score_mtk_ujian = score;
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
                    if(score < score_mtk_ujian){
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

                //Load Image
                imageSoalAdapter.submitList(imageSoalList.get(nomor) != null ? imageSoalList.get(nomor) : new ArrayList<Drawable>());

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

        editor.putInt(getString(R.string.Level_MTK_UP), levelupMTK);
        editor.putInt(getString(R.string.SCORE_MTK_Ujian), score_mtk_ujian);
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