package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Standard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Carl Bergman
 * Holds and handles data for StandardGameModeFragment to display.
 */
public class StandardGameMode extends ViewModel {

    private MutableLiveData<Integer> currentq = new MutableLiveData<>();

    public StandardGameMode() {
        currentq.setValue(0);
    }

    protected MutableLiveData<Integer> getCurrentq() {
        return currentq;
    }

    protected void nextQuestion() {
        currentq.setValue(currentq.getValue() + 1);
    }

    protected void reset() {
        currentq.setValue(0);
    }
}
