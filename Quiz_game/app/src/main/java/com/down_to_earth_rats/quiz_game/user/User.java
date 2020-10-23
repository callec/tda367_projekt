package com.down_to_earth_rats.quiz_game.user;

import com.down_to_earth_rats.quiz_game.category.ICategory;
import com.down_to_earth_rats.quiz_game.category.ImmutableCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louise Tranborg
 * Modified by Louise Tranborg, Erik Blomberg, Henrik Johansson
 * <p>
 * This class represents an simple user.
 * It contains a username, password and also its statistics.
 */

class User implements IUser {

    private final ArrayList<ResultObject> statistics = new ArrayList<>();
    private final String username;
    private final String password;

    /**
     * Create User with username and password
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public List<ResultObject> getStatistics() {
        return new ArrayList<>(statistics);
    }

    @Override
    public void addResult(ResultObject resultObject) {
        statistics.add(resultObject);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public ICategory getUserCategory() {

        //Creates a subcategory/quiz for Lisa, our hard coded user.
        if (username.equals("Lisa")) {
            return new ImmutableCategory(username, "Matteprov");
        } else {
            return new ImmutableCategory(username);
        }

    }
}
