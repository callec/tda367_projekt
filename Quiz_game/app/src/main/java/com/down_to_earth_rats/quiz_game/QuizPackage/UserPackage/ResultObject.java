package com.down_to_earth_rats.quiz_game.QuizPackage.UserPackage;

import com.down_to_earth_rats.quiz_game.Subcategory;

import java.util.Date;

/**
 * Created by Louise Tranborg
 *
 */

public class ResultObject {

    private int totalQuestions;
    private int correctAnswers;
    private Date date;
    private Subcategory subcategory;

    public ResultObject(int totalQuestions, int correctAnswers, Date date, Subcategory subcategory) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.date = date;
        this.subcategory = subcategory;
    }

    public Subcategory getSubcategory(){
        return subcategory;
    }


}
