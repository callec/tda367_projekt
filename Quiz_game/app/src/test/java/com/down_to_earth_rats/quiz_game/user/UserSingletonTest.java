package com.down_to_earth_rats.quiz_game.user;

import junit.framework.TestCase;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 *
 */

public class UserSingletonTest extends TestCase {

    String username = "test";
    String password = "testpassword";

    IUser testUser = new User(username, password);

    /* TODO, passes when run alone, but fails if LoginServiceTest also runs
    public void testGetUserException() {
        assertTrue(UserSingleton.getUser().checkCredentials("Guest", "123"));
    }
     */

    public void testSetUser() {

        UserSingleton.setUser(testUser);

        assertTrue(UserSingleton.getUser().checkCredentials(username, password));

    }
}