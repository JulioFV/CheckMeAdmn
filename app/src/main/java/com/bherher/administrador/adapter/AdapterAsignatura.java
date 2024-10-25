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

import java.util.ArrayList;

public class AdapterAsignatura extends RecyclerView.Adapter<AdapterAsignatura.ViewHolder> {

    private ArrayList<MAsignatura> lista;
    private Bundle paquete;

    public AdapterAsignatura(ArrayList<MAsignatura> lista){
        this.lista = lista;
    }

    @NonNull
    @Override

    public AdapterAsignatura.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asignatura,null,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAsignatura.ViewHolder holder, int position) {
        MAsignatura mAsig = lista.get(position);

        holder.txtMateria.setText(mAsig.getIdAsignatura()+"");
        holder.txtClave.setText(mAsig.getClave()+"");
        holder.txtCarrera.setText(mAsig.getClave()+"");
        holder.txtnomLarg.setText(mAsig.getClave()+"");
        holder.txtnomCort.setText(mAsig.getClave()+"");
        paquete = new Bundle();


    }

    @Override
    public int getItemCount() { return lista.size();}
    public void filtro(ArrayList<MAsignatura> filtrados){
        this.lista = filtrados;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtClave, txtMateria, txtnomCort, txtnomLarg, txtCarrera;
        private ImageView btnEliminar, btnEditar;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            btnEliminar=itemView.findViewById(R.id.item_asig_eliminar);
            btnEditar=itemView.findViewById(R.id.item_asig_editar);
            txtClave=itemView.findViewById(R.id.item_Asig_clave);
            txtnomCort=itemView.findViewById(R.id.item_Asig_NomCorto);
            txtMateria=itemView.findViewById(R.id.item_Asig_materia);
            txtnomLarg=itemView.findViewById(R.id.item_Asig_NomLargo);
            txtCarrera=itemView.findViewById(R.id.item_Asig_carrerar);

        }
    }
}
