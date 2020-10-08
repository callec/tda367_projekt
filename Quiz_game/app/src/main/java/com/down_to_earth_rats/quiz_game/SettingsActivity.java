package com.down_to_earth_rats.quiz_game;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
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

    private SeekBar questionSeekBar;
    private TextView seekBarTextView;
    private Resources res;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivitySettingsBinding.inflate(getLayoutInflater());
        pref = this.getSharedPreferences(String.valueOf(R.string.preferences_name), MODE_PRIVATE);
        editor = pref.edit();

        res = getResources();

        setContentView(viewBinding.getRoot());

        setupToolBar();
        setupHint();
        setupQuestionSeekBar();
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
        // This is the code for the switch, when clicked it changes its text.
        final Switch s = viewBinding.switch1; //(Switch) findViewById(R.id.switch1);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            String hintOn = s.getText().toString();
            String hintOff = s.getText().toString();

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //Switch on
                    s.setText(hintOn);
                } else {  //Switch off
                    s.setText(hintOff);
                }
            }
        });
    }

    private void setupQuestionSeekBar() {
        questionSeekBar = viewBinding.nquestionsSeekBar;
        seekBarTextView = viewBinding.seekBarValue;

        final int minimumvalue = res.getInteger(R.integer.totalq_minvalue);

        int firstValue = pref.getInt("TotalQuestions", res.getInteger(R.integer.totalq_defaultvalue));
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
