package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.core.widget.TextViewCompat;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Carl Bergman
 */
public class TimeGameModeTest {

    private TimeGameMode gm;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        gm = new TimeGameMode();
    }

    @Test
    public void testInit() {
        gm.init(3);
        assertTrue(gm.getMaxTime() != 0);
        assertTrue(gm.getTimeLeft() != 0);
        assertTrue(gm.getCountDownInterval() != 0);
    }

    @Test
    public void setTimeLeft() {
        gm.init(3);
        long prev = gm.getTimeLeft();

        gm.setTimeLeft(200);
        assertNotEquals(prev, gm.getTimeLeft());
    }

    @Test
    public void testQuizRunning() {
        Boolean prev = gm.getQuizRunning().getValue();
        if (prev == null) {
            fail();
        }

        gm.setTimeLeft(0);
        assertNotEquals(prev, gm.getQuizRunning().getValue());
    }
}
