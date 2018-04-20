package me.clonalejandro.clonasister.utils;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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


public class Toaster {


    /** SMALL CONSTRUCTORS **/

    private AppCompatActivity appCompatActivity;

    public Toaster(AppCompatActivity appCompatActivity, View view, String msg, int colorText,
                   int colorBackground, int textSize, Duration duration){
        this.appCompatActivity = appCompatActivity;
        snackbarCreator(view, msg, colorText, colorBackground, textSize, duration);
    }

    public Toaster(AppCompatActivity appCompatActivity, View view, String msg, int textSize, Duration duration){
        this.appCompatActivity = appCompatActivity;
        snackbarCreator(view, msg, textSize, duration);
    }


    /** REST **/

    /**
     * This enum of this elements Duration
     */
    public enum Duration {
        SHORT, MEDIUM, LONG, CLONA_PENIS
    }


    /** OTHERS **/

    /**
     * This function launch a Toaster
     * @param view
     * @param msg
     * @param colorText
     * @param colorBackground
     * @param textSize
     * @param duration
     * @return
     */
    private void snackbarCreator(final View view, final String msg, final int colorText, final int colorBackground,
                                 final int textSize, final Duration duration){
        final int Id = android.support.design.R.id.snackbar_text;
        int d, low = 0, high = 0;

        switch (duration){
            default:
                low = Toast.LENGTH_SHORT;
                d = low;
                break;
            case MEDIUM:
                d = low * 2;
                break;

            case LONG:
                high = Toast.LENGTH_LONG;
                d = high;
                break;
            case CLONA_PENIS:
                d = high * 2;
                break;
        }

        final Snackbar snackbar = Snackbar.make(view, msg, d);
        final View snackbarView = snackbar.getView();
        final TextView text = snackbarView.findViewById(Id);

        snackbarView.setBackgroundColor(colorBackground);
        text.setTextColor(colorText);

        if(textSize != 0) text.setTextSize(textSize);

        snackbar.show();
    }


    /**
     * This function launch a Toaster
     * @param view
     * @param msg
     * @param textSize
     * @param duration
     * @return
     */
    private void snackbarCreator(final View view, final String msg, final int textSize, final Duration duration){
        final int Id = android.support.design.R.id.snackbar_text;
        int d, low = 0, high = 0;

        switch (duration){
            default:
                low = Toast.LENGTH_SHORT;
                d = low;
                break;
            case MEDIUM:
                d = low * 2;
                break;

            case LONG:
                high = Toast.LENGTH_LONG;
                d = high;
                break;
            case CLONA_PENIS:
                d = high * 2;
                break;
        }

        final Snackbar snackbar = Snackbar.make(view, msg, d);
        final View snackbarView = snackbar.getView();
        final TextView text = snackbarView.findViewById(Id);

        if(textSize != 0) text.setTextSize(textSize);

        snackbar.show();
    }


}
