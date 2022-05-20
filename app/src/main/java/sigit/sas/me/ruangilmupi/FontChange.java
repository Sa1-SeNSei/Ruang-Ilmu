package sigit.sas.me.ruangilmupi;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class FontChange extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Fonts/ComicSans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //....
    }

}
