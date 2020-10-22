package com.down_to_earth_rats.quiz_game.gui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.down_to_earth_rats.quiz_game.gui.modal.IModalFragmentHandler;
import com.down_to_earth_rats.quiz_game.gui.modal.ModalFragment;
import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.quiz_model.IQuizModel;
import com.down_to_earth_rats.quiz_game.quiz_model.SimpleQuizModel;
import com.down_to_earth_rats.quiz_game.databinding.ActivityQuizBinding;
import com.down_to_earth_rats.quiz_game.quiz_model.game_mode.GameModeFactory;
import com.down_to_earth_rats.quiz_game.quiz_model.game_mode.IGameModeFragment;
import com.down_to_earth_rats.quiz_game.quiz_model.game_mode.IGameModeObserver;

import java.util.Arrays;
import java.util.List;

/**
 * Created and edited by Henrik, Sara, Carl, Erik, Louise
 * This activity represents displaying the quiz, it has one question and four alternatives.
 * It also has a game mode fragment which it uses depending on user selection.
 */
public class QuizActivity extends AppCompatActivity implements IModalFragmentHandler, IGameModeObserver {

    private ActivityQuizBinding viewBinding;

    private int timerTextId;
    private long msUntilNextQ;

    private IGameModeFragment gameMode;
    private boolean gameModeEnd;
    private ModalFragment modal;
    private IQuizModel model;

    private Resources res;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private Button alternative1;
    private Button alternative2;
    private Button alternative3;
    private Button alternative4;
    private CountDownTimer timeUntilNextQ;

    private String currentCategory;

    private final int maxHints = 2;
    private int hints = maxHints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        pref = this.getSharedPreferences(String.valueOf(R.string.preferences_name), MODE_PRIVATE);
        editor = pref.edit();

        pref = this.getSharedPreferences(getString(R.string.preferences_name), MODE_PRIVATE);

        model = new ViewModelProvider(this).get(SimpleQuizModel.class);
        model.setTotalQuestions(pref.getInt(getString(R.string.settings_totalq), res.getInteger(R.integer.totalq_defaultvalue)));

        currentCategory = pref.getString(CategoryActivity.CATEGORY_NAME, "Matematik");
        model.setCategoryAndSubCategory(currentCategory,
                pref.getString(CategoryActivity.SUBCATEGORY_NAME, "Subtraktion"));

        model.initQuiz();

        viewBinding = ActivityQuizBinding.inflate(getLayoutInflater());

        setContentView(viewBinding.getRoot());

