package me.clonalejandro.clonasister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

import me.clonalejandro.clonasister.utils.Colors;
import me.clonalejandro.clonasister.utils.SwitchHandler;
import me.clonalejandro.clonasister.utils.Toaster;
import me.clonalejandro.clonasister.windows.Options;

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


public class Settings extends AppCompatActivity {


    /** SMALL CONSTRUCTORS **/

    public static Settings SETTINGS;


    /** REST **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SETTINGS = this;

        init();
    }


    /** OTHERS **/

    /**
     * This function init the activity
     */
    private void init(){
        new Options(SETTINGS).setWindow();
        wifiSwitch();
        bluetoothSwitch();
    }


    /**
     * This function manage the wifi switch
     */
    private void wifiSwitch(){
        final Switch wifi = findViewById(R.id.settings_switch_wifi);
        new SwitchHandler(wifi) {
            @Override
            public void onBind(View view) {
                if (wifi.isChecked()) onClickSwitch(view, Types.WIFI, true);
                else onClickSwitch(view, Types.WIFI, false);
            }
        };
    }


    /**
     * This function manage the bluetooth switch
     */
    private void bluetoothSwitch(){
        final Switch bluetooth = findViewById(R.id.settings_switch_bluetooth);
        new SwitchHandler(bluetooth) {
            @Override
            public void onBind(View view) {
                if (bluetooth.isChecked()) onClickSwitch(view, Types.BLUETOOTH, true);
                else onClickSwitch(view, Types.BLUETOOTH, false);
            }
        };
    }


    /**
     * Enum of values
     */
    private enum Types { BLUETOOTH, WIFI }


    /**
     * This function manages on Click Switch
     * @param view
     * @param types
     * @param active
     */
    private void onClickSwitch(final View view, final Types types, final boolean active){
        switch (types){
            case WIFI:
                if (active)
                    new Toaster(this, view, "Success Wi-Fi enabled", Colors.WHITE, Colors.GREEN, 0, Toaster.Duration.MEDIUM);
                else
                    new Toaster(this, view, "Success Wi-Fi disabled", Colors.WHITE, Colors.RED, 0, Toaster.Duration.MEDIUM);
                break;
            case BLUETOOTH:
                if (active)
                    new Toaster(this, view, "Success Bluetooth enabled", Colors.WHITE, Colors.GREEN, 0, Toaster.Duration.MEDIUM);
                else
                    new Toaster(this, view, "Success Bluetooth disabled", Colors.WHITE, Colors.RED, 0, Toaster.Duration.MEDIUM);
                break;
        }
        Manager.setISROOT(active);
    }


}
