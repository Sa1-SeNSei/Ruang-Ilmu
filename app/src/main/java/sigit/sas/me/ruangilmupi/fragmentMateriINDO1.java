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

public class fragmentMateriINDO1 extends Fragment {


    View fragmentLayout;

    public fragmentMateriINDO1(){}
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi_indo1,container,false);

        Button spoiler1_indo1_A = (Button) fragmentLayout.findViewById(R.id.spoiler_indo1_A);
        Button spoiler1_indo1_B = (Button) fragmentLayout.findViewById(R.id.spoiler_indo1_B);


        spoiler1_indo1_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_indo1_a = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_indo1_A);

                if(spoilerLayout_indo1_a.getVisibility() == View.VISIBLE){
                    spoilerLayout_indo1_a.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_indo1_a.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_indo1_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_indo1_b = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_indo1_B);

                if(spoilerLayout_indo1_b.getVisibility() == View.VISIBLE){
                    spoilerLayout_indo1_b.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_indo1_b.setVisibility(View.VISIBLE);
                }
            }

        });



        return fragmentLayout;
    }
}