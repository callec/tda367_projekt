package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 * This interface defines the behaviour of ViewModel.
 */
import java.util.List;

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

}
