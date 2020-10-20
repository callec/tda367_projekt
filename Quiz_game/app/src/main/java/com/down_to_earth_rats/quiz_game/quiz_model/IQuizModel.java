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

    boolean answerQuestion(int alternativeID);
    void changeQuestion();
    MutableLiveData<Boolean> getRunningState();
    LiveData<List<String>> getAlternativeList();
    int getTotalQuestions();
    void setTotalQuestions(int i);
    int getCorrectAnswers();
    void setCategoryAndSubCategory(String category, String subCategory);
    void initQuiz();
    MutableLiveData<Boolean> getIsLast();
    int getHintIndex();
    boolean checkIfCorrect(int alternativeID);
    void hintsUsedResults();
    boolean getHintsUsed();
    void setHintsUsed(boolean bool);

    void gameModeForceEnd();
}
