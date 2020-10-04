package com.down_to_earth_rats.quiz_game.ViewPager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.down_to_earth_rats.quiz_game.R;

public class CategoryPickerActivity extends FragmentActivity {

    private static final int NUM = 3;

    private ViewPager2 viewPager2;

    private FragmentStateAdapter pagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_picker);

        viewPager2 = findViewById(R.id.pager);
        pagerAdapter = new CategoryPickerPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

    }

    @Override
    public void onBackPressed() {
        if (viewPager2.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        }
    }


    private class CategoryPickerPagerAdapter extends FragmentStateAdapter {
        public CategoryPickerPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return new CategoryPickerFragment(position);
        }

        @Override
        public int getItemCount() {
            return NUM;
        }
    }


}