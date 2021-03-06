package com.down_to_earth_rats.quiz_game.gui.modal;

/**
 * Created by Henrik
 *
 * Interface for classes that use modalFragment, to enable modalFragment re-usability
 */
public interface IModalFragmentHandler {

    /**
     * Method that will be called from modalFragment when a button in the modal is pressed
     * @param buttonIndex index of the button - corresponds to string index in list that is used to set alternatives
     */
    void modalFragmentButtonPressed(int buttonIndex);

}
