package com.down_to_earth_rats.quiz_game.ViewPager.QuickTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.ViewPager.CategoryPickerActivity;
import com.down_to_earth_rats.quiz_game.databinding.ActivityTestForViewPagerBinding;

public class TestActivityForViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String category_name = getIntent().getStringExtra(CategoryPickerActivity.CATEGORY_ID);
        String subCategory_name = getIntent().getStringExtra(CategoryPickerActivity.SUBCATEGORY_ID);


        ActivityTestForViewPagerBinding binding = ActivityTestForViewPagerBinding.inflate(getLayoutInflater());
        binding.categoryNameText.setText(category_name);
        binding.subCategoryNameText.setText(subCategory_name);

        setContentView(binding.getRoot());

    }
}