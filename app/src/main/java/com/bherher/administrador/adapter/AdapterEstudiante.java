package com.bherher.administrador.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bherher.administrador.R;
import com.bherher.administrador.modelo.MEstudiante;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterEstudiante extends RecyclerView.Adapter<AdapterEstudiante.ViewHolder> {

    private ArrayList<MEstudiante> lista;
    private Bundle paquete;

    public AdapterEstudiante(ArrayList<MEstudiante> lista){
        this.lista=lista;
    }
    @NonNull
    @Override
    public AdapterEstudiante.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiantes,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEstudiante.ViewHolder holder, int position) {
        MEstudiante mEstudiante=lista.get(position);
        paquete = new Bundle();

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void filtro(ArrayList<MEstudiante>filtrados){
        this.lista=filtrados;
        notifyDataSetChanged();

    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        private Text txtMatricula,txtNombre,txtPeriodo,txtCarrera,txtTutor,txtFamiliar,txtCorreo;
        private ImageView btnEliminar, btnEditar;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
