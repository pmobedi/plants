package com.example.plants.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.plants.R;
import com.example.plants.database.MedicalPlant;
import com.example.plants.viewmodel.MedicalPlantViewModel;

public class PlantUsageFragment extends Fragment {

    private static final String ARG_PLANT_ID = "plantId";
    private int plantId;
    private MedicalPlantViewModel medicalPlantViewModel;
    private TextView usageTextView;
    // متد newInstance برای ارسال plantId
    public static PlantUsageFragment newInstance(int plantId) {
        PlantUsageFragment fragment = new PlantUsageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PLANT_ID, plantId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_usage, container, false);

        usageTextView = view.findViewById(R.id.usage);

        if (getArguments() != null) {
            plantId = getArguments().getInt("plantId");
            Log.d("PlantUsageFragment", "Received plantId: " + plantId);  // بررسی مقدار plantId
        }

        medicalPlantViewModel = new ViewModelProvider(this).get(MedicalPlantViewModel.class);

        medicalPlantViewModel.getMedicalPlantById(plantId).observe(getViewLifecycleOwner(), new Observer<MedicalPlant>() {
            @Override
            public void onChanged(MedicalPlant plant) {
                if (plant != null) {
                    Log.d("PlantUsageFragment", "Plant Usage: " + plant.getHabitat());  // بررسی داده‌های دریافت‌شده
                    usageTextView.setText(plant.getHabitat());
                } else {
                    Log.d("PlantUsageFragment", "Plant not found");
                }
            }
        });

        return view;
    }
}
