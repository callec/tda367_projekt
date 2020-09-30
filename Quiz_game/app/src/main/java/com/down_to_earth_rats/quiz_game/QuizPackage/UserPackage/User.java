package com.down_to_earth_rats.quiz_game.QuizPackage.UserPackage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Louise Tranborg
 *
 */

public class User{

    private HashMap<String, ArrayList<ResultObject>> statistics;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        statistics = new HashMap<>();
        //statistics.put("Addition",)

    }

    public HashMap<String, ArrayList<ResultObject>> getStatistics(){
        return statistics;
    }

    /*
    private void addStatistics(Integer date, String result){
        statistics.put(date, result);
    }

     */
}
