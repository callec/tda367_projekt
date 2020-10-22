package com.down_to_earth_rats.quiz_game.category;

import java.util.Iterator;

/**
 * Created by Erik Blomberg
 *
 * Used to get a collection of Categories.
 * How the question are acquired or how they are stored should not matter.
 * A uniform way to fetch them.
 */

public interface ICategoryHandler {

    /**
     *
     * @return iterator of all current categories
     */
    Iterator<ICategory> getAllCategories();


}
