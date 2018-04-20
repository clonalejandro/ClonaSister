package me.clonalejandro.clonasister;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import me.clonalejandro.clonasister.utils.ButtonHandler;
import me.clonalejandro.clonasister.utils.Colors;
import me.clonalejandro.clonasister.utils.Toaster;
import me.clonalejandro.clonasister.utils.User;
import me.clonalejandro.clonasister.windows.Login;

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


public class Manager extends AppCompatActivity {


    /** SMALL CONSTRUCTORS **/

    public static volatile Manager LOGIN;
    public static volatile boolean ISROOT;

    private Login login;
    private User userUtil = new User();


    /** REST **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LOGIN = this;
        ISROOT = false;

        login = new Login(this);

        login.setWindow();
        onSubmit();
    }


    /**
     * This function set ISROOT as True
     * @param val
     */
    public synchronized static void setISROOT(final boolean val){
        ISROOT = val;
    }


    /** OTHERS **/

    /**
     * This function manage on Submit the button
     */
    private void onSubmit(){
        buttonHandler(findViewById(R.id.home_button));
    }


    /**
     * This function register a button handler
     * @param button
     * @return
     */
    private void buttonHandler(final Button button){
        new ButtonHandler(button) {
            @Override
            public void onBind(View view) {
                checkFields(view);
            }
        };
    }


    /**
     * This function manage the action when fields is checked
     * @param view
     */
    private void checkFields(final View view){
        final EditText userField = findViewById(R.id.user_field),
                       passwordField = findViewById(R.id.password_field);

        if (!isCorrect(userField, userUtil.getUsername()))
            launchError(view, userField, "The username entered in username field is incorrect");
        if (!isCorrect(passwordField, userUtil.getPassword()))
            launchError(view, passwordField, "The password entered in password field is incorrect.");
        if (isCorrect(userField, userUtil.getUsername()) && isCorrect(passwordField, userUtil.getPassword()))
            onSuccess(view);
    }


    /**
     * This function is executed when password and user is correct
     * @param view
     */
    private void onSuccess(final View view){
        new Toaster(this, view, "Success you has been logged in",
                Colors.WHITE, Colors.GREEN, 0, Toaster.Duration.MEDIUM);
        login.startTask();
    }


    /**
     * This function launch an error in specific field
     * @param view
     * @param field
     * @param message
     */
    private void launchError(final View view, final EditText field, final String message){
        field.setError(message);
        new Toaster(this, view, message,
                Colors.WHITE, Colors.RED, 0, Toaster.Duration.MEDIUM);
    }


    /**
     * This function check if fields is correct
     * @param field
     * @param target
     * @return
     */
    private boolean isCorrect(final EditText field, String target){
        return field.getText().toString().equals(target);
    }


}
