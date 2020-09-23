package com.down_to_earth_rats.quiz_game;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class modalFragment extends DialogFragment {

    private String title;
    private String[] buttons;
    private Context context;

    public modalFragment(String title, String[] buttons, Context context) {
        this.title = title;
        this.buttons = buttons;
        this.context = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setItems(buttons, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which){
                            case 0:
                                break;
                            case 1:
                                //TODO restart quiz
                                break;
                            case 2:
                                //TODO go to result or straight to menu?
                                SwitchActivity();
                        }

                    }
                });
        return builder.create();
    }


    private void SwitchActivity(){
        Intent intent = new Intent(context, ResultsActivity.class);
        startActivity(intent);
    }

}
