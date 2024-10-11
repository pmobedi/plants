package com.example.plants.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MedicalPlant.class}, version = 1)
public abstract class MedicalPlantsDatabase extends RoomDatabase {
    public abstract MedicalPlantDao medicalPlantDao();


    private static volatile MedicalPlantsDatabase INSTANCE;

    public static MedicalPlantsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MedicalPlantsDatabase.class) {
                if (INSTANCE == null) {
                    try{
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                        MedicalPlantsDatabase.class, "MedicalPlantsDB.db")
                                .createFromAsset("MedicalPlantsDB.db")  // استفاده از این متد برای کپی از assets
                                .build();
                    }catch (Exception e) {
                        Log.e("MedicalPlantsDatabase", "Error connecting to database", e);
                    }

                }
            }
        }
        return INSTANCE;
    }
}
