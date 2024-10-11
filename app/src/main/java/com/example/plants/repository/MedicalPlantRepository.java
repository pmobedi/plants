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
        Log.d(TAG, "Fetching all medical plants");
        return allMedicalPlants;
    }

    public LiveData<Integer> getMedicalPlantCount() {
        Log.d(TAG, "Fetching medical plant count");
        return medicalPlantDao.getMedicalPlantCount();
    }
}
