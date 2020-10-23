package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.down_to_earth_rats.quiz_game.quiz_model.game_mode.StandardGameMode;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Carl Bergman
 */
public class StandardGameModeTest {

    private StandardGameMode gm;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        gm = new StandardGameMode();
    }

    @Test
    public void testAnswer() {
        Integer prev = gm.getCurrentq().getValue();
        gm.nextQuestion();
        assertNotEquals(prev, gm.getCurrentq().getValue());
    }

    @Test
    public void testReset() {
        Integer prev = gm.getCurrentq().getValue();
        if (prev == null) {
            fail();
        }

        gm.nextQuestion();
        Integer newq = gm.getCurrentq().getValue();
        if (prev.equals(newq)) {
            fail();
        }

        gm.reset();
        assertNotEquals(newq, gm.getCurrentq().getValue());
    }
}
