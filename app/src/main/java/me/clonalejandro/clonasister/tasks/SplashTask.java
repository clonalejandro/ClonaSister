package me.clonalejandro.clonasister.tasks;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import me.clonalejandro.clonasister.Home;
import me.clonalejandro.clonasister.Manager;

/**
 * Created by alejandrorioscalera
 * On 25/2/18
 *
 * -- SOCIAL NETWORKS --
 *
 * GitHub: https://github.com/clonalejandro or @clonalejandro
 * Website: https://clonalejandro.me/
 * Twitter: https://twitter.com/clonalejandro11/ or @clonalejandro11
 * Keybase: https://keybase.io/clonalejandro/
 *
 * -- LICENSE --
 *
 * All rights reserved for clonalejandro ©ClonaSister 2017 / 2018
 */


public class SplashTask extends Service {


    /** SMALL CONSTRUCTORS **/

    private int time = 10;
    public static boolean bool = false;
    private Thread thread;

    private final Runnable RUNNABLE = () -> {
        while (!bool) try {
            Thread.sleep(1000);
            onIntent();
        }
        catch (Exception ex) {
            Log.d("DEBUG", ex.getMessage());
        }
    };


    /** REST **/

    @Override
    public void onCreate() {
        thread = new Thread(RUNNABLE);
        thread.start();
    }


    @Override @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }


    /** OTHERS **/

    /**
     * This function represents a back from loop
     */
    private void onIntent(){
        if (time != 0) time--;
        else {
            nextWindow();
            stopThread();
            bool = true;
        }
    }


    /**
     * This function kill the Thread task
     */
    private void stopThread() {
        if (thread != null) try {
            thread.join();
        } catch (Exception ex) {
            Log.d("DEBUG", ex.getMessage());
        }
    }


    /**
     * This function change the window while the counter has 0
     */
    private void nextWindow(){
        final Context context = Home.INSTANCE.getApplicationContext();
        final Intent intent = new Intent(context, Manager.class);

        Home.INSTANCE.startActivity(intent);
    }


}
