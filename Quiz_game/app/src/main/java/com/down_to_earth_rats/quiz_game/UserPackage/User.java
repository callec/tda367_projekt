package com.down_to_earth_rats.quiz_game.UserPackage;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ImmutableCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louise Tranborg
 * Modified by Louise Tranborg, Erik Blomberg, Henrik Johansson
 *
 * This class represents an simple user.
 * It contains a username, password and also its statistics.
 *
 *
 */

class User implements IUser{

    private ArrayList<ResultObject> statistics = new ArrayList<>();
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**Method used to get a statistics based on subcategory.
     */
    @Override
    public List<ResultObject> getStatistics(){  //TODO Return all statistics, not based on subcategory anymore
        return new ArrayList<>(statistics);
    }

    /**Method used to add a ResultObject in the list of statistics.
    */
    @Override
    public void addResult(ResultObject resultObject){
        statistics.add(resultObject);
    }

    @Override
    public boolean checkCredentials(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public ICategory getUserCategory() {
        if(username.equals("Lisa")){ //Temporary solution.
            return new ImmutableCategory(username, "Matteprov");
        } else{
            return new ImmutableCategory(username);
        }

    }
}
