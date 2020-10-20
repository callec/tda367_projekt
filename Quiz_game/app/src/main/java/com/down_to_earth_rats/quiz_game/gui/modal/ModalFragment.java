package com.down_to_earth_rats.quiz_game.gui.modal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

/**
 * Created by Henrik, Carl
 * Modified by Henrik
 * Opens a modal panel with choices (from an array).
 */
public class ModalFragment extends DialogFragment {

    private String title;
    private String[] buttons;
    private IModalFragmentHandler handler;

    /**
     * Sole constructor, is used within the Activities that use a DialogFragment.
     * @param title string title of the DialogFragment
     * @param buttons array of string, the text on the buttons
     * @param handler IModalFragmentHandler, handles the clicks
     */
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
                        handler.modalFragmentButtonPressed(which);
                    }
                });
        return builder.create();
    }
}
