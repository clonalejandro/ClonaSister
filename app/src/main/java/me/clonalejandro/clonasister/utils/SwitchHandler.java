package me.clonalejandro.clonasister.utils;

import android.util.Log;
import android.view.View;
import android.widget.Switch;

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


public abstract class SwitchHandler {


    /** SMALL CONSTRUCTORS **/

    private final Switch swich;

    public SwitchHandler(Switch swich){
        this.swich = swich;
        register();
    }


    /** REST **/

    /**
     * This method will be executed on register the listener
     * @param view
     */
    public abstract void onBind(final View view);


    /** OTHERS **/

    /**
     * This function register a listener
     */
    private void register(){
        final View.OnClickListener listener = getListener();

        swich.setOnClickListener(listener);

        Log.d("DEBUG", "Handler catched of button: " + swich.getText());
    }


    /**
     * This function return a listener constructor
     * @return
     */
    private View.OnClickListener getListener(){
        return new View.OnClickListener() {
            public void onClick(View v) {
                onBind(v);
            }
        };
    }


}
