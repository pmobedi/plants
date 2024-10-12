package com.example.plants.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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

    private static final String TAG = "PlantDetailActivity";
    private int plantId;
    private ViewPager viewPager;
    private PlantPagerAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        // دریافت plantId از Intent
        Intent intent = getIntent();
        if (intent != null) {
            plantId = intent.getIntExtra("plantId", -1);
            Log.d(TAG, "Received plantId: " + plantId);  // اضافه کردن لاگ برای بررسی مقدار plantId
        }

        // اتصال ویو‌ها
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        // تنظیم آداپتر برای ViewPager و ارسال plantId
        adapter = new PlantPagerAdapter(plantId);
        viewPager.setAdapter(adapter);

        // اتصال TabLayout به ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    private class PlantPagerAdapter extends FragmentPagerAdapter {

        private int plantId; // ذخیره plantId در آداپتر

        public PlantPagerAdapter(int plantId) {
            super(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            this.plantId = plantId;
        }

        @Override
        public Fragment getItem(int position) {
            // ارسال plantId به هر Fragment
            switch (position) {
                case 0:
                    return PlantDescriptionFragment.newInstance(plantId);
                case 1:
                    return PlantPropertiesFragment.newInstance(plantId);
                case 2:
                    return PlantUsageFragment.newInstance(plantId);
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
