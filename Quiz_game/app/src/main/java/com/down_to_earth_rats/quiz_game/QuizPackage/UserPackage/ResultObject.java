package com.down_to_earth_rats.quiz_game.QuizPackage.UserPackage;

import java.util.Date;

/**
 * Created by Louise Tranborg
 *
 */

public class ResultObject {

    private int totalQuestions;
    private int correctAnswers;
    private Date date;
    private String subcategory;

    public ResultObject(int totalQuestions, int correctAnswers, String subcategory) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.date = date;
        this.subcategory = subcategory;
    }

    public String getSubcategory(){
        return subcategory;
    }

    public int getCorrectAnswers(){
        return correctAnswers;
    }

}
