package com.down_to_earth_rats.quiz_game.category;

import java.util.Iterator;

/**
 * Created by Erik Blomberg
 *
 * Used to get a collection of Categories from one source
 */

public interface ICategoryHandler {

    /**
     *
     * @return iterator of all current categories of quizzes
     */
    Iterator<ICategory> getAllCategories();


}
