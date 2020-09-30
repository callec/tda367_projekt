package com.down_to_earth_rats.quiz_game.QuizPackage.UserPackage;

import com.down_to_earth_rats.quiz_game.Subcategory;

import java.util.ArrayList;

/**
 * Created by Louise Tranborg
 *
 */

public class User{

    private ArrayList<ResultObject> statistics;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public ArrayList<ResultObject> getStatistics(Subcategory subcategory){
        ArrayList<ResultObject> statisticsInSubcategory = new ArrayList<>();
        for(ResultObject resultObject: statistics){
            if(resultObject.getSubcategory() == subcategory){
                statisticsInSubcategory.add(resultObject);
            }
        }
        return statisticsInSubcategory;
    }

    private void addResult(ResultObject resultObject){
        statistics.add(resultObject);
    }

}
