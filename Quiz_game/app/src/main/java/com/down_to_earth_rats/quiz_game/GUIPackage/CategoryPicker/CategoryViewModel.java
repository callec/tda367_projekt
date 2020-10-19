package com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker;

import androidx.lifecycle.ViewModel;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.CategoryFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.UserPackage.UserSingleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Model for displaying available categories to choose from.
 * Currently, only the standard categories are present.
 */

public class CategoryViewModel extends ViewModel {

    private List<ICategory> categories = new ArrayList<>();

    private List<ViewModelObserver> observers = new ArrayList<>();

    public CategoryViewModel() {
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

    public void registerObserver(ViewModelObserver observer){
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(ViewModelObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(int position){
        for(ViewModelObserver observer : observers){
            observer.pageUpdated(position);
        }
    }

}