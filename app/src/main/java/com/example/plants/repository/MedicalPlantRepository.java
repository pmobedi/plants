package com.example.plants.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.plants.database.MedicalPlant;
import com.example.plants.database.MedicalPlantDao;
import com.example.plants.database.MedicalPlantsDatabase;

import java.util.List;

public class MedicalPlantRepository {
    private static final String TAG = "MedicalPlantRepository"; // Tag for logging
    private MedicalPlantDao medicalPlantDao;
    private LiveData<List<MedicalPlant>> allMedicalPlants;

    public MedicalPlantRepository(Application application) {
        MedicalPlantsDatabase db = MedicalPlantsDatabase.getDatabase(application);
        medicalPlantDao = db.medicalPlantDao();
        allMedicalPlants = medicalPlantDao.getAllMedicalPlants();
    }

    public LiveData<List<MedicalPlant>> getAllMedicalPlants() {
        // افزودن لاگ برای بررسی داده‌ها
        allMedicalPlants.observeForever(plants -> {
            for (MedicalPlant plant : plants) {
                Log.d("MedicalPlantRepository", "Plant ID: " + plant.getId() + ", Name: " + plant.getPlantsName());
            }
        });
        return allMedicalPlants;
    }
    public LiveData<MedicalPlant> getMedicalPlantById(int plantId) {
        return medicalPlantDao.getMedicalPlantById(plantId);
    }

    public LiveData<Integer> getMedicalPlantCount() {
        Log.d(TAG, "Fetching medical plant count");
        return medicalPlantDao.getMedicalPlantCount();
    }
}
