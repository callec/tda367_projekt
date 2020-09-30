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

    public ResultObject(int totalQuestions, int correctAnswers, Date date) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.date = date;
    }


}
