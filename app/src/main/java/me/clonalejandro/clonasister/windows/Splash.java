package me.clonalejandro.clonasister.windows;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import me.clonalejandro.clonasister.R;
import me.clonalejandro.clonasister.tasks.SplashTask;

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


public class Splash implements IWindow {


    /** SMALL CONSTRUCTORS **/

    private View view;
    private int layout;

    private Intent service;
    private final AppCompatActivity appCompatActivity;

    public Splash(AppCompatActivity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
    }


    /** REST **/

    /**
     * This function set the window
     */
    public void setWindow(){
        layout = R.layout.activity_splash;
        view = null;

        appCompatActivity.setContentView(layout);
        loadBackground();
        loadAnimation();
        startTask();
    }


    /**
     * This function remove the window
     */
    public void removeWindow(){
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
    public View getWindowAsView(){
        return view;
    }


    /**
     * This function return a window layout
     * @return
     */
    public int getWindowAsLayout(){
        return layout;
    }


    /**
     * This function stop the task
     */
    public void stopTask(){
        appCompatActivity.stopService(service);
        SplashTask.bool = true;
    }


    /** OTHERS **/

    /**
     * This function start the task
     */
    private void startTask(){
        service = new Intent(appCompatActivity.getApplicationContext(), SplashTask.class);
        appCompatActivity.startService(service);
    }


    /**
     * This function load the Background of splash screen
     */
    private void loadBackground(){
        final AnimationDrawable animationDrawable = (AnimationDrawable)
                appCompatActivity.findViewById(R.id.splash_layout).getBackground();

        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }


    /**
     * This function load the Animation of splash screen
     */
    private void loadAnimation(){
        final ImageView view = appCompatActivity.findViewById(R.id.imageLogo);
        final Animation animation = AnimationUtils.loadAnimation(
                appCompatActivity.getApplicationContext(), R.anim.fade
        );
        view.startAnimation(animation);
    }


}
