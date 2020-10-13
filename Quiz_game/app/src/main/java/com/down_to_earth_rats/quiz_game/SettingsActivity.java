package com.down_to_earth_rats.quiz_game;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.down_to_earth_rats.quiz_game.databinding.ActivitySettingsBinding;

import org.w3c.dom.Text;

import java.util.Random;


/**
 * Created by Sara Persson
 * Modified by Carl Bergman
 */
public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding viewBinding;

    private Spinner gameModeSpinner;
    private SeekBar questionSeekBar;
    private TextView seekBarTextView;
    private SeekBar timeSeekBar;
    private TextView timeSeekBarValue;
    private Resources res;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivitySettingsBinding.inflate(getLayoutInflater());
        pref = this.getSharedPreferences(getString(R.string.preferences_name), MODE_PRIVATE);
        editor = pref.edit();

        res = getResources();

        setContentView(viewBinding.getRoot());

        setupToolBar();
        setupFontSize();
        setupQuestionSeekBar();
        setupTimeSeekBar();
        setupGameModeSpinner();
    }

    private void setupGameModeSpinner() {
        gameModeSpinner = viewBinding.GameModeSpinner;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gamemodes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gameModeSpinner.setAdapter(adapter);
        gameModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedGameMode = parent.getItemAtPosition(position).toString();
                editor.putString(getString(R.string.gamemode_which), selectedGameMode);
                editor.putInt(getString(R.string.gamemode_spinner_selected), position);
                // possibly refactor this to its own method so we it depends more on each GameMode

                hideSeekbar(questionSeekBar, seekBarTextView, true);
                hideSeekbar(timeSeekBar, timeSeekBarValue, true);
                Random r = new Random();
                if (selectedGameMode.equals(getString(R.string.gamemode_lives))) {
                    editor.putInt(getString(R.string.settings_totalq), r.nextInt(40) + 10);
                } else if (selectedGameMode.equals(getString(R.string.gamemode_time))) {
                    hideSeekbar(timeSeekBar, timeSeekBarValue, false);
                    editor.putInt(getString(R.string.settings_totalq), r.nextInt(40) + 10);
                } else {
                    editor.putInt(getString(R.string.settings_totalq), res.getInteger(R.integer.totalq_defaultvalue));
                    questionSeekBar.setProgress(res.getInteger(R.integer.totalq_defaultvalue));
                    hideSeekbar(questionSeekBar, seekBarTextView, false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editor.putString(getString(R.string.gamemode_which), getString(R.string.gamemode_standard));
            }
        });
        gameModeSpinner.setSelection(pref.getInt(getString(R.string.gamemode_spinner_selected), 0));
    }

    private void hideSeekbar(SeekBar sb, TextView tv, boolean b) {
        if (!b) {
            sb.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
        } else {
            sb.setVisibility(View.GONE);
            tv.setVisibility(View.GONE);
        }
    }

    private void setupToolBar() {
        Toolbar toolbar = viewBinding.toolbarSettings;
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        //Gives us the return to previous page /back arrow, in the top toolbar   (<-)
        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupFontSize() {
        // This is the code for the switch, when clicked it changes text.
        final Switch s = viewBinding.switch1; //(Switch) findViewById(R.id.switch1);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            String test = s.getText().toString();

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //Switch on
                    s.setText("Smaller text");
                } else {  //Switch off
                    s.setText(test);
                }
            }
        });
    }

    private void setupQuestionSeekBar() {
        questionSeekBar = viewBinding.nquestionsSeekBar;
        seekBarTextView = viewBinding.seekBarValue;

        final int minimumvalue = res.getInteger(R.integer.totalq_minvalue);

        int firstValue = pref.getInt(getString(R.string.settings_totalq), res.getInteger(R.integer.totalq_defaultvalue));
        questionSeekBar.setProgress(firstValue);
        seekBarTextView.setText(getString(R.string.settings_nquestions, firstValue));

        questionSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // need this if in case someone is running android api <26
                if (progress < minimumvalue) {
                    seekBar.setProgress(minimumvalue);
                }
                seekBarTextView.setText(getString(R.string.settings_nquestions, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor.putInt(getString(R.string.settings_totalq), seekBar.getProgress());
            }
        });
    }

    private void setupTimeSeekBar() {
        timeSeekBar = viewBinding.timeSeekBar;
        timeSeekBarValue = viewBinding.timeSeekBarValue;

        final int minimumvalue = res.getInteger(R.integer.time_minvalue);

        int firstValue = pref.getInt(getString(R.string.gamemode_time_value), res.getInteger(R.integer.time_defaultvalue));
        timeSeekBar.setProgress(firstValue);
        timeSeekBarValue.setText(getString(R.string.settings_ntime, firstValue));

        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < minimumvalue) {
                    seekBar.setProgress(minimumvalue);
                }
                timeSeekBarValue.setText(getString(R.string.settings_ntime, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor.putInt(getString(R.string.gamemode_time_value), seekBar.getProgress());
            }
        });
    }

    @Override
    protected void onDestroy() {
        editor.apply();
        super.onDestroy();
    }
}
