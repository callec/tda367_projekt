package com.down_to_earth_rats.quiz_game.category;

/**
 * Created by Erik Blomberg
 *
 * Interface used by the model to specify that a category has changed like
 * added new subcategories, changed name or removed.
 */

public interface IModelObserver {

    /**
     *
     * @param position the category that has been updated
     */
    void pageUpdated(int position);

}
