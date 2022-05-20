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

public class fragmentMateriMTK1 extends Fragment {


    View fragmentLayout;

    public fragmentMateriMTK1(){}
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi_mtk1,container,false);

        Button spoiler1_mtk1_A = (Button) fragmentLayout.findViewById(R.id.spoiler_mtk1_A);
        Button spoiler1_mtk1_B = (Button) fragmentLayout.findViewById(R.id.spoiler_mtk1_B);
        Button spoiler1_mtk1_C = (Button) fragmentLayout.findViewById(R.id.spoiler_mtk1_C);
        Button spoiler1_mtk1_D = (Button) fragmentLayout.findViewById(R.id.spoiler_mtk1_D);
        Button spoiler1_mtk1_E = (Button) fragmentLayout.findViewById(R.id.spoiler_mtk1_E);

        spoiler1_mtk1_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_a = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk1_A);

                if(spoilerLayout_mtk1_a.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_a.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_a.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_mtk1_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_b = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk1_B);

                if(spoilerLayout_mtk1_b.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_b.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_b.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_mtk1_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_c = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk1_C);

                if(spoilerLayout_mtk1_c.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_c.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_c.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_mtk1_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_mtk1_d = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_mtk1_D);

                if(spoilerLayout_mtk1_d.getVisibility() == View.VISIBLE){
                    spoilerLayout_mtk1_d.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_mtk1_d.setVisibility(View.VISIBLE);
                }
            }

        });

        return fragmentLayout;
    }
}
