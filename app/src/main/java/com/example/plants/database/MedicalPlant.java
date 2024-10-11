package com.example.plants.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "MedicalPlants")
public class MedicalPlant {


    @PrimaryKey
    @NonNull
    private Integer id; // Ensure this is NOT NULL with default value if necessary

    @ColumnInfo(name = "plantsName")
    public String plantsName;

    @ColumnInfo(name = "scName")
    public String scName;

    @ColumnInfo(name = "family")
    public String family;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "chemicalCompounds")
    public String chemicalCompounds;
    @ColumnInfo(name = "habitat")
    private String habitat;

    @ColumnInfo(name = "agriculture")
    private String agriculture;

    @ColumnInfo(name = "soilType")
    private String soilType;

    @ColumnInfo(name = "waterReq")
    private String waterReq;

    @ColumnInfo(name = "kodeNeeds")
    private String kodeNeeds;

    @ColumnInfo(name = "disease")
    private String disease;

    @ColumnInfo(name = "flowring")
    private String flowring;

    @ColumnInfo(name = "properties")

    private String properties;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] img; // Store images as binary data (BLOB)

    @ColumnInfo(name = "img2")
    private String img2; // Store image URL if necessary

    @ColumnInfo(name = "fav",defaultValue = "0") // Set default value to 0
    private int fav; // NOT NULL field with default value

    // Getters and Setters
    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getPlantsName() {
        return plantsName;
    }

    public void setPlantsName(String plantsName) {
        this.plantsName = plantsName;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChemicalCompounds() {
        return chemicalCompounds;
    }

    public void setChemicalCompounds(String chemicalCompounds) {
        this.chemicalCompounds = chemicalCompounds;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAgriculture() {
        return agriculture;
    }

    public void setAgriculture(String agriculture) {
        this.agriculture = agriculture;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getWaterReq() {
        return waterReq;
    }

    public void setWaterReq(String waterReq) {
        this.waterReq = waterReq;
    }

    public String getKodeNeeds() {
        return kodeNeeds;
    }

    public void setKodeNeeds(String kodeNeeds) {
        this.kodeNeeds = kodeNeeds;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }



    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public String getFlowring() {
        return flowring;
    }

    public void setFlowring(String flowring) {
        this.flowring = flowring;
    }

}
