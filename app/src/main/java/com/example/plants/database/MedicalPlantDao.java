package com.example.plants.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedicalPlantDao {
    @Query("SELECT * FROM MedicalPlants")
    LiveData<List<MedicalPlant>> getAllMedicalPlants();

    @Query("SELECT COUNT(*) FROM MedicalPlants")
    LiveData<Integer> getMedicalPlantCount();

    @Query("SELECT * FROM MedicalPlants WHERE id = :plantId")
    LiveData<MedicalPlant> getMedicalPlantById(int plantId);

}
