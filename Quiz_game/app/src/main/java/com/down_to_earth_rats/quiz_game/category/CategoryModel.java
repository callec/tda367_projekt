package com.down_to_earth_rats.quiz_game.category;

import androidx.lifecycle.ViewModel;

import com.down_to_earth_rats.quiz_game.user.UserSingleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Model for displaying available categories to choose from.
 * Currently, only the standard categories are present.
 */

public class CategoryModel extends ViewModel {

    private List<ICategory> categories = new ArrayList<>();

    private List<IModelObserver> observers = new ArrayList<>();

    public CategoryModel() {
        getStandardCategories();
        categories.add(UserSingleton.getUser().getUserCategory());

    }

    private void getStandardCategories(){
        Iterator<ICategory> iterator = CategoryFactory.getStandardHandler().getAllCategories();
        while(iterator.hasNext()){
            categories.add(iterator.next());
        }
    }

    public List<ICategory> getCategories(){
        return categories;
    }

    public void registerObserver(IModelObserver observer){
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(IModelObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(int position){
        for(IModelObserver observer : observers){
            observer.pageUpdated(position);
        }
    }

}