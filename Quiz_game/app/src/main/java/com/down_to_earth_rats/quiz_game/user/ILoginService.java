package com.down_to_earth_rats.quiz_game.user;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 * <p>
 * Interface representing a login-service
 */

public interface ILoginService {

    /**
     * Create user
     *
     * @param username
     * @param password
     * @return whether registration was successful
     */
    boolean registerUser(String username, String password);

    /**
     * Login user
     *
     * @param username
     * @param password
     * @return whether login was successful
     */
    boolean loginUser(String username, String password);

}
