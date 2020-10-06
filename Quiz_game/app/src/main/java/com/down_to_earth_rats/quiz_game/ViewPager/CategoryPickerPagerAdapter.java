package com.down_to_earth_rats.quiz_game.ViewPager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryPickerPagerAdapter extends FragmentStateAdapter {

    private List<ICategory> dataSet = new ArrayList<>();
    private CategoryListener listener;

    private List<CategoryPickerFragment> fragments = new ArrayList<>();


    public CategoryPickerPagerAdapter(FragmentActivity fa, List<ICategory> dataSet, CategoryListener listener) {
        super(fa);

        this.listener = listener;
        this.dataSet = dataSet;
    }

    @Override
    public Fragment createFragment(int position) {

        fragments.add(position, new CategoryPickerFragment(dataSet.get(position), listener));

        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void updatePage(int position){
        System.out.println(position);
        System.out.println(fragments.size());
        if(fragments.size() > position){
            fragments.get(position).setNewCategory(dataSet.get(position));
        }
    }


}
