package com.down_to_earth_rats.quiz_game;

import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static org.hamcrest.Matchers.not;

import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setup() {
        Intents.init();
    }

    @After
    public void end() {
        Intents.release();
    }

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
        Intents.intended(IntentMatchers.hasComponent(MainActivity.class.getName()));
    }

    // for the two tests below the best would be to test that the dialog is gone but there doesn't
    // seem to be a good way to test that
    @Test
    public void testModalPanelCont() {
        pressBack();
        onView(withText(R.string.dialog_cont))
                .perform(click());
        // check that any element of QuizActivity exists
        onView(withId(R.id.questionText))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testModalPanelRetry() {
        pressBack();
        onView(withText(R.string.dialog_retry))
                .perform(click());
        // check that any element of QuizActivity exists
        onView(withId(R.id.questionText))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testClickAlternative() {
        // confirm that the buttons change on click
        // default behaviour is that they either gets greyed out or marks correct or wrong
        onView(withId(R.id.answerButton1))
                .perform(click())
                .check(matches(not(hasBackground(R.drawable.round_button))));
        onView(withId(R.id.answerButton2))
                .check(matches(not(hasBackground(R.drawable.round_button))));
        onView(withId(R.id.answerButton3))
                .check(matches(not(hasBackground(R.drawable.round_button))));
        onView(withId(R.id.answerButton4))
                .check(matches(not(hasBackground(R.drawable.round_button))));
    }

    @Test
    public void testProgressBar() throws InterruptedException {
        CountingIdlingResource cir = new CountingIdlingResource("GLOBAL");
        onView(withId(R.id.answerButton1))
                .perform(click());
        onView(withId(R.id.progressBar))
                .check(matches(isDisplayed()));
        // not good to use thread.sleep!!!! should this test be included?
        Thread.sleep(3001);
        onView(withId(R.id.progressBar))
                .check(matches(not(isDisplayed())));
    }
}
