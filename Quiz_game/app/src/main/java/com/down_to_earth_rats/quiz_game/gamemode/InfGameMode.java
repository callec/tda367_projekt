package com.down_to_earth_rats.quiz_game.gamemode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfGameMode extends ViewModel {

    private MutableLiveData<Integer> lives = new MutableLiveData<>();
    private int nCorrect = 0;

    public InfGameMode() {
        lives.setValue(3);
    }

    public void setLives(int data) {
        this.lives.setValue(data);
    }

    public MutableLiveData<Integer> getLives() {
        return lives;
    }

    public void answer(boolean correct) {
        System.out.println("AAAAAAAAAAA");
        if (!correct) {
            lives.setValue(lives.getValue() - 1);
        } else {
            if (++nCorrect == 5 && lives.getValue() != 3) {
                lives.setValue(lives.getValue() + 1);
                nCorrect = 0;
            }
        }
    }
}
