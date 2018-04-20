package me.clonalejandro.clonasister.utils;

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


public final class User {


    /** SMALL CONSTRUCTORS **/

    private String userName, password;

    public User(){
        setUserName("root");
        setPassword("1928");
    }


    /** REST **/

    /**
     * This function return a userName
     * @return
     */
    public String getUsername(){
        return userName;
    }


    /**
     * This function return a Password
     * @return
     */
    public String getPassword(){
        return password;
    }


    /** OTHERS **/

    /**
     * This function set UserName
     * @param userName
     */
    private void setUserName(String userName){
        this.userName = userName;
    }


    /**
     * This function set password
     * @param password
     */
    private void setPassword(String password){
        this.password = password;
    }


}
