package com.down_to_earth_rats.quiz_game.UserPackage;

public interface ILoginService {

    boolean registerUser(String username, String password);

    boolean loginUser(String username, String password);

}
