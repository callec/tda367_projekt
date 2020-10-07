package com.down_to_earth_rats.quiz_game.QuizPackage.gamemode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class InfGameMode extends ViewModel implements IGameMode {

    private MutableLiveData<Boolean> quizRunning = new MutableLiveData<>();
    private MutableLiveData<Integer> lives = new MutableLiveData<>();
    private int nCorrect = 0;

    public InfGameMode() {
        quizRunning.setValue(true);
    }

    @Override
    public void setData(List<? extends Number> data) {
        // in this gamemode we only use the 1 data
        this.lives.setValue(data.get(0).intValue());
    }

    @Override
    public List<? extends Number> getData() {
        List<Integer> l = new ArrayList<>();
        l.add(lives.getValue());
        return l;
    }

    @Override
    public MutableLiveData<Boolean> getQuizRunning() {
        return quizRunning;
    }

    @Override
    public void answer(boolean correct) {
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
