package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 * This interface defines the behaviour of ViewModel.
 */
import java.util.List;

public abstract class ViewModel extends androidx.lifecycle.ViewModel {

    abstract public boolean answerQuestion(int alternativeID);
    abstract public void changeQuestion();
    abstract public MutableLiveData<Boolean> getRunningState();
    abstract public LiveData<List<String>> getAlternativeList();
    abstract public int getTotalQuestions();
    abstract public int getCorrectAnswers();
    abstract public MutableLiveData<Boolean> getIsLast();

}
