package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

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

    /**
     * @return MutableLiveData<Integer> observable value of number of question
     */
    public MutableLiveData<Integer> getCurrentq() {
        return currentq;
    }

    /**
     * Increments currentq variable.
     */
    public void nextQuestion() {
        currentq.setValue(currentq.getValue() + 1);
    }

    /**
     * Reset gamemode.
     */
    public void reset() {
        currentq.setValue(0);
    }
}
