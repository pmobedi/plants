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

public class PlantPropertiesFragment extends Fragment {

    private MedicalPlantViewModel medicalPlantViewModel;
    private TextView propertiesTextView;
    private static final String ARG_PLANT_ID = "plantId";
    private int plantId;

    // متد newInstance برای ارسال plantId
    public static PlantPropertiesFragment newInstance(int plantId) {
        PlantPropertiesFragment fragment = new PlantPropertiesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PLANT_ID, plantId);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_properties, container, false);

        propertiesTextView = view.findViewById(R.id.properties);

        if (getArguments() != null) {
            plantId = getArguments().getInt("plantId");  // plantId را به عنوان int دریافت کنید
            Log.d("PlantPropertiesFragment", "Received plantId: " + plantId);  // بررسی مقدار plantId
        }

        medicalPlantViewModel = new ViewModelProvider(this).get(MedicalPlantViewModel.class);

        medicalPlantViewModel.getMedicalPlantById(plantId).observe(getViewLifecycleOwner(), new Observer<MedicalPlant>() {
            @Override
            public void onChanged(MedicalPlant plant) {
                if (plant != null) {
                    Log.d("PlantPropertiesFragment", "Plant Properties: " + plant.getProperties());
                    propertiesTextView.setText(plant.getProperties());
                } else {
                    Log.d("PlantPropertiesFragment", "Plant not found");
                }
            }
        });

        return view;
    }
}
