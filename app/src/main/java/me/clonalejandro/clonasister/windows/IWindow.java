package me.clonalejandro.clonasister.windows;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

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


public interface IWindow {


    /** INTERFACE **/

    /**
     * This function set the window
     */
    public void setWindow();


    /**
     * This function remove the window
     */
    public void removeWindow();


    /**
     * This function remove the window with view
     * @param view
     */
    public void removeWindow(final View view);


    /**
     * This function remove the window with layoutResID
     * @param layoutResID
     */
    public void removeWindow(final int layoutResID);


    /**
     * This function return a window view
     * @return
     */
    public View getWindowAsView();


    /**
     * This function return a window layout
     * @return
     */
    public int getWindowAsLayout();


}
