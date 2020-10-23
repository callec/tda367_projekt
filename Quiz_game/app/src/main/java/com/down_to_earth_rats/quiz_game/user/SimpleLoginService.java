package com.down_to_earth_rats.quiz_game.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 */

class SimpleLoginService implements ILoginService {

    private List<IUser> userList = new ArrayList<>();

    /**
     * Create a simple login service (currently adds an hard coded user)
     */
    public SimpleLoginService() {

        //Create a hard coded user with a result.
        IUser user = new User("Lisa", "12345");
        userList.add(user);
        user.addResult(new ResultObject(5, 2, "Matematik",
                "Addition", "Standard", false));
    }

    @Override
    public boolean registerUser(String username, String password) {

        for (IUser user : userList) {
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

        for (IUser user : userList) {
            if (user.checkCredentials(username, password)) {
                condition = true;
                UserSingleton.setUser(user);
                break;
            }
        }

        return condition;
    }


}
