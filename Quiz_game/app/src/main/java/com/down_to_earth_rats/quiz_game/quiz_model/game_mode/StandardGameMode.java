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

    public MutableLiveData<Integer> getCurrentq() {
        return currentq;
    }

    public void nextQuestion() {
        currentq.setValue(currentq.getValue() + 1);
    }

    public void reset() {
        currentq.setValue(0);
    }
}
