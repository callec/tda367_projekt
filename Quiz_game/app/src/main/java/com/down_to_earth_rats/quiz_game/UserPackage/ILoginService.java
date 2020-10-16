package com.down_to_earth_rats.quiz_game.UserPackage;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 *
 */

public interface ILoginService {

    boolean registerUser(String username, String password);

    boolean loginUser(String username, String password);

}
