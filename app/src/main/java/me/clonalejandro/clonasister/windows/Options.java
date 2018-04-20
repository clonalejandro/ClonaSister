package me.clonalejandro.clonasister.windows;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

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


public class Options implements IWindow {


    /** SMALL CONSTRUCTORS **/

    private View view;
    private int layout;

    private final AppCompatActivity appCompatActivity;

    public Options(AppCompatActivity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
        setWindow();
    }


    /** REST **/

    /**
     * This function set the window
     */
    public void setWindow() {
        layout = R.layout.activity_settings;
        view = null;

        appCompatActivity.setContentView(layout);
    }


    /**
     * This function remove the window
     */
    public void removeWindow() {
        appCompatActivity.setContentView(null);
    }


    /**
     * This function remove the window with view
     * @param view
     */
    public void removeWindow(final View view) {
        appCompatActivity.setContentView(view);
    }


    /**
     * This function remove the window with layoutResID
     * @param layoutResID
     */
    public void removeWindow(final int layoutResID) {
        appCompatActivity.setContentView(layoutResID);
    }


    /**
     * This function return a window view
     * @return
     */
    public View getWindowAsView() {
        return view;
    }


    /**
     * This function return a window layout
     * @return
     */
    public int getWindowAsLayout() {
        return layout;
    }


    /** OTHERS **/


}
