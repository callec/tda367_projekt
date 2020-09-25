package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.down_to_earth_rats.quiz_game.Model.IQuizModel;
import com.down_to_earth_rats.quiz_game.databinding.ActivityMainBinding;

/**
 * Modified by Sara
 *
 * This class is our start screen
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinder = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinder.getRoot());

        viewBinder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPlay(view);
            }
        });


    }

    private void gotoPlay(View view) {
        Intent intent = new Intent(this, SubjectActivity.class);
        startActivity(intent);
    }
}
