package sigit.sas.me.ruangilmupi;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.util.Log;

public class soundManager {
    private static final String TAG = "MusicManager";

    public static MediaPlayer mp;

    private static int currentMusic = 0;
    private static int currentPosition= 0;

    private static boolean onOff;
    private static SharedPreferences userData;

    private static Context contextku;
    public static void start(Context context) {
        start(context, false);
    }

    public static void start(Context context, boolean force) {
        contextku = context;
        userData = PreferenceManager.getDefaultSharedPreferences(context);
        onOff = userData.getBoolean(context.getString(R.string.QUIZ_AKU_BGM), true);
        if (!force && currentMusic > 0) {
            // already playing some music and not forced to change
            return;
        }

//        String var = String.valueOf(onOff);
//        Toast.makeText(context, var, Toast.LENGTH_LONG).show();
        currentMusic = 1;
        mp = MediaPlayer.create(context, R.raw.bgm);
        if (mp != null && onOff) {
            if (!mp.isPlaying()) {
                mp.setVolume(50, 50);
                mp.setLooping(true);
                mp.start();
            }
        }

    }

    public static void pause() {

        if (mp.isPlaying()) {
            mp.pause();
            currentPosition = mp.getCurrentPosition();
        }
    }


    public static void stop(){
        if (mp.isPlaying()) {

            mp.pause();
            currentPosition = 0;

        }
    }

    public static void resume() {

        onOff = userData.getBoolean(contextku.getString(R.string.QUIZ_AKU_BGM), true);

        if(onOff){
            if (!mp.isPlaying()) {
                mp.seekTo(currentPosition);
                mp.start();
            }
        }

    }

    public static void release() {
        Log.d(TAG, "Releasing media players");
        try {
            if (mp != null) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                mp.release();
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }
}