package com.example.jan.restaurantapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    List<Reserva> lista;

    public AdapterDatos(List<Reserva> listDatos) {
        this.lista = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.asignarDatos(lista.get(i));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView fechaTextView;
        TextView comensalesTextView;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            fechaTextView = itemView.findViewById(R.id.fechaItem);
            comensalesTextView = itemView.findViewById(R.id.comensalesItem);
        }

        public void asignarDatos(Reserva r) {
            String nombre = r.getFecha();
            String fecha = r.getComensales();
            fechaTextView.setText(nombre);
            comensalesTextView.setText(fecha);
        }
    }
}
