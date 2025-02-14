package com.example.plants;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.plants.ui.fragments.MedicalPlantFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new MedicalPlantFragment())
                    .commitNow();
        }
    }
}
