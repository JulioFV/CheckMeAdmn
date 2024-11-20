package com.bherher.administrador.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bherher.administrador.R;
import com.bherher.administrador.modelo.MAsignatura;
import com.bherher.administrador.modelo.MPadres;

import java.util.ArrayList;

public class AdapterPadres extends RecyclerView.Adapter<AdapterPadres.ViewHolder> {

    private ArrayList<MPadres> lista;
    private Bundle paquete;
public AdapterPadres(ArrayList<MPadres> lista){
this.lista =lista;
}

    @NonNull
    @Override
    public AdapterPadres.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_padres,parent, false);
             return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPadres.ViewHolder holder, int position) {
            MPadres mtutor =lista.get(position);
            MPadres pad=lista.get(position);


    }

    @Override
    public int getItemCount() {return lista.size(); }
    public void filtro(ArrayList<MPadres>filtrados){
      this.lista=filtrados;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView lblNombrePadre, lblNombreHijo, lblNombreTutor, lblTelefono, lblCorreo, lblMatricula;
        private ImageView btnEliminar, btnEditar;
        public ViewHolder(@NonNull View itemView){
            super (itemView);
            btnEliminar=itemView.findViewById(R.id.item_Pad_eliminar);
            btnEditar=itemView.findViewById(R.id.item_Pad_editar);
            lblNombrePadre=itemView.findViewById(R.id.item_Pad_nombre);
            lblTelefono=itemView.findViewById(R.id.item_Pad_telefono);
            lblCorreo=itemView.findViewById(R.id.item_Pad_correo);
            lblNombreHijo=itemView.findViewById(R.id.item_Pad_Familiar);
            lblMatricula=itemView.findViewById(R.id.item_Pad_matricula);
            lblNombreTutor=itemView.findViewById(R.id.item_Pad_tutor);

        }
    }
}
