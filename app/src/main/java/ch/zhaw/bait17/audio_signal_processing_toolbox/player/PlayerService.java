package ch.zhaw.bait17.audio_signal_processing_toolbox.player;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by georgrem, stockan1 on 11.03.2017.
 */

public class PlayerService extends Service {

    private static final String TAG = PlayerService.class.getSimpleName();

    private final IBinder binder = new PlayerBinder();
    private AudioPlayer player = WavePlayer.getInstance();

    public static Intent getIntent(Context context) {
        return new Intent(context, PlayerService.class);
    }

    public class PlayerBinder extends Binder {
        public AudioPlayer getService() {
            return player;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // A client is binding to the service with bindService()
        Log.d(TAG, "Service binded");
        return binder;
    }

    @Override
    public void onDestroy() {
        // The service is no longer used and is being destroyed
        Log.d(TAG, "Service destroyed");
        player.release();
        super.onDestroy();
    }
}