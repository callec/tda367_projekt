package com.down_to_earth_rats.quiz_game.user;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 */

public class UserSingleton {

    static private IUser instance = null;

    private UserSingleton() {
    }

    /**
     * @return currect User
     */
    static public IUser getUser() /*throws NullPointerException */ {

        if (instance == null) {
            instance = new User("Guest", "123");
            //TODO?
            /*throw new NullPointerException();*/
        }

        return instance;
    }

    /**
     * @param user User to set as current active user
     */
    static void setUser(IUser user) {
        instance = user;
    }

}
