package com.down_to_earth_rats.quiz_game;

import android.content.Context;
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
    private Switch hintSwitch;

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
        setupHint();
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
                editor.putInt(getString(R.string.gamemode_spinner_selected), position);
                saveGameMode(selectedGameMode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editor.putString(getString(R.string.gamemode_which), getString(R.string.gamemode_standard));
            }
        });
        int index = pref.getInt(getString(R.string.gamemode_spinner_selected), 0);
        if (index > (res.getStringArray(R.array.gamemodes).length) - 1) {
            // required check for very rare bug that only appears when testing,
            // SharedPreferences can save an index that is larger than the actual array.
            index = 0;
        }
        gameModeSpinner.setSelection(index);
    }

    private void saveGameMode(String selectedGameMode) {
        editor.putString(getString(R.string.gamemode_which), selectedGameMode);

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

    private void setupHint() {
        hintSwitch = viewBinding.switch1; //(Switch) findViewById(R.id.switch1);

        final String hintOff = "hint av";    //hintSwitch.getText().toString()
        final String hintOn = "hint på";

        boolean hintOn_Status = pref.getBoolean("StatusOn", false);
        hintSwitch.setChecked(hintOn_Status);
        if (hintOn_Status) {
            hintSwitch.setText(hintOn);
        }
        else {
            hintSwitch.setText(hintOff);
        }

        hintSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //Switch on
                    hintSwitch.setText(hintOn);
                    editor.putBoolean("StatusOn", hintSwitch.isChecked());
                    editor.commit();
                } else {  //Switch off
                    hintSwitch.setText(hintOff);
                    editor.putBoolean("StatusOn", hintSwitch.isChecked());
                    editor.commit();
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
