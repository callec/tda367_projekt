package com.down_to_earth_rats.quiz_game.QuizPackage.UserPackage;

import java.util.ArrayList;

/**
 * Created by Louise Tranborg
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

    public ArrayList<ResultObject> getStatistics(String subcategory){
        ArrayList<ResultObject> statisticsInSubcategory = new ArrayList<>();
        for(ResultObject resultObject: statistics){
            if(resultObject.getSubcategory().equals(subcategory)){
                statisticsInSubcategory.add(resultObject);
            }
        }
        return statisticsInSubcategory;
    }

    public void addResult(ResultObject resultObject){
        statistics.add(resultObject);
    }

}
