package com.example.partialonetest.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.partialonetest.R;
import com.example.partialonetest.models.DigimonModel;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;

import java.util.List;

public class DigimonAdapter extends RecyclerView.Adapter<DigimonHolder> {
    private Context context;
    private List<DigimonModel> digimons;

    public DigimonAdapter(Context applicationContext, List<DigimonModel> digimons) {
        this.context = applicationContext;
        this.digimons = digimons;
    }

    @NonNull
    @Override
    public DigimonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DigimonHolder(LayoutInflater.from(context).inflate(R.layout.digimon_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DigimonHolder holder, int position) {
        holder.getName().setText(digimons.get(position).getName());
        holder.getLevel().setText(digimons.get(position).getLevel());
        Picasso.get().load(digimons.get(position).getImg()).into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return digimons.size();
    }
}
