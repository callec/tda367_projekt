package com.down_to_earth_rats.quiz_game.gui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityMainBinding;
import com.down_to_earth_rats.quiz_game.gui.modal.IModalFragmentHandler;
import com.down_to_earth_rats.quiz_game.gui.modal.ModalFragment;

/**
 * Modified by Sara
 * and Henrik
 * <p>
 * This class represents our start screen. It only has buttons that can take us to other views.
 */
public class MainActivity extends AppCompatActivity implements IModalFragmentHandler {

    ModalFragment modal;
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
        viewBinder.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSettings(view);
            }
        });

        viewBinder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHighscore(view);
            }
        });
    }

    private void gotoPlay(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    private void gotoSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void gotoHighscore(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        modal = new ModalFragment(this.getResources().getString(R.string.quit_app_modal), this.getResources().getStringArray(R.array.quit_app_modal), this);
        modal.show(this.getSupportFragmentManager(), "q");
    }

    @Override
    public void modalFragmentButtonPressed(int buttonIndex) {

        // "Are you sure you want to exit?"
        switch (buttonIndex) {
            // "Yes"
            case 0:
                // Exit app - which is basically done by navigating to android home screen
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            // "No"
            case 1:
                // do nothing
                break;
        }
    }
}
