package me.clonalejandro.clonasister.tasks;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import me.clonalejandro.clonasister.Manager;
import me.clonalejandro.clonasister.R;
import me.clonalejandro.clonasister.utils.ArpaLock;

/**
 * Created by alejandrorioscalera
 * On 21/2/18
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


public class MainTask extends Service {


    /** SMALL CONSTRUCTORS **/

    private ArpaLock ARPALOCK;
    private final Runnable RUNNABLE = new Runnable() {
        @Override
        public void run() {
            while (!Manager.ISROOT){
                try {
                    Thread.sleep(200);
                    onIntent();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    };


    /** REST **/

    @Override
    public void onCreate() {
        ARPALOCK = new ArpaLock(getApplicationContext());

        new Thread(RUNNABLE).start();

        final Intent notificationIntent = new Intent(getApplicationContext(), MainTask.class);

        final PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        final Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.fingerprint)
                .setContentTitle("ClonaSec")
                .setContentText("Analyzing the system...")
                .setContentIntent(pendingIntent).build();

        startForeground(1996, notification);
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
        ARPALOCK.lockWiFi();
        ARPALOCK.lockNetwork();
        ARPALOCK.lockBluetooth();
    }


}
