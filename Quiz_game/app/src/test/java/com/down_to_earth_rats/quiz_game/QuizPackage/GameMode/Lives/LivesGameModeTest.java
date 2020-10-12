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
        for (int i=0; i<=5; ++i) {
            gm.answer(true);
        }
        assertEquals(startLives, gm.getLives().getValue());
    }

    /*@Test // for 100 % coverage
    public void testSetLives() {
        Integer startLives = gm.getLives().getValue();
        if (startLives == null) {
            fail();
        }

        gm.setLives(500);
        assertNotEquals(startLives, gm.getLives().getValue());
    }*/
}
