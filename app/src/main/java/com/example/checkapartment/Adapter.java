package com.example.checkapartment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.databinding.ItemViewBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder> {
    private List<Apartment>adapter;
    private IAdapter iAdapter;


    public Adapter(List<Apartment> adapter,IAdapter iAdapter){
        this.adapter = adapter;
        this.iAdapter = iAdapter;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding = ItemViewBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false);
        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Apartment apartment = adapter.get(position);
        holder.edificio.setText(apartment.getBuildingName());
        holder.departamento.setText(apartment.getUnitId());
        holder.direccion.setText(apartment.getAddress());
        Glide.with(holder.imageView.getContext()).load(apartment.getUrlImageBuilding())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return adapter.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private ImageView  imageView;
    private TextView edificio;
    private TextView departamento;
        private TextView direccion;

        public ListViewHolder(@NonNull ItemViewBinding binding) {
            super(binding.getRoot());
            edificio = binding.tvNombreEdificio;
            departamento = binding.tvDepartamento;
            direccion = binding.tvDireccion;
            imageView = binding.ivEdificioEvil;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            iAdapter.passApartment(adapter.get(getLayoutPosition()));
        }
    }
}

