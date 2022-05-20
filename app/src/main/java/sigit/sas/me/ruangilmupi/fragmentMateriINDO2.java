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

public class fragmentMateriINDO2 extends Fragment {


    View fragmentLayout;

    public fragmentMateriINDO2(){}
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi_indo2,container,false);

        Button spoiler1_indo2_A = (Button) fragmentLayout.findViewById(R.id.spoiler_indo2_A);
        Button spoiler1_indo2_B = (Button) fragmentLayout.findViewById(R.id.spoiler_indo2_B);
        Button spoiler1_indo2_C = (Button) fragmentLayout.findViewById(R.id.spoiler_indo2_C);
        Button spoiler1_indo2_D = (Button) fragmentLayout.findViewById(R.id.spoiler_indo2_D);


        spoiler1_indo2_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_indo2_a = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_indo2_A);

                if(spoilerLayout_indo2_a.getVisibility() == View.VISIBLE){
                    spoilerLayout_indo2_a.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_indo2_a.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_indo2_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_indo2_a = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_indo2_B);

                if(spoilerLayout_indo2_a.getVisibility() == View.VISIBLE){
                    spoilerLayout_indo2_a.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_indo2_a.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_indo2_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_indo2_a = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_indo2_C);

                if(spoilerLayout_indo2_a.getVisibility() == View.VISIBLE){
                    spoilerLayout_indo2_a.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_indo2_a.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_indo2_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_indo2_a = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_indo2_D);

                if(spoilerLayout_indo2_a.getVisibility() == View.VISIBLE){
                    spoilerLayout_indo2_a.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_indo2_a.setVisibility(View.VISIBLE);
                }
            }

        });



        return fragmentLayout;
    }
}