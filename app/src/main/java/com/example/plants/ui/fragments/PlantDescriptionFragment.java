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

import java.util.List;

public class PlantDescriptionFragment extends Fragment {

    private MedicalPlantViewModel medicalPlantViewModel;
    private static final String ARG_PLANT_ID = "plantId";
    private int plantId;

    // متد newInstance برای ارسال plantId
    public static PlantDescriptionFragment newInstance(int plantId) {
        PlantDescriptionFragment fragment = new PlantDescriptionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PLANT_ID, plantId);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_description, container, false);
        // دریافت plantId از Arguments
        if (getArguments() != null) {
            //plantId = getArguments().getInt(ARG_PLANT_ID, -1);
            plantId = getArguments().getInt("plantId");  // plantId را به عنوان int دریافت کنید
            Log.d("PlantDescriptionFragment", "Received plantId: " + plantId);  // بررسی مقدار plantId
        }
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
                    Log.d("PlantDescriptionFragment", "Number of plants: " + medicalPlants.size()); // لاگ برای تعداد گیاهان
                    MedicalPlant plant = medicalPlants.get(0); // فرض برای نمایش اولین گیاه
                    plantNameTextView.setText(plant.getPlantsName());
                    scNameTextView.setText(plant.getScName());
                    descriptionTextView.setText(plant.getDescription());
                } else {
                    Log.d("PlantDescriptionFragment", "No plants found"); // لاگ در صورتی که لیست خالی باشد
                }
            }

        });

        return view;
    }
}
