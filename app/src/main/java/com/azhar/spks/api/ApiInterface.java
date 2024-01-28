package com.azhar.spks.api;

import com.azhar.spks.model.HasilModul;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("ds_testing.php")
    Call<List<HasilModul>> gethasil(
            @Query("key") String key
    );
}
