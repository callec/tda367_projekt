package com.down_to_earth_rats.quiz_game.UserPackage;

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

public class User{

    /*private static User singletonUser = null;*/
    private ArrayList<ResultObject> statistics = new ArrayList<>();
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*public static User getInstance(){
        if(singletonUser == null){
            singletonUser = new User("Namn", "123");
        } return singletonUser;
    }*/

    /**Method used to get a statistics based on subcategory.
     */
    public List<ResultObject> getStatistics(String subcategory){  //TODO Return all statistics, not based on subcategory anymore
        List<ResultObject> statisticsInSubcategory = new ArrayList<>();
        for(ResultObject resultObject: statistics){
            if(resultObject.getSubcategory().equals(subcategory)){
                statisticsInSubcategory.add(resultObject);
            }
        }
        return statisticsInSubcategory;
    }

    /**Method used to add a ResultObject in the list of statistics.
    */
    public void addResult(ResultObject resultObject){
        statistics.add(resultObject);
    }

    boolean checkCredentials(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }
}
