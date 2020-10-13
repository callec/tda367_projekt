package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Standard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Carl Bergman
 */
public class StandardGameMode extends ViewModel {

    private MutableLiveData<Integer> currentq = new MutableLiveData<>();

    public StandardGameMode() {
        currentq.setValue(0);
    }

    protected MutableLiveData<Integer> getCurrentq() {
        return currentq;
    }

    protected void answer() {
        currentq.setValue(currentq.getValue() + 1);
    }
}
