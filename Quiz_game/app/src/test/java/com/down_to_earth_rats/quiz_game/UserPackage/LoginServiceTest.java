package com.down_to_earth_rats.quiz_game.UserPackage;

import junit.framework.TestCase;

public class LoginServiceTest extends TestCase {

    String fakeUsername = "dasdasd";
    String fakePassword = "hejhallå123";

    String username = "Lisa";
    String password = "12345";

    ILoginService loginService;

    @Override
    public void setUp() throws Exception {
        loginService = new ConcreteLoginService();
    }

    public void testIncorrectLoginUser() {

        assertFalse(loginService.loginUser(fakeUsername, fakePassword));
    }

    /*public void testCorrectLoginUser() {

        assertTrue(loginService.loginUser(correctUsername, correctPassword));
    }

    public void testIfUserSingletonIsSetToCorrectUserAfterLogin(){

        loginService.loginUser(correctUsername, correctPassword);

        assertTrue(UserSingleton.getUser().checkCredentials(correctUsername, correctPassword));
    }*/


    public void testRegisterUser(){

        assertTrue(loginService.registerUser("test", "lösen"));

    }

    public void testRegisterSameUsername(){

        String username = "användarnamn";

        loginService.registerUser(username, "lösen");

        assertFalse(loginService.registerUser(username, "123"));

    }

    public void testRegisterAndLogin(){

        loginService.registerUser(username, password);

        loginService.loginUser(username, password);

        assertTrue(UserSingleton.getUser().checkCredentials(username, password));

    }




}