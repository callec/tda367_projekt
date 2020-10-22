package com.down_to_earth_rats.quiz_game.gui.category_picker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.down_to_earth_rats.quiz_game.category.ICategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Used to display a fragment on each page in the ViewPager.
 * The Fragments shows a list with all subcategories
 */

public class CategoryPagerAdapter extends FragmentStateAdapter {

    private final List<ICategory> dataSet;
    private final ICategoryClickListener listener;

    //The different pages
    private final List<SubCategoryListFragment> fragments = new ArrayList<>();


    public CategoryPagerAdapter(FragmentActivity fa, List<ICategory> dataSet, ICategoryClickListener listener) {
        super(fa);

        this.listener = listener;
        this.dataSet = dataSet;
    }

    @Override
    public Fragment createFragment(int position) {

        SubCategoryListFragment fragment = new SubCategoryListFragment();
        fragment.setNewCategory(dataSet.get(position));
        fragment.setListener(listener);

        //Store fragment for later reference
        fragments.add(position, fragment);

        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void updatePage(int position){
        //Confirm that the page can be found
        if(fragments.size() > position && dataSet.size() > position){
            fragments.get(position).setNewCategory(dataSet.get(position));
        }
    }
}
