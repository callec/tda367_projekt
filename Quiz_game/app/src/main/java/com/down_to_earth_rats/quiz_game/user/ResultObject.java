package com.down_to_earth_rats.quiz_game.user;

import java.util.Date;

/**
 * Created by Louise Tranborg
 * Modified by Louise Tranborg, Erik Blomberg, Henrik Johansson, Sara Persson
 * <p>
 * This class represents a resultObject, which is created after every finished quiz.
 * It has an result from the quiz, ex. 7/10 correctanswers/totalQuestions.
 * It also contains a date from when the Quiz was played.
 * The resultObject is connected with the subcategory of the played Quiz.
 * Resultobjects will also be able to be storted by category, gamemode and hitused.
 */

public class ResultObject {

    private int totalQuestions;
    private int correctAnswers;
    private Date date;
    private String category;
    private String subcategory;
    private String gameMode;
    private boolean hintUsed;

    /**
     * Create a result object
     *
     * @param totalQuestions total amount of questions answered
     * @param correctAnswers total amount of correct answers given
     * @param category       category of quiz
     * @param subcategory    subcategory of quiz
     * @param gameMode       game mode of quiz played
     * @param hintUsed       if hints were used
     */
    public ResultObject(int totalQuestions, int correctAnswers, String category, String subcategory, String gameMode, boolean hintUsed) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.category = category;
        this.subcategory = subcategory;
        this.gameMode = gameMode;
        this.hintUsed = hintUsed;

        date = new Date();
    }

    /**
     * @return
     */
    public String getSubcategory() {
        return subcategory;
    }

    /**
     * @return total amount of correct answers
     */
    public int getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     * @return total amount of questions in quiz
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }

    /**
     * @return category of quiz saved in this result
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return game mode
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     * @return whether hints were used during quiz
     */
    public boolean isHintUsed() {
        return hintUsed;
    }

    /**
     * @return date when result object was created (when quiz was finished)
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return whether hints were used during quiz
     */
    public boolean usedHint() {
        return hintUsed;
    }

}
