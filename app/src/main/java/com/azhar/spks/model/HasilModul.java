package com.azhar.spks.model;

import com.google.gson.annotations.SerializedName;
public class HasilModul {
    @SerializedName("id_penyakit")
    private String idPenyakit;

    @SerializedName("nama_penyakit")
    private String namaPenyakit;

    @SerializedName("persentase")
    private String persentase;

    @SerializedName("solusi")
    private String solusi;


    public String getIdPenyakit() {
        return idPenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public String getPersentase() {
        return persentase;
    }

    public String getSolusi() {
        return solusi;
    }
}
