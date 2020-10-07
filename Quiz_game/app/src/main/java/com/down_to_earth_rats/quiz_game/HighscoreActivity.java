package com.down_to_earth_rats.quiz_game;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.down_to_earth_rats.quiz_game.databinding.ActivityHighscoreBinding;

/**
 * Created by Sara Persson
 *
 */

public class HighscoreActivity extends AppCompatActivity {
    private ActivityHighscoreBinding viewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityHighscoreBinding.inflate(getLayoutInflater());


        Toolbar toolbar = viewBinding.toolbarHighscore;

        //ResultObject result1 = User.getInstance().getStatistics("Addition").get(0);
        //System.out.println(result1.getDate());

        toolbar.setTitle("Hem");
        setSupportActionBar(toolbar);

        //Gives us the return to previous page /back arrow, in the top toolbar   (<-)
        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        setContentView(viewBinding.getRoot());



    }


}
