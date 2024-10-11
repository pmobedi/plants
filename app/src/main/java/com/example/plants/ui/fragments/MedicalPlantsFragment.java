package com.example.plants.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plants.R;
import com.example.plants.ui.adapters.MedicalPlantsAdapter;
import com.example.plants.viewmodel.MedicalPlantViewModel;

import java.util.ArrayList;

public class MedicalPlantsFragment extends Fragment {
    private static final String TAG = "MedicalPlantsFragment"; // Tag for logging
    private MedicalPlantViewModel viewModel;
    private MedicalPlantsAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_plants, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new MedicalPlantsAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(MedicalPlantViewModel.class);
        viewModel.getMedicalPlantCount().observe(getViewLifecycleOwner(), count -> {
            Log.d("MedicalPlantCount", "Total medical plants: " + count);
        });
        viewModel.getAllMedicalPlants().observe(getViewLifecycleOwner(), medicalPlants -> {
            if (medicalPlants != null && !medicalPlants.isEmpty()) {
                Log.d(TAG, "Loaded medical plants: " + medicalPlants.size());
                adapter.setMedicalPlants(medicalPlants);
            } else {
                Log.d(TAG, "No medical plants found");
            }
        });

        return view;
    }
}
