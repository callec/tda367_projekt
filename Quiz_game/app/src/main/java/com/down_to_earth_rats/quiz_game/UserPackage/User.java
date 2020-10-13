package com.down_to_earth_rats.quiz_game.UserPackage;

import java.util.ArrayList;

/**
 * Created by Louise Tranborg
 * This class represents an simple user.
 * It contains a username, password and also its statistics.
 * At the moment Singelton-pattern is used to access the User.
 *
 */

public class User{

    private static User singletonUser = null;
    private ArrayList<ResultObject> statistics = new ArrayList<>();
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User getInstance(){
        if(singletonUser == null){
            singletonUser = new User("Namn", "123");
        } return singletonUser;
    }

    /**Method used to get a statistics based on subcategory.
     */
    public ArrayList<ResultObject> getStatistics(String subcategory){
        ArrayList<ResultObject> statisticsInSubcategory = new ArrayList<>();
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

}
