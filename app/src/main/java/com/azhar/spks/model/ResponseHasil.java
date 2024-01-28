package com.azhar.spks.model;

import com.google.gson.annotations.SerializedName;

public class ResponseHasil {
    @SerializedName("nama_penyakit")
    private String namaPenyakit;

    @SerializedName("id_penyakit")
    private String idPenyakit;

    @SerializedName("persentase")
    private int persentase;

    public String getNamaPenyakit(){
        return namaPenyakit;
    }

    public String getIdPenyakit(){
        return idPenyakit;
    }

    public int getPersentase(){
        return persentase;
    }
}
