package com.down_to_earth_rats.quiz_game;

/**
 * Created by Henrik
 *
 * Interface for classes that use modalFragment, to enable modalFragment re-usability
 */
public interface IModalFragmentHandler {

    //Classes that implements this interface might want to save the list
    // that is used to set the buttons, to also use when buttons are pressed.

    /**
     * Method that will be called from modalFragment when a button in the modal is pressed
     * @param buttonIndex index of the button - corresponds to string index in list that is used to set alternatives
     */
    public void modalFragmentButtonPressed(int buttonIndex);

}
