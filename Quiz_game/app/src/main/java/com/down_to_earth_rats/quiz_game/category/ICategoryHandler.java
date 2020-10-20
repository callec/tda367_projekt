package com.down_to_earth_rats.quiz_game.category;

import java.util.Iterator;

/**
 * Created by Erik Blomberg
 *
 * Used to get a collection of Categories from one source
 */

public interface ICategoryHandler {

    Iterator<ICategory> getAllCategories();


}
