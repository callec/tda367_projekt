package com.down_to_earth_rats.quiz_game.UserPackage;

import junit.framework.TestCase;

public class LoginServiceTest extends TestCase {

    String fakeUsername = "dasdasd";
    String fakePassword = "hejhallå123";

    String correctUsername = "Lisa";
    String correctPassword = "12345";

    ILoginService loginService;

    @Override
    public void setUp() throws Exception {
        loginService = new ConcreteLoginService();
    }

    public void testIncorrectLoginUser() {

        assertFalse(loginService.loginUser(fakeUsername, fakePassword));
    }

    public void testCorrectLoginUser() {

        assertTrue(loginService.loginUser(correctUsername, correctPassword));
    }

    public void testIfUserSingletonIsSetToCorrectUserAfterLogin(){

        loginService.loginUser(correctUsername, correctPassword);

        assertTrue(UserSingleton.getUser().checkCredentials(correctUsername, correctPassword));

    }
}