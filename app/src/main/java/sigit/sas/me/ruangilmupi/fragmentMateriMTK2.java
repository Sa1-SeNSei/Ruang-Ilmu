package sigit.sas.me.ruangilmupi;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class fragmentMateriMTK2 extends Fragment {


    View fragmentLayout;

    public fragmentMateriMTK2(){}
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi_mtk2,container,false);

        Button spoiler1_mtk2_A = (Button) fragmentLayout.findViewById(R.id.spoiler1_mtk2_A);
        Button spoiler1_mtk2_B = (Button) fragmentLayout.findViewById(R.id.spoiler1_mtk2_B);
        Button spoiler1_mtk2_C = (Button) fragmentLayout.findViewById(R.id.spoiler1_mtk2_C);
        Button spoiler1_mtk2_D = (Button) fragmentLayout.findViewById(R.id.spoiler1_mtk2_D);
        Button spoiler1_mtk2_E = (Button) fragmentLayout.findViewById(R.id.spoiler1_mtk2_E);
        Button spoiler1_mtk2_F = (Button) fragmentLayout.findViewById(R.id.spoiler1_mtk2_F);



        spoiler1_mtk2_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_a = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk2_A);

                if(spoilerLayout_mtk1_a.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_a.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_a.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_mtk2_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_b = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk2_B);

                if(spoilerLayout_mtk1_b.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_b.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_b.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_mtk2_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_c = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk2_C);

                if(spoilerLayout_mtk1_c.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_c.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_c.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_mtk2_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_d = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk2_D);

                if(spoilerLayout_mtk1_d.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_d.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_d.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler1_mtk2_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk2_e = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk2_E);

                if(spoilerLayout_mtk2_e.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk2_e.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk2_e.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler1_mtk2_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk2_f = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk2_F);

                if(spoilerLayout_mtk2_f.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk2_f.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk2_f.setVisibility(View.VISIBLE);
                }
            }

        });

        return fragmentLayout;
    }
}
