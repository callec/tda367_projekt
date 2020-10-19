package com.down_to_earth_rats.quiz_game.GUIPackage.Modal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.down_to_earth_rats.quiz_game.GUIPackage.Modal.IModalFragmentHandler;

/**
 * Created by Henrik, Carl
 * Modified by Henrik
 * Opens a modal panel with choices (from an array).
 */
public class ModalFragment extends DialogFragment {

    private String title;
    private String[] buttons;
    private IModalFragmentHandler handler;

    public ModalFragment(String title, String[] buttons, IModalFragmentHandler handler) {
        this.title = title;
        this.buttons = buttons;
        this.handler = handler;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)handler); //Necessary cast (from what I understand), should not lead to problems
        builder.setTitle(title)
                .setItems(buttons, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item

                        //Let (most often) caller decide how to handle button presses
                        handler.modalFragmentButtonPressed(which);

                    }
                });
        return builder.create();
    }


}
