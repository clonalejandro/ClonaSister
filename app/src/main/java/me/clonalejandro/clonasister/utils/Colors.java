package me.clonalejandro.clonasister.utils;

import android.content.Context;
import android.support.annotation.ColorInt;

import me.clonalejandro.clonasister.Home;
import me.clonalejandro.clonasister.R;

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


public class Colors {


    /** SMALL CONSTRUCTORS **/

    @ColorInt
    public static final int
            PRIMARY = cleanCode(R.color.colorPrimary),
            SECONDARY = cleanCode(R.color.colorAccent),
            RED = cleanCode(R.color.red),
            GREEN = cleanCode(R.color.green),
            BLACK = cleanCode(R.color.black),
            WHITE = cleanCode(R.color.white);


    /** REST **/

    /**
     * @deprecated
     * @param color
     * @return
     */
    @Deprecated
    private static int cleanCode(int color){
        Context context = Home.INSTANCE.getApplicationContext();
        return context.getResources().getColor(color);
    }


}
