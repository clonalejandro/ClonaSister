package me.clonalejandro.clonasister;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.clonalejandro.clonasister.tasks.MainTask;
import me.clonalejandro.clonasister.utils.ButtonHandler;
import me.clonalejandro.clonasister.utils.Colors;
import me.clonalejandro.clonasister.utils.FirstRun;
import me.clonalejandro.clonasister.utils.Toaster;
import me.clonalejandro.clonasister.windows.Splash;

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


public class Home extends AppCompatActivity {


    /** SMALL CONSTRUCTORS **/

    public volatile static Home INSTANCE;
    private Splash splash;


    /** REST **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        INSTANCE = this;

        init();
        startTask();
    }


    /** OTHERS **/

    /**
     * This function start the main task
     */
    private void startTask(){
        final Context context = getApplicationContext();
        context.startService(
                new Intent(context, MainTask.class)
        );
    }


    /**
     * This function manage init splash screen
     */
    private void init(){
        final boolean isFirstRun = new FirstRun(this).isFirstRun();

        if (isFirstRun) startSplash();
        else nextScreen();
    }


    /**
     * This function start splash screen
     */
    private void startSplash(){
        splash = new Splash(this);
        splash.setWindow();
        registerListener(
                findViewById(R.id.splashBtn)
        );
    }


    /**
     * This function register a ButtonHandler
     * @param button
     */
    private void registerListener(final Button button){
        new ButtonHandler(button) {
            @Override
            public void onBind(View view) {
                nextScreen();
                cancelSplashTask();
            }
        };
    }


    /**
     * This function change the content of the next screen
     */
    private void nextScreen(){
        final Context context = getApplicationContext();
        final Intent intent = new Intent(context, Manager.class);

        Home.INSTANCE.startActivity(intent);
    }


    /**
     * This function stop de splashTask
     */
    private void cancelSplashTask(){
        splash.stopTask();
    }


}
