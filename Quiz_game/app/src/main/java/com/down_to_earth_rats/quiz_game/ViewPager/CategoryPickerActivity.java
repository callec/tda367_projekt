package com.down_to_earth_rats.quiz_game.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TableLayout;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityCategoryPickerBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CategoryPickerActivity extends FragmentActivity {

    private int NUM = 3;

    private ViewPager2 viewPager2;

    private FragmentStateAdapter pagerAdapter;

    private List<Integer> intList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 25; i+=3) {
            intList.add(i);
        }

        NUM = intList.size();

        ActivityCategoryPickerBinding binding = ActivityCategoryPickerBinding.inflate(getLayoutInflater());
        viewPager2 = binding.pager;
        pagerAdapter = new CategoryPickerPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        TabLayout tabLayout = binding.tabs;
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("OBJECT " + (intList.get(position)));

                    }
                }
        );
        tabLayoutMediator.attach();

        setContentView(binding.getRoot());

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
            return new CategoryPickerFragment(intList.get(position));
        }

        @Override
        public int getItemCount() {
            return NUM;
        }
    }


}



/*new CountDownTimer(3000, 2000) {

            @Override
            public void onTick(long l) {


            }

            @Override
            public void onFinish() {

                NUM--;
                pagerAdapter = test();
                viewPager2.setAdapter(pagerAdapter);
                pagerAdapter.notifyDataSetChanged();
            }

        }.start();*/


/*private CategoryPickerPagerAdapter test(){
        return new CategoryPickerPagerAdapter(this);
    }*/


//tabLayout.removeTabAt();