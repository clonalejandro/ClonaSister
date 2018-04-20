package me.clonalejandro.clonasister.listeners;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import me.clonalejandro.clonasister.tasks.MainTask;

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


public class SocketListener extends BroadcastReceiver {


    /** REST **/

    @Override @SuppressLint("UnsafeProtectedBroadcastReceiver")
    public void onReceive(Context context, Intent intent) {
        if (isMyTarget(intent)) startTask(context);
    }


    /** OTHERS **/

    /**
     * This function start the main Task
     * @param context
     */
    private void startTask(final Context context){
        context.startService(
                new Intent(context, MainTask.class)
        );
    }


    /**
     * This function check if is my target in this case if is the boot completed order
     * @param intent
     * @return
     */
    private boolean isMyTarget(final Intent intent){
       return Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction());
    }


}
