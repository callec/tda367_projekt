package com.down_to_earth_rats.quiz_game.UserPackage;

import java.util.ArrayList;
import java.util.List;

public class ConcreteLoginService implements ILoginService {


    User user = new User("Lisa", "12345");

    List<User> userList = new ArrayList<>();

    @Override
    public boolean registerUser(String username, String password) {
        return false;
    }

    @Override
    public boolean loginUser(String username, String password) {

        boolean condition = user.checkCredentials(username, password);

        //TODO
        UserSingleton.setUser(user);

        return condition;
    }


}
