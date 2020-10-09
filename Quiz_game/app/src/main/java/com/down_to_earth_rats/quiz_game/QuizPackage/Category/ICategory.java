package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

import java.util.Iterator;

/**
 * Created by Erik Blomberg
 *
 * Interface representing the components of a Category
 */

public interface ICategory {

    String getCategoryName();

    Iterator<String> getSubCategories();


}
