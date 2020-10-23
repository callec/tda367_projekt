package com.down_to_earth_rats.quiz_game.user;

import com.down_to_earth_rats.quiz_game.category.ICategory;

import java.util.List;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 * <p>
 * Interface representing a User
 */
public interface IUser {

    /**
     * @return list of User's Result objects
     */
    List<ResultObject> getStatistics();

    /**
     * Add Result to User statistics list
     *
     * @param resultObject Result to add
     */
    void addResult(ResultObject resultObject);

    /**
     * @param username
     * @param password
     * @return whether arguments received matches stored username and password for user
     */
    boolean checkCredentials(String username, String password);

    /**
     * @return User's username
     */
    String getUsername();

    /**
     * @return ICategory object containing User's username and subcategories
     */
    ICategory getUserCategory();


}
