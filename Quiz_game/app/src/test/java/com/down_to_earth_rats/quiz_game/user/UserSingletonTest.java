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

    public void testSetUser() {

        UserSingleton.setUser(testUser);

        assertTrue(UserSingleton.getUser().checkCredentials(username, password));

    }
}