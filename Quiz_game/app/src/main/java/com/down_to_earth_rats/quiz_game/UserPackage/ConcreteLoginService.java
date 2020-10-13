package com.down_to_earth_rats.quiz_game.UserPackage;

import java.util.ArrayList;
import java.util.List;

public class ConcreteLoginService implements ILoginService {


    //User user = new User("Lisa", "12345");

    List<User> userList = new ArrayList<>();

    @Override
    public boolean registerUser(String username, String password) {

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return false; //username already taken
            }
        }

        userList.add(new User(username, password));

        return true;
    }

    @Override
    public boolean loginUser(String username, String password) {

        boolean condition = false;

        for (User user : userList) {
            if (user.checkCredentials(username, password)){
                condition = true;
                UserSingleton.setUser(user);
                break;
            }
        }

        return condition;
    }


}
