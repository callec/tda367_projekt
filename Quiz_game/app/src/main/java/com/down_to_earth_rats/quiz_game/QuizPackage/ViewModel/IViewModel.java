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

    public boolean answerQuestion(int alternativeID);
    public void changeQuestion();
    public MutableLiveData<Boolean> getRunningState();
    public LiveData<List<String>> getAlternativeList();
    public int getTotalQuestions();
    public int getCorrectAnswers();
    MutableLiveData<Boolean> getIsLast();

}
