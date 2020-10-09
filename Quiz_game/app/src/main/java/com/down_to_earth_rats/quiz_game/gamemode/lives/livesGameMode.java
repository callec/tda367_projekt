package com.down_to_earth_rats.quiz_game.gamemode.lives;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Carl Bergman
 */
public class livesGameMode extends ViewModel {

    private MutableLiveData<Integer> lives = new MutableLiveData<>();
    private int nCorrect = 0;

    public livesGameMode() {
        lives.setValue(3);
    }

    public void setLives(int data) {
        this.lives.setValue(data);
    }

    public MutableLiveData<Integer> getLives() {
        return lives;
    }

    public void answer(boolean correct) {
        if (!correct) {
            lives.setValue(lives.getValue() - 1);
            nCorrect = 0; // need 5 correct in a row
        } else {
            if (++nCorrect == 5 && lives.getValue() != 3) {
                lives.setValue(lives.getValue() + 1);
                nCorrect = 0;
            }
        }
    }
}
