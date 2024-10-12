package com.example.plants.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.plants.database.MedicalPlant;
import com.example.plants.repository.MedicalPlantRepository;

import java.util.List;

public class MedicalPlantViewModel extends AndroidViewModel {
    private static final String TAG = "MedicalPlantViewModel"; // Tag for logging
    private MedicalPlantRepository repository;
    private LiveData<List<MedicalPlant>> allMedicalPlants;

    public MedicalPlantViewModel(Application application) {
        super(application);
        repository = new MedicalPlantRepository(application);
        allMedicalPlants = repository.getAllMedicalPlants();}
    public LiveData<List<MedicalPlant>> getAllMedicalPlants() {
        return allMedicalPlants;
    }
    public LiveData<Integer> getMedicalPlantCount() {
       return repository.getMedicalPlantCount();
    }
    // متد برای دریافت گیاه براساس Id
    public LiveData<MedicalPlant> getMedicalPlantById(int plantId) {
        return repository.getMedicalPlantById(plantId);
    }
}
