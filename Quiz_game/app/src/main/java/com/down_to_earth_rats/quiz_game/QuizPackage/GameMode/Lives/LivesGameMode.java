package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Lives;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Carl Bergman
 */
public class LivesGameMode extends ViewModel {

    private MutableLiveData<Integer> lives = new MutableLiveData<>();
    private int nCorrect = 0;

    public LivesGameMode() {
        lives.setValue(3);
    }

    /* for the moment this method is unused, saving in case we want to enable setting lives later
    public void setLives(int data) {
        this.lives.setValue(data);
    }*/

    protected MutableLiveData<Integer> getLives() {
        return lives;
    }

    protected void answer(boolean correct) {
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
