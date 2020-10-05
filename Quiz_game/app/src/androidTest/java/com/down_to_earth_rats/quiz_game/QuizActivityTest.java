package com.down_to_earth_rats.quiz_game;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.lifecycle.Lifecycle.State.DESTROYED;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Carl Bergman
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class QuizActivityTest {

    @Rule
    public ActivityScenarioRule<QuizActivity> activityRule = new ActivityScenarioRule<>(QuizActivity.class);

    @Test
    public void testModalPanel() {
        // test the existence of a modal panel on back press
        pressBack();
        onView(withText(R.string.dialog_cont))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
        onView(withText(R.string.dialog_retry))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
        onView(withText(R.string.dialog_quit))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testModalPanelQuit() {

        pressBack();
        onView(withText(R.string.dialog_quit))
                .perform(click());
        // part above works but how to test if it is on main screen?
    }
}
