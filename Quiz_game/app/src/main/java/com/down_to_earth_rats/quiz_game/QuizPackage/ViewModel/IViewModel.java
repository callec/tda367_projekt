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

    public boolean answerQuestion(int alternativeID);
    public void changeQuestion();
    public MutableLiveData<Boolean> getRunningState();
    public LiveData<List<String>> getAlternativeList();
    public int getTotalQuestions();
    public int getCorrectAnswers();

}
