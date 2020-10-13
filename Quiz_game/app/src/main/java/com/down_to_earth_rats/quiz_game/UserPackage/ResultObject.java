package com.down_to_earth_rats.quiz_game.UserPackage;

import java.util.Date;

/**
 * Created by Louise Tranborg
 * This class represents a resultObject, which is created after every finished quiz.
 * It has an result from the quiz, ex. 7/10 correctanswers/totalQuestions.
 * It also contains a date from when the Quiz was played.
 * The resultObject is connected with the subcategory of the played Quiz.
 *
 */

public class ResultObject {

    private int totalQuestions;
    private int correctAnswers;
    private Date date;
    private String subcategory;
    private boolean usedHint;

    public ResultObject(int totalQuestions, int correctAnswers, String subcategory, boolean usedHint) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.subcategory = subcategory;
        this.usedHint = usedHint;

        date = new Date();
    }

    public String getSubcategory(){
        return subcategory;
    }

    public int getCorrectAnswers(){
        return correctAnswers;
    }

    public int getTotalQuestions() { return  totalQuestions; }

    public Date getDate(){
        return date;
    }

    public boolean usedHint(){
        return usedHint;
    }

}
