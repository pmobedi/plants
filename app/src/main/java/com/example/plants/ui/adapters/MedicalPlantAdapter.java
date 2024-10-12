package com.example.plants.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plants.R;
import com.example.plants.database.MedicalPlant;
import com.example.plants.ui.activities.PlantDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MedicalPlantAdapter extends RecyclerView.Adapter<MedicalPlantAdapter.ViewHolder> {

    private ArrayList<MedicalPlant> plantsList;
    private Context context;
    private OnPlantClickListener listener;

    public interface OnPlantClickListener {
        void onPlantClick(MedicalPlant plant);
    }

    public MedicalPlantAdapter(ArrayList<MedicalPlant> plantsList, Context context, OnPlantClickListener listener) {
        this.plantsList = plantsList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_medical_plant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicalPlant plant = plantsList.get(position);
        holder.nameTextView.setText(plant.getPlantsName());
        holder.nameEnTextView.setText(plant.getScName());

        if (plant.getImg() != null) {
            Bitmap bmp = BitmapFactory.decodeByteArray(plant.getImg(), 0, plant.getImg().length);
            holder.imageView.setImageBitmap(bmp);
        }

        holder.itemView.setOnClickListener(v -> listener.onPlantClick(plant));

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            // اضافه کردن لاگ برای بررسی plantId
            int plantId = plant.getId();
            Log.d("MedicalPlantAdapter", "Sending plantId: " + plantId);
            Intent intent = new Intent(context, PlantDetailActivity.class);
            intent.putExtra("plantId", plant.getId());  // Sending plant ID
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return plantsList.size();
    }

    public void setPlants(List<MedicalPlant> plants) {
        this.plantsList = new ArrayList<>(plants);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView nameEnTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.plant_name);
            nameEnTextView = itemView.findViewById(R.id.scientific_name);
            imageView = itemView.findViewById(R.id.plant_image);
        }
    }
}
