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

public class fragmentMateriIPA2 extends Fragment {

    View fragmentLayout;

    public fragmentMateriIPA2(){}
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi_ipa2,container,false);


        Button spoiler1_ipa2_1 = (Button) fragmentLayout.findViewById(R.id.spoiler_ipa2_1);
        Button spoiler1_ipa2_2 = (Button) fragmentLayout.findViewById(R.id.spoiler_ipa2_2);
        Button spoiler1_ipa2_3 = (Button) fragmentLayout.findViewById(R.id.spoiler_ipa2_3);

        spoiler1_ipa2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_ipa2_1 = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_ipa2_1);

                if(spoilerLayout_ipa2_1.getVisibility() == View.VISIBLE){
                    spoilerLayout_ipa2_1.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_ipa2_1.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_ipa2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_ipa2_2 = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_ipa2_2);

                if(spoilerLayout_ipa2_2.getVisibility() == View.VISIBLE){
                    spoilerLayout_ipa2_2.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_ipa2_2.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler1_ipa2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout_ipa2_3 = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout_ipa2_3);

                if(spoilerLayout_ipa2_3.getVisibility() == View.VISIBLE){
                    spoilerLayout_ipa2_3.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout_ipa2_3.setVisibility(View.VISIBLE);
                }
            }

        });



        return fragmentLayout;
    }
}