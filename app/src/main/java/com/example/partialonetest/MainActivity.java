package com.example.partialonetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.partialonetest.connectors.AppInstance;
import com.example.partialonetest.models.DigimonModel;
import com.example.partialonetest.views.DigimonAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;

    private List<DigimonModel> digimons;

    public static String apiUrl = "https://digimon-api.vercel.app/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain = findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

        AppInstance.getInstance().getApiInterface().getDigimon().enqueue(new Callback<List<DigimonModel>>() {
            @Override
            public void onResponse(Call<List<DigimonModel>> call, Response<List<DigimonModel>> response) {
                digimons = response.body();
                rvMain.setAdapter(new DigimonAdapter(getApplicationContext(),digimons));
            }

            @Override
            public void onFailure(Call<List<DigimonModel>> call, Throwable t) {
                Log.e("API", "onFailure:" + t.getLocalizedMessage());
            }
        });
    }
}