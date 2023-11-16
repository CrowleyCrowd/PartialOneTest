package com.example.partialonetest.connectors;

import static com.example.partialonetest.MainActivity.apiUrl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppInstance {
    public static AppInstance instance;
    private ApiInterface apiInterface;

    AppInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static AppInstance getInstance(){
        if (instance == null){
            instance = new AppInstance();
        }
        return instance;
    }

    public ApiInterface getApiInterface(){
        return apiInterface;
    }
}
