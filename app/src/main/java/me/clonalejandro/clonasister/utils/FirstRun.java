package me.clonalejandro.clonasister.utils;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import me.clonalejandro.clonasister.Home;

/**
 * Created by alejandrorioscalera
 * On 26/2/18
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


public class FirstRun {


    /** SMALL CONSTRUCTORS **/

    private boolean target = false;

    private final AppCompatActivity appCompatActivity;
    private final String PREFERENCE = "PREFERENCE";

    public FirstRun(){
        this.appCompatActivity = Home.INSTANCE;
    }

    public FirstRun(AppCompatActivity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
    }


    /** REST **/

    /**
     * This function return a result of this instance
     * @return
     */
    public boolean isFirstRun(){
        checkIfFirstRun();
        return target;
    }


    /** OTHERS **/

    /**
     * This function manage the checker of if this is first run
     */
    private void checkIfFirstRun(){
        target = appCompatActivity.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE).
                getBoolean("isfirstrun", true);
    }


}
