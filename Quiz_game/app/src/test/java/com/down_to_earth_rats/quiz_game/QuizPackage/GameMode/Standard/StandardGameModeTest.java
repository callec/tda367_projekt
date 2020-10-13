package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Standard;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

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
        gm.answer();
        assertNotEquals(prev, gm.getCurrentq().getValue());
    }
}
