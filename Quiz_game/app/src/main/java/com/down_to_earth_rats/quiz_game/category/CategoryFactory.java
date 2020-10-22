package com.down_to_earth_rats.quiz_game.category;

/**
 * Created by Erik Blomberg
 *
 * Factory used access categories from different sources
 * Uses the ICategoryHandler interface.
 */

public abstract class CategoryFactory {

    private static ICategoryHandler instanceHandler;

    //Get only a single instance, standard categories should not change during runtime
    public static ICategoryHandler getDefaultHandler(){
        if(instanceHandler == null){
            instanceHandler = new DefaultCategoryHandler();
        }
        return instanceHandler;
    }

}
