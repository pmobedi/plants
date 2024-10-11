package com.example.plants.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.plants.R;
import com.example.plants.database.MedicalPlant;

import java.util.List;

public class MedicalPlantsAdapter extends RecyclerView.Adapter<MedicalPlantsAdapter.MedicalPlantViewHolder> {
    private List<MedicalPlant> medicalPlants;

    public MedicalPlantsAdapter(List<MedicalPlant> medicalPlants) {
        this.medicalPlants = medicalPlants;
    }

    @Override
    public MedicalPlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medical_plant, parent, false);
        return new MedicalPlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicalPlantViewHolder holder, int position) {
        MedicalPlant medicalPlant = medicalPlants.get(position);
        holder.plantName.setText(medicalPlant.getScName());
        holder.description.setText(medicalPlant.getDescription());
    }

    @Override
    public int getItemCount() {
        return medicalPlants.size();
    }

    public void setMedicalPlants(List<MedicalPlant> medicalPlants) {
        this.medicalPlants = medicalPlants;
        notifyDataSetChanged();
    }

    public static class MedicalPlantViewHolder extends RecyclerView.ViewHolder {
        TextView plantName;
        TextView description;

        public MedicalPlantViewHolder(View itemView) {
            super(itemView);
            plantName = itemView.findViewById(R.id.plantName);
            description = itemView.findViewById(R.id.description);
        }
    }
}
