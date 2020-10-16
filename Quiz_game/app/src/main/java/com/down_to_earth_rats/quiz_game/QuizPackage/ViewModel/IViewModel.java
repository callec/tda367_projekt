package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * Created by Carl Bergman, Louise Tranborg
 * <p>
 * This interface defines the behaviour of ViewModel.
 */

public interface IViewModel {

    boolean answerQuestion(int alternativeID);
    void changeQuestion();
    MutableLiveData<Boolean> getRunningState();
    LiveData<List<String>> getAlternativeList();
    int getTotalQuestions();
    void setTotalQuestions(int i);
    int getCorrectAnswers();
    void initQuiz();
    MutableLiveData<Boolean> getIsLast();
    int getHintIndex();
    boolean checkIfCorrect(int alternativeID);
    void hintsUsedResults();
    boolean GetHintsUsed();
    void SetHintsUsed(boolean bool);

    void gameModeForceEnd();

}
