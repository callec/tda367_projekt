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


/**
 * Created by Sara Persson
 * Modified by Carl Bergman
 */
public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding viewBinding;

    private Spinner gameModeSpinner;
    private SeekBar questionSeekBar;
    private TextView seekBarTextView;
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
                // possibly refactor this to it's on method so we it depends more on each GameMode
                if (!selectedGameMode.equals(getString(R.string.gamemode_standard))) {
                    questionSeekBar.setVisibility(View.GONE);
                    seekBarTextView.setVisibility(View.GONE);
                } else {
                    questionSeekBar.setVisibility(View.VISIBLE);
                    seekBarTextView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editor.putString(getString(R.string.gamemode_which), getString(R.string.gamemode_standard));
            }
        });
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
                editor.putInt("TotalQuestions", seekBar.getProgress());
            }
        });
    }

    @Override
    protected void onDestroy() {
        editor.apply();
        super.onDestroy();
    }
}
