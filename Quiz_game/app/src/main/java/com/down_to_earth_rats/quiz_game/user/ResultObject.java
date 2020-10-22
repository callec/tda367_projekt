package com.down_to_earth_rats.quiz_game.user;

import java.util.Date;

/**
 * Created by Louise Tranborg
 * Modified by Louise Tranborg, Erik Blomberg, Henrik Johansson, Sara Persson
 *
 * This class represents a resultObject, which is created after every finished quiz.
 * It has an result from the quiz, ex. 7/10 correctanswers/totalQuestions.
 * It also contains a date from when the Quiz was played.
 * The resultObject is connected with the subcategory of the played Quiz.
 * TODO: Add category, gamemode and hints (on/off) to a resultobject. This makes it possible to sort the objects based on them.
 */

public class ResultObject {

    private int totalQuestions;
    private int correctAnswers;
    private Date date;
    private String category;
    private String subcategory;
    private String gameMode;
    private boolean hintUsed;

    public ResultObject(int totalQuestions, int correctAnswers, String category, String subcategory, String gameMode, boolean hintUsed ) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.category = category;
        this.subcategory = subcategory;
        this.gameMode = gameMode;
        this.hintUsed = hintUsed;

        date = new Date();
    }

    public String getSubcategory(){
        return subcategory;
    }

    public int getCorrectAnswers(){
        return correctAnswers;
    }

    public int getTotalQuestions() { return  totalQuestions; }

    public String getCategory() {
        return category;
    }

    public String getGameMode() {
        return gameMode;
    }

    public boolean isHintUsed() {
        return hintUsed;
    }

    public Date getDate(){
        return date;
    }

    public boolean usedHint(){
        return hintUsed;
    }

}
