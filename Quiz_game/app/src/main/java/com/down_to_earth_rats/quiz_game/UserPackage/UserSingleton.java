package com.down_to_earth_rats.quiz_game.UserPackage;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 *
 */

public class UserSingleton {

    static private IUser instance = null;

    static public IUser getUser() /*throws NullPointerException */{

        if (instance == null){
            instance = new User("Guest", "123");
            //TODO?
            /*throw new NullPointerException();*/
        }

        return instance;
    }

    static void setUser(IUser user){
        instance = user;
    }

}