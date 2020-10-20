package com.down_to_earth_rats.quiz_game.Category;

/**
 * Created by Erik Blomberg
 *
 * Interface used to by the ViewModel to tell observers that the data set has changed
 */

public interface IModelObserver {

    /**
     *
     * @param position the category that has updated
     */
    void pageUpdated(int position);

}
