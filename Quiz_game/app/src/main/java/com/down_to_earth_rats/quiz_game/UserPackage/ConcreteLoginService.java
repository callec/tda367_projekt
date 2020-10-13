package com.down_to_earth_rats.quiz_game.UserPackage;

public class ConcreteLoginService implements ILoginService {


    User user = new User("Lisa", "12345");

    @Override
    public boolean loginUser(String username, String password) {

        boolean condition = user.checkCredentials(username, password);

        //TODO

        return condition;
    }


}
