package me.clonalejandro.clonasister.utils;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import me.clonalejandro.clonasister.Manager;

/**
 * Created by alejandrorioscalera
 * On 21/2/18
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


public class ArpaLock {


    /** SMALL CONSTRUCTORS **/

    private final Object WIFI, NETWORK, BLUETOOTH;
    private final boolean isUserRoot = Manager.ISROOT;

    public ArpaLock(Context context){
        WIFI = context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        NETWORK = context.getApplicationContext().getSystemService(Context.TELECOM_SERVICE);
        BLUETOOTH = context.getApplicationContext().getSystemService(Context.BLUETOOTH_SERVICE);
    }


    /** REST **/

    /**
     * This function lock the service WiFi
     */
    public void lockWiFi(){
        if (isWiFiActive() && !isUserRoot) wifiLocker();
    }


    /**
     * This function lock the service Network
     */
    public void lockNetwork(){
        if (isNetworkActive() && !isUserRoot) networkLocker();
    }


    /**
     * This function disable Bluetooth
     */
    public void lockBluetooth(){
        if (isBluetoothActive() && !isUserRoot) bluetoothLocker();
    }


    /** OTHERS **/

    /**
     * This function manage the action of lock the WiFi
     */
    private void wifiLocker(){
        ((WifiManager)WIFI).setWifiEnabled(false);
    }


    /**
     * This function manage the action of lock the Network
     */
    private void networkLocker(){
    }


    /**
     * This function manage the action of lock the Bluetooth
     */
    private void bluetoothLocker(){
        final BluetoothManager bluetoothManager = ((BluetoothManager)BLUETOOTH);

        if (bluetoothManager.getAdapter() != null) bluetoothManager.getAdapter().disable();
    }


    /**
     * This function check if WiFi is active
     * @return
     */
    private boolean isWiFiActive(){
        return ((WifiManager) WIFI).isWifiEnabled();
    }


    /**
     * This function check if network is active
     * @return
     */
    private boolean isNetworkActive() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && ((TelephonyManager) NETWORK).isDataEnabled();
    }


    /**
     * This function check if bluetooth is active
     * @return
     */
    private boolean isBluetoothActive() {
        final BluetoothManager bluetoothManager = ((BluetoothManager) BLUETOOTH);
        return bluetoothManager.getAdapter() != null && bluetoothManager.getAdapter().isEnabled();
    }


}
