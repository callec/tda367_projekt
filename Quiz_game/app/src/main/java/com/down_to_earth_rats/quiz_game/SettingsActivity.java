package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SimpleAdapter;
import android.widget.Switch;


import com.down_to_earth_rats.quiz_game.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {
    private ActivitySettingsBinding viewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivitySettingsBinding.inflate(getLayoutInflater());


    Toolbar toolbar = viewBinding.toolbarSettings;
    toolbar.setTitle("Home");
    setSupportActionBar(toolbar);

    //Gives us the return to previous page /back arrow, in the top toolbar   (<-)
    ActionBar ab = getSupportActionBar();

    if (ab != null) {
        ab.setDisplayHomeAsUpEnabled(true);
    }
        setContentView(viewBinding.getRoot());

    //This is the code for the switch, when clicked it changes text.
    final Switch s = (Switch) findViewById(R.id.switch1);
    s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        String test = s.getText().toString();
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){ //Switch on
                s.setText("Smaller text");
            }
            else{  //Switch off
                s.setText(test);
            }
        }
    });


    }


}
