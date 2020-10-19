package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Lives;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Carl Bergman
 */
public class LivesGameModeTest {

    private LivesGameMode gm;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        gm = new LivesGameMode();
    }

    @Test
    public void testAnswer() {
        Integer startLives = gm.getLives().getValue();
        if (startLives == null) {
            fail();
        }

        gm.answer(false);
        assertNotEquals(startLives, gm.getLives().getValue());
    }

    @Test
    public void testBonusLife() {
        Integer startLives = gm.getLives().getValue();
        if (startLives == null) {
            fail();
        }

        gm.answer(false);
        for (int i=0; i<7; ++i) {
            gm.answer(true);
        }
        assertEquals(startLives, gm.getLives().getValue());
    }

    @Test
    public void testRest() {
        Integer startLives = gm.getLives().getValue();
        if (startLives == null) {
            fail();
        }

        gm.answer(false);
        Integer newLives = gm.getLives().getValue();
        if (newLives.equals(startLives)) {
            fail();
        }

        gm.reset();
        assertNotEquals(newLives, gm.getLives().getValue());
    }
}
