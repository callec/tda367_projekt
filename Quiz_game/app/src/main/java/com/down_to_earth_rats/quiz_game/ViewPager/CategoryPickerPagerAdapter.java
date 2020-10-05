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

    public CategoryPickerPagerAdapter(FragmentActivity fa, List<ICategory> dataSet, CategoryListener listener) {
        super(fa);
        this.listener = listener;
        this.dataSet.addAll(dataSet);
    }

    @Override
    public Fragment createFragment(int position) {
        return new CategoryPickerFragment(dataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
