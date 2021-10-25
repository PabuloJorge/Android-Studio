package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CarroViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_modelo;

    public CarroViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_modelo = itemView.findViewById(R.id.tv_modelo);

    }
}
