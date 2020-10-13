package com.down_to_earth_rats.quiz_game.UserPackage;

import junit.framework.TestCase;

public class UserSingletonTest extends TestCase {

    String username = "test";
    String password = "testpassword";

    User testUser = new User(username, password);

    public void testGetUserException() {

        assertNotNull(UserSingleton.getUser());

    }

    public void testSetUser() {

        UserSingleton.setUser(testUser);

        assertTrue(UserSingleton.getUser().checkCredentials(username, password));

    }
}