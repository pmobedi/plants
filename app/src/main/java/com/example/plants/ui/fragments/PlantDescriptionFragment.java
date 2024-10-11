package com.example.plants.ui.fragments;

import android.os.Bundle;
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

import java.util.List;

public class PlantDescriptionFragment extends Fragment {

    private MedicalPlantViewModel medicalPlantViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_description, container, false);

        // پیدا کردن TextView ها
        TextView plantNameTextView = view.findViewById(R.id.plantName);
        TextView scNameTextView = view.findViewById(R.id.scName);
        TextView descriptionTextView = view.findViewById(R.id.description);

        // دریافت ViewModel
        medicalPlantViewModel = new ViewModelProvider(this).get(MedicalPlantViewModel.class);

        // مشاهده LiveData و به‌روزرسانی UI با داده‌ها
        medicalPlantViewModel.getAllMedicalPlants().observe(getViewLifecycleOwner(), new Observer<List<MedicalPlant>>() {
            @Override
            public void onChanged(List<MedicalPlant> medicalPlants) {
                if (medicalPlants != null && !medicalPlants.isEmpty()) {
                    MedicalPlant plant = medicalPlants.get(0); // فرض برای نمایش اولین گیاه
                    plantNameTextView.setText(plant.getPlantsName());
                    scNameTextView.setText(plant.getScName());
                    descriptionTextView.setText(plant.getDescription());
                }
            }
        });

        return view;
    }
}
