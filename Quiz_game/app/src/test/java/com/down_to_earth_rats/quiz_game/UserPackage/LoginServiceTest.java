package com.down_to_earth_rats.quiz_game.UserPackage;

import junit.framework.TestCase;

public class LoginServiceTest extends TestCase {

    String fakeUsername = "dasdasd";
    String fakePassword = "hejhallå123";

    String correctUsername = "Lisa";
    String correctPassword = "12345";

    public void testIncorrectLoginUser() {
        ConcreteLoginService loginService = new ConcreteLoginService();

        assertFalse(loginService.loginUser(fakeUsername, fakePassword));
    }

    public void testCorrectLoginUser() {
        ConcreteLoginService loginService = new ConcreteLoginService();

        assertTrue(loginService.loginUser(correctUsername, correctPassword));
    }
}