package com.down_to_earth_rats.quiz_game.UserPackage;


/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 *
 */

public abstract class LoginServiceFactory {

    public static ILoginService getStandardService(){
        return new SimpleLoginService();
    }

}
