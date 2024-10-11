package com.example.plants.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.plants.R;
import com.example.plants.ui.fragments.PlantDescriptionFragment;
import com.example.plants.ui.fragments.PlantPropertiesFragment;
import com.example.plants.ui.fragments.PlantUsageFragment;
import com.google.android.material.tabs.TabLayout;

public class PlantDetailActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PlantPagerAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        // اتصال ویو‌ها
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        // تنظیم آداپتر برای ViewPager
        adapter = new PlantPagerAdapter();
        viewPager.setAdapter(adapter);

        // اتصال TabLayout به ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    private class PlantPagerAdapter extends FragmentPagerAdapter {
        public PlantPagerAdapter() {
            super(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PlantDescriptionFragment();
                case 1:
                    return new PlantPropertiesFragment();
                case 2:
                    return new PlantUsageFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3; // سه Fragment
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Description"; // عنوان تب ۱
                case 1:
                    return "Properties";  // عنوان تب ۲
                case 2:
                    return "Usage";        // عنوان تب ۳
                default:
                    return null;
            }
        }
    }
}
