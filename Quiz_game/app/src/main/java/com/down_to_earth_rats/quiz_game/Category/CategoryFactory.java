package com.down_to_earth_rats.quiz_game.Category;

/**
 * Created by Erik Blomberg
 *
 * Factory used access the different categories
 */

public abstract class CategoryFactory {

    private static ICategoryHandler instanceHandler;

    //Get only a single instance, standard categories should not change during runtime
    public static ICategoryHandler getStandardHandler(){
        if(instanceHandler == null){
            instanceHandler = new SimpleCategoryHandler();
        }
        return instanceHandler;
    }

}
