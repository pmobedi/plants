package com.example.plants.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plants.R;
import com.example.plants.database.MedicalPlant;
import com.example.plants.ui.adapters.MedicalPlantAdapter;
import com.example.plants.viewmodel.MedicalPlantViewModel;
import com.example.plants.ui.activities.PlantDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MedicalPlantFragment extends Fragment {
    private MedicalPlantViewModel viewModel;
    private RecyclerView recyclerView;
    private MedicalPlantAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medical_plants, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MedicalPlantAdapter(new ArrayList<>(), getContext(), new MedicalPlantAdapter.OnPlantClickListener() {
            @Override
            public void onPlantClick(MedicalPlant plant) {
                Log.d("MedicalPlantFragment", "Sending plantId: " + plant.getId());  // اضافه کردن لاگ برای بررسی مقدار plantId
                Intent intent = new Intent(getActivity(), PlantDetailActivity.class);
                intent.putExtra("plantId", plant.getId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(MedicalPlantViewModel.class);
        viewModel.getAllMedicalPlants().observe(getViewLifecycleOwner(), new Observer<List<MedicalPlant>>() {
            @Override
            public void onChanged(List<MedicalPlant> plants) {
                adapter.setPlants(plants); // Ensure your MedicalPlantAdapter class has this method
            }
        });
    }
}
