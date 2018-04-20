package me.clonalejandro.clonasister.windows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.clonalejandro.clonasister.R;
import me.clonalejandro.clonasister.tasks.LoginTask;

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


public class Login implements IWindow {


    /** SMALL CONSTRUCTORS **/

    private View view;
    private int layout;
    private Intent service;

    private final AppCompatActivity appCompatActivity;

    public Login(AppCompatActivity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
        setWindow();
    }


    /** REST **/

    /**
     * This function set the window
     */
    public void setWindow() {
        layout = R.layout.activity_home;
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


    /**
     * This function start the task
     */
    public void startTask(){
        service = new Intent(appCompatActivity.getApplicationContext(), LoginTask.class);
        appCompatActivity.startService(service);
    }


    /**
     * This function stop the task
     */
    public void stopTask(){
        appCompatActivity.stopService(service);
        LoginTask.bool = true;
    }


    /** OTHERS **/


}