        setupGameMode();
        setupSupportActionBar();
        setupOnQuizEnd();
        setupButtons();
        setupHints();
    }

    private void setupHints() {
        editor.putBoolean("hintsUsed", false);
        editor.apply();

        checkHintStatus();
    }

    private void checkHintStatus() {
        boolean hintOn_Status = pref.getBoolean("StatusOn", false);
        viewBinding.hintButton.setVisibility(hintOn_Status ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * Makes a wrong answer button greyed-out and disabled
     * @param view of the current View
     */
    public void giveHintQuiz(View view) {

        editor.putBoolean("hintsUsed", true);
        editor.apply();
        model.hintsUsedResults();

        int hintIndex = model.getHintIndex();
        List<Button> buttons = Arrays.asList(new Button[] {alternative1, alternative2, alternative3, alternative4});
        Button alternative = buttons.get(hintIndex);

        while (!alternative.isEnabled()) {
            hintIndex = model.getHintIndex();
            alternative = buttons.get(hintIndex);
        }

        alternative.setBackgroundResource(R.drawable.grey_button);
        alternative.setEnabled(false);

        hints--;
        if (hints < 1) {
            viewBinding.hintButton.setClickable(false);
        }
    }

    private void setupGameMode() {
        String selectedGameMode = pref.getString(getString(R.string.gamemode_which), getString(R.string.gamemode_standard));
        gameModeEnd = false;
        gameMode = loadGameMode(selectedGameMode);
        gameMode.addObserver(this);
        getSupportFragmentManager().beginTransaction()
                .add(viewBinding.fragmentContainer.getId(), (Fragment) gameMode).commit();
    }

    private IGameModeFragment loadGameMode(String selected) {
        // i would really like to use an enum here, but as we use SharedPreferences we would
        // have to convert string to enum anyways so we reduce that step by using this
        Bundle args = new Bundle();
        args.putInt(getString(R.string.gamemode_time_value), pref.getInt(getString(R.string.gamemode_time_value), 30));
        args.putInt(getString(R.string.settings_totalq), pref.getInt(getString(R.string.settings_totalq), 10));
        gameMode = GameModeFactory.getGameMode(selected);
        ((Fragment) gameMode).setArguments(args);
        return gameMode;
    }

    private void setupOnQuizEnd() {
        model.getRunningState().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean state) {
                if (!state) {
                    switchActivityToResult();
                }
            }
        });
    }

    private void setupTimerText() {
        timerTextId = R.string.nextq_in;

        model.getIsLast().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLastQuestion) {
                if (isLastQuestion) {
                    timerTextId = R.string.result_in;
                }
            }
        });
    }

    private void setupButtons() {
        alternative1 = viewBinding.answerButton1;
        alternative2 = viewBinding.answerButton2;
        alternative3 = viewBinding.answerButton3;
        alternative4 = viewBinding.answerButton4;

        model.getAlternativeList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                viewBinding.questionText.setText(strings.get(0));
                alternative1.setText(strings.get(1));
                alternative2.setText(strings.get(2));
                alternative3.setText(strings.get(3));
                alternative4.setText(strings.get(4));
            }
        });
    }

    private void setupSupportActionBar() {
        Toolbar toolbar = viewBinding.toolbarQuiz;
        toolbar.setTitle(currentCategory);

        setSupportActionBar(toolbar);
    }


    public void clickAlternative(View view) {

        int id = 1;
        switch (view.getId()) {
            case R.id.answerButton1:
                id = 1;
                break;
            case R.id.answerButton2:
                id = 2;
                break;
            case R.id.answerButton3:
                id = 3;
                break;
            case R.id.answerButton4:
                id = 4;
                break;
        }
        boolean response = model.answerQuestion(id);
        gameMode.answer(response);
        guess(response, view);
        countDown();
        //ft.detach(this).attach(gameMode).commit();
    }

    private void switchActivityToResult() {
        Intent intent = new Intent(this, ResultsActivity.class);

        intent.putExtra("Result", model.getCorrectAnswers());
        intent.putExtra("TotalQuestions", model.getTotalQuestions());

        startActivity(intent);
    }

    private void switchActivityToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Count down to next question
    private void countDown() {
        msUntilNextQ = 1500;
        viewBinding.progressBar.setVisibility(View.VISIBLE);
        viewBinding.hintButton.setVisibility(View.INVISIBLE);

        if (gameModeEnd && timeUntilNextQ != null) { // really really don't like this check but it is necessary for all
                           // gamemodes to function correctly
            timeUntilNextQ.cancel();
        }
        timeUntilNextQ = new CountDownTimer(msUntilNextQ, msUntilNextQ / 100) {

            @Override
            public void onTick(long l) {
                //viewBinding.questionText.setText(getString(timerTextId, ((l / 1000) + 1)));
                viewBinding.progressBar.incrementProgressBy(1);
            }



            @Override
            public void onFinish() {
                checkHintStatus();
                disableProgressBar();
                enableButtons(true, alternative1, alternative2, alternative3, alternative4);
                disableProgressBar();

                hints = maxHints;
                viewBinding.hintButton.setClickable(true);

                if (gameModeEnd) {
                    model.gameModeForceEnd();
                }

                gameMode.onNewQuestion();
                model.changeQuestion();
            }

        };
        timeUntilNextQ.start();
    }

    private void disableProgressBar() {
        viewBinding.progressBar.setVisibility(View.INVISIBLE);
        viewBinding.progressBar.setProgress(0);
    }

    private void enableButtons(boolean enable, Button... blist) {
        if (blist.length < 1) {
            throw new ArrayIndexOutOfBoundsException("No buttons in method call.");
        }
        for (Button b : blist) {
            b.setClickable(enable);
            if (!enable) {
                b.setBackgroundResource(R.drawable.grey_button);
            } else {
                b.setBackgroundResource(R.drawable.round_button);
                b.setEnabled(true);
            }
        }
    }

    private void guess(boolean guess, View v) {
        enableButtons(false, alternative1, alternative2, alternative3, alternative4);
        if (guess) {
            v.setBackgroundResource(R.drawable.correct_button);
        } else {
            v.setBackgroundResource(R.drawable.wrong_button);
            // TODO: find correct button and set correct_grey_button
        }
    }

    // Consume back press
    @Override
    public void onBackPressed() {
        gameMode.pause();
        modal = new ModalFragment(this.getResources().getString(R.string.quit_quiz_modal), this.getResources().getStringArray(R.array.quit_quiz_modal), this);
        modal.show(this.getSupportFragmentManager(), "s");
    }

    // Decide what to do depending on what button was pressed (called from modalFragment)
    @Override
    public void modalFragmentButtonPressed(int buttonIndex) {
        switch (buttonIndex) {
            // "Continue"
            case 0:
                gameMode.resume();
                break;
            // "Restart"
            case 1:
                //TODO this works for quiz of mathematical types where the questions are generated
                model.initQuiz();
                gameMode.reset();
                break;
            // "Quit"
            case 2:
                switchActivityToMenu();
        }
    }

    @Override
    public void gameModeQuizEnd() {
        gameModeEnd = true;
        if (timeUntilNextQ != null) {
            timeUntilNextQ.cancel();
        }
        enableButtons(false, alternative1, alternative2, alternative3, alternative4);
        disableProgressBar();
        countDown();
    }
}
