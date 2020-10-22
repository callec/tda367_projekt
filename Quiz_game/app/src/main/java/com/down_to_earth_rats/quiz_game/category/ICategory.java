package com.down_to_earth_rats.quiz_game.category;

import java.util.Iterator;

/**
 * Created by Erik Blomberg
 *
 * Interface representing the components of a Category
 */

public interface ICategory {

    /**
     *
     * @return name of category
     */
    String getCategoryName();

    /**
     *
     * @return iterator of all subcategories belonging to this category
     */
    Iterator<String> getSubCategories();


}
