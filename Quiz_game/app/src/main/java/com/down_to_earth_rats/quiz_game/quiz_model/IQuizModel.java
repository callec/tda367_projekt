package com.down_to_earth_rats.quiz_game.quiz_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * Created by Carl Bergman, Louise Tranborg
 * <p>
 * This interface defines the behaviour of ViewModel.
 */

public interface IQuizModel {

    /**
     * Check if selected alternative is correct
     *
     * @param alternativeID ID of selected alternative
     * @return true if correct, false if incorrect
     */
    boolean answerQuestion(int alternativeID);

    /**
     * Progresses the quiz to the next question
     */
    void changeQuestion();

    /**
     * @return current runningState
     */
    MutableLiveData<Boolean> getRunningState();

    /**
     * @return list of alternatives from current question
     */
    LiveData<List<String>> getAlternativeList();

    /**
     * @return amount of questions in quiz
     */
    int getTotalQuestions();

    /**
     * Set for the amount of questions
     *
     * @param i amount of questions
     */
    void setTotalQuestions(int i);

    /**
     * @return amount of correct answers during the quiz
     */
    int getCorrectAnswers();

    /**
     * Set the current quiz's category and subcategory
     *
     * @param category
     * @param subCategory
     */
    void setCategoryAndSubCategory(String category, String subCategory);

    /**
     * Initializes quiz (setCategoryAndSubCategory must be set before)
     */
    void initQuiz();

    /**
     * @return whether current question is the last in quiz
     */
    MutableLiveData<Boolean> getIsLast();

    /**
     * @return index of random incorrect alternative
     */
    int getHintIndex();

    /**
     * @param alternativeID ID of alternative
     * @return if alternative is correct
     */
    boolean checkIfCorrect(int alternativeID);

    /**
     * Sets hints used, so it can be added to the result
     */
    void hintsUsedResults();

    /**
     * @return whether hints has been used
     */
    boolean getHintsUsed();

    /**
     * Force quiz to end
     */
    void gameModeForceEnd();
}
