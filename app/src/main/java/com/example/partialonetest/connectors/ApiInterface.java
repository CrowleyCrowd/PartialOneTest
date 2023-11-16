package com.example.partialonetest.connectors;

import com.example.partialonetest.models.DigimonModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("digimon")
    Call<List<DigimonModel>> getDigimon();

}
