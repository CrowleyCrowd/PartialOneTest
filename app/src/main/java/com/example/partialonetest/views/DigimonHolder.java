package com.example.partialonetest.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.partialonetest.R;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

public class DigimonHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView level;
    private ImageView image;

    public DigimonHolder(@NonNull View viewItem) {
        super(viewItem);
        name = viewItem.findViewById(R.id.tvName);
        level = viewItem.findViewById(R.id.tvLevel);
        image = viewItem.findViewById(R.id.ivDigimon);
    }

    public TextView getName() {
        return name;
    }

    public TextView getLevel() {
        return level;
    }

    public ImageView getImage() {
        return image;
    }
}
