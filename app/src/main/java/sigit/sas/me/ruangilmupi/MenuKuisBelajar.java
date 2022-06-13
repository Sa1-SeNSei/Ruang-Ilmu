package sigit.sas.me.ruangilmupi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MenuKuisBelajar extends AppCompatActivity {
    //Bagian Untuk Ngambil Nama sama level di akun
    LinkedList<Drawable> level = new LinkedList<Drawable>();
    public ImageView levelImage;
    TextView namaAkun;

    Animation myAnim;
    boolean spoiler11= false;

    public enum FragmentToLaunch {Materi_IPA_1,Materi_IPA_2,Materi_IPA_3,
                                Materi_MTK_1,Materi_MTK_2,Materi_MTK_3,
                                Materi_INDO_1,Materi_INDO_2,Materi_INDO_3};

    public enum FragmentToLaunchIPA {Materi_IPA_1,Materi_IPA_2,Materi_IPA_3}
    public enum FragmentToLaunchMTK {Materi_MTK_1,Materi_MTK_2,Materi_MTK_3}
    public enum FragmentToLaunchINDO {Materi_INDO_1,Materi_INDO_2,Materi_INDO_3}


    SharedPreferences userData;
    SharedPreferences.Editor editor;

    LinkedList<Button> btnIPA = new LinkedList<>();
    LinkedList<Button> btnINDO = new LinkedList<>();
    LinkedList<Button> btnMTK = new LinkedList<>();

    LinkedList<Drawable> btnImagesIPA = new LinkedList<>();
    LinkedList<Drawable> btnImagesTutupIPA = new LinkedList<>();

    LinkedList<Drawable> btnImagesMTK = new LinkedList<>();
    LinkedList<Drawable> btnImagesTutupMTK = new LinkedList<>();

    LinkedList<Drawable> btnImagesINDO = new LinkedList<>();
    LinkedList<Drawable> btnImagesTutupINDO = new LinkedList<>();

    int score_ipa_latihan1;
    int score_ipa_latihan2;
    int score_ipa_ujian;

    int score_mtk_latihan1;
    int score_mtk_latihan2;
    int score_mtk_ujian;

    int score_indo_latihan1;
    int score_indo_latihan2;
    int score_indo_ujian;

    int progressbar_level;

    Integer levelku;
    @Override
    protected void onRestart() {
        super.onRestart();

        checkScore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kuis_belajar);
        levelImage = (ImageView) findViewById(R.id.level);
        namaAkun = (TextView) findViewById(R.id.akun);


        //Button UI
        final Button btnNama = (Button) findViewById(R.id.btn_akun);

        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        namaAkun.setText(namaTersimpan);

        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);

        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        final Button btnMateri1_ipa = (Button) findViewById(R.id.btnLatihan1_IPA);
        final Button btnMateri2_ipa = (Button) findViewById(R.id.btnLatihan2_IPA);
        final Button btnMateri3_ipa = (Button) findViewById(R.id.btnUjian_IPA);
        final Button btnMateri4_ipa = (Button) findViewById(R.id.btnPembahasan_IPA);

        final Button btnMateri1_mtk = (Button) findViewById(R.id.btnLatihan1_MTK);
        final Button btnMateri2_mtk = (Button) findViewById(R.id.btnLatihan2_MTK);
        final Button btnMateri3_mtk = (Button) findViewById(R.id.btnUjian_MTK);
        final Button btnMateri4_mtk = (Button) findViewById(R.id.btnPembahasan_MTK);

        final Button btnMateri1_indo = (Button) findViewById(R.id.btnLatihan1_INDO);
        final Button btnMateri2_indo = (Button) findViewById(R.id.btnLatihan2_INDO);
        final Button btnMateri3_indo = (Button) findViewById(R.id.btnUjian_INDO);
        final Button btnMateri4_indo = (Button) findViewById(R.id.btnPembahasan_INDO);

        intentInitialize = false;

        btnImagesIPA.add(ResourcesCompat.getDrawable(getResources(),R.drawable.ipa_lat1,null));
        btnImagesIPA.add(ResourcesCompat.getDrawable(getResources(),R.drawable.ipa_lat2,null));
        btnImagesIPA.add(ResourcesCompat.getDrawable(getResources(),R.drawable.ipa_ujian,null));
        btnImagesIPA.add(ResourcesCompat.getDrawable(getResources(),R.drawable.ipa_pembahasan,null));

        btnImagesMTK.add(ResourcesCompat.getDrawable(getResources(),R.drawable.mtk_lat1,null));
        btnImagesMTK.add(ResourcesCompat.getDrawable(getResources(),R.drawable.mtk_lat2,null));
        btnImagesMTK.add(ResourcesCompat.getDrawable(getResources(),R.drawable.mtk_ujian,null));
        btnImagesMTK.add(ResourcesCompat.getDrawable(getResources(),R.drawable.mtk_pembahasan,null));

        btnImagesINDO.add(ResourcesCompat.getDrawable(getResources(),R.drawable.indo_lat1,null));
        btnImagesINDO.add(ResourcesCompat.getDrawable(getResources(),R.drawable.indo_lat2,null));
        btnImagesINDO.add(ResourcesCompat.getDrawable(getResources(),R.drawable.indo_ujian,null));
        btnImagesINDO.add(ResourcesCompat.getDrawable(getResources(),R.drawable.indo_pembahasan,null));

        btnImagesTutupIPA.add(ResourcesCompat.getDrawable(getResources(), R.drawable.ipa_lat1_kunci, null));
        btnImagesTutupIPA.add(ResourcesCompat.getDrawable(getResources(), R.drawable.ipa_lat2_kunci, null));
        btnImagesTutupIPA.add(ResourcesCompat.getDrawable(getResources(), R.drawable.ipa_ujian_kunci, null));
        btnImagesTutupIPA.add(ResourcesCompat.getDrawable(getResources(), R.drawable.ipa_pembahasan_kunci, null));

        btnImagesTutupMTK.add(ResourcesCompat.getDrawable(getResources(), R.drawable.mtk_lat1_kunci, null));
        btnImagesTutupMTK.add(ResourcesCompat.getDrawable(getResources(), R.drawable.mtk_lat2_kunci, null));
        btnImagesTutupMTK.add(ResourcesCompat.getDrawable(getResources(), R.drawable.mtk_ujian_kunci, null));
        btnImagesTutupMTK.add(ResourcesCompat.getDrawable(getResources(), R.drawable.mtk_pembahasan_kunci, null));

        btnImagesTutupINDO.add(ResourcesCompat.getDrawable(getResources(), R.drawable.indo_lat1_kunci, null));
        btnImagesTutupINDO.add(ResourcesCompat.getDrawable(getResources(), R.drawable.indo_lat2_kunci, null));
        btnImagesTutupINDO.add(ResourcesCompat.getDrawable(getResources(), R.drawable.indo_ujian_kunci, null));
        btnImagesTutupINDO.add(ResourcesCompat.getDrawable(getResources(), R.drawable.indo_pembahasan_kunci, null));

        final int score_ipa_latihan1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        final int score_ipa_latihan2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        final int score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);

        final int score_mtk_latihan1 = userData.getInt(getString(R.string.SCORE_MTK_Latihan1), 0);
        final int score_mtk_latihan2 = userData.getInt(getString(R.string.SCORE_MTK_Latihan2), 0);
        final int score_mtk_ujian = userData.getInt(getString(R.string.SCORE_MTK_Ujian), 0);

        final int score_indo_latihan1 = userData.getInt(getString(R.string.SCORE_INDO_Latihan1), 0);
        final int score_indo_latihan2 = userData.getInt(getString(R.string.SCORE_INDO_Latihan2), 0);
        final int score_indo_ujian = userData.getInt(getString(R.string.SCORE_INDO_Ujian), 0);

        btnIPA.add(btnMateri1_ipa);
        btnIPA.add(btnMateri2_ipa);
        btnIPA.add(btnMateri3_ipa);
        btnIPA.add(btnMateri4_ipa);

        btnMTK.add(btnMateri1_mtk);
        btnMTK.add(btnMateri2_mtk);
        btnMTK.add(btnMateri3_mtk);
        btnMTK.add(btnMateri4_mtk);

        btnINDO.add(btnMateri1_indo);
        btnINDO.add(btnMateri2_indo);
        btnINDO.add(btnMateri3_indo);
        btnINDO.add(btnMateri4_indo);

        checkScore();

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
            case 5:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level6, null));
                break;
            case 6:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level7, null));
                break;
            case 7:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level8, null));
                break;
            case 8:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level9, null));
                break;
            default:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.leveldewa, null));
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        //Fragment transaction pakenya support.v4.app.fragmenttransaction
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();


        //Onclick Listener Button Kuis IPA
        btnNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNama.startAnimation(myAnim);
                Intent intentku = new Intent(getApplicationContext(), Akun.class);
                intentInitialize = true;
                startActivity(intentku);
            }
        });

        btnMateri1_ipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri1_ipa.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), LayoutMateri.class);
                intent.putExtra(getString(R.string.MateriFragmentIPA),FragmentToLaunch.Materi_IPA_1);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri2_ipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri2_ipa.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), LayoutMateri.class);
                intent.putExtra(getString(R.string.MateriFragmentIPA),FragmentToLaunch.Materi_IPA_2);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri3_ipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri3_ipa.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), Kuis.class);
                intent.putExtra(getString(R.string.KuisFragmentIPA),MenuKuisBelajar.FragmentToLaunch.Materi_IPA_3);
                intentInitialize = true;
                startActivity(intent);

         /*       if (score_ipa_latihan1 >= 80 && score_ipa_latihan2 >=80) {
                    Intent intent = new Intent(getApplicationContext(), Kuis.class);
                    intent.putExtra(getString(R.string.KuisFragmentIPA),MenuKuisBelajar.FragmentToLaunch.Materi_IPA_3);
                    intentInitialize = true;
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Anda harus Mengerjakan Latihan 1 & 2 dengan minimal nilai 80", Toast.LENGTH_LONG).show();
                }*/

            }
        });
        btnMateri4_ipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri4_ipa.startAnimation(myAnim);
                    Intent intent=new Intent(getApplicationContext(), KuisPembahasanIPA_Ujian.class);
                    startActivity(intent);
            }
        });

        btnMateri1_mtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri1_mtk.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), LayoutMateri.class);
                intent.putExtra(getString(R.string.MateriFragmentIPA),FragmentToLaunch.Materi_MTK_1);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri2_mtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri2_mtk.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), LayoutMateri.class);
                intent.putExtra(getString(R.string.MateriFragmentIPA),FragmentToLaunch.Materi_MTK_2);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri3_mtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri3_mtk.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), Kuis.class);
                intent.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_MTK_3);
                intentInitialize = true;
                startActivity(intent);
            }
        });
        btnMateri4_mtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri4_mtk.startAnimation(myAnim);
                Intent intent=new Intent(getApplicationContext(), KuisPembahasanMTK_Ujian.class);
                startActivity(intent);
            }
        });

        btnMateri1_indo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri1_indo.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), LayoutMateri.class);
                intent.putExtra(getString(R.string.MateriFragmentIPA),FragmentToLaunch.Materi_INDO_1);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri2_indo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri2_mtk.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), LayoutMateri.class);
                intent.putExtra(getString(R.string.MateriFragmentIPA),FragmentToLaunch.Materi_INDO_2);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri3_indo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri3_mtk.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), Kuis.class);
                intent.putExtra(getString(R.string.KuisFragmentIPA), MenuKuisBelajar.FragmentToLaunch.Materi_INDO_3);
                intentInitialize = true;
                startActivity(intent);
            }
        });
        btnMateri4_indo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri4_mtk.startAnimation(myAnim);
                Intent intent=new Intent(getApplicationContext(), KuisPembahasanINDO_Ujian.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private void checkScore() {
        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        int score_ipa_latihan1 = userData.getInt(getString(R.string.SCORE_IPA_Latihan1), 0);
        int score_ipa_latihan2 = userData.getInt(getString(R.string.SCORE_IPA_Latihan2), 0);
        int score_ipa_ujian = userData.getInt(getString(R.string.SCORE_IPA_Ujian), 0);

        int score_mtk_latihan1 = userData.getInt(getString(R.string.SCORE_MTK_Latihan1), 0);
        int score_mtk_latihan2 = userData.getInt(getString(R.string.SCORE_MTK_Latihan2), 0);
        int score_mtk_ujian = userData.getInt(getString(R.string.SCORE_MTK_Ujian), 0);

        int score_indo_latihan1 = userData.getInt(getString(R.string.SCORE_INDO_Latihan1), 0);
        int score_indo_latihan2 = userData.getInt(getString(R.string.SCORE_INDO_Latihan2), 0);
        int score_indo_ujian = userData.getInt(getString(R.string.SCORE_INDO_Ujian), 0);

        btnIPA.get(0).setBackground(btnImagesIPA.get(0));
        btnIPA.get(0).setEnabled(true);

        btnIPA.get(1).setBackground(btnImagesIPA.get(1));
        btnIPA.get(1).setEnabled(true);

        //Button Buka IPA
        if ((score_ipa_latihan1 >= 80) && (score_ipa_latihan2 >= 80)) {
            btnIPA.get(2).setBackground(btnImagesIPA.get(2));
            btnIPA.get(2).setEnabled(true);
        } else {
            btnIPA.get(2).setBackground(btnImagesTutupIPA.get(2));
            btnIPA.get(2).setEnabled(false);
        }
        if (score_ipa_ujian >= 80) {
            btnIPA.get(3).setBackground(btnImagesIPA.get(3));
            btnIPA.get(3).setEnabled(true);
        } else {
            btnIPA.get(3).setBackground(btnImagesTutupIPA.get(3));
            btnIPA.get(3).setEnabled(false);
        }

        //Button Buka MTK
        if ((score_mtk_latihan1 >= 80) && (score_mtk_latihan2 >= 80)) {
            btnMTK.get(2).setBackground(btnImagesMTK.get(2));
            btnMTK.get(2).setEnabled(true);
        } else {
            btnMTK.get(2).setBackground(btnImagesTutupMTK.get(2));
            btnMTK.get(2).setEnabled(false);
        }
        if (score_mtk_ujian >= 80) {
            btnMTK.get(3).setBackground(btnImagesMTK.get(3));
            btnMTK.get(3).setEnabled(true);
        } else {
            btnMTK.get(3).setBackground(btnImagesTutupMTK.get(3));
            btnMTK.get(3).setEnabled(false);
        }


        //Button Buka B.Indo
        if ((score_indo_latihan1 >= 80) && (score_indo_latihan2 >= 80)) {
            btnINDO.get(2).setBackground(btnImagesINDO.get(2));
            btnINDO.get(2).setEnabled(true);
        } else {
            btnINDO.get(2).setBackground(btnImagesTutupINDO.get(2));
            btnINDO.get(2).setEnabled(false);
        }
        if (score_indo_ujian >= 80) {
            btnINDO.get(3).setBackground(btnImagesINDO.get(3));
            btnINDO.get(3).setEnabled(true);
        } else {
            btnINDO.get(3).setBackground(btnImagesTutupINDO.get(3));
            btnINDO.get(3).setEnabled(false);
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
        if (!intentInitialize) {
            soundManager.pause();
        }
        super.onPause();
    }
}
