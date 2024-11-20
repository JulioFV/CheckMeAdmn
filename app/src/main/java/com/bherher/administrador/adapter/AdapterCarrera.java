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
import com.bherher.administrador.modelo.MCarrera;

import java.util.ArrayList;


public class AdapterCarrera extends RecyclerView.Adapter<AdapterCarrera.ViewHolder> {

    private ArrayList<MCarrera> lista;
    private Bundle paquete;

    @NonNull
    @Override
    public AdapterCarrera.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrera,null,false);
        return new AdapterCarrera.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCarrera.ViewHolder holder, int position) {

        MCarrera mCarr = lista.get(position);

        holder.txtMateria.setText(mCarr.getIdAsignatura()+"");
        holder.txtClave.setText(mCarr.getClave()+"");
        holder.txtCarrera.setText(mCarr.getClave()+"");
        holder.txtnomLarg.setText(mCarr.getClave()+"");
        holder.txtnomCort.setText(mCarr.getClave()+"");
        paquete = new Bundle();



    }

    @Override
    public int getItemCount() { return lista.size();}
    public void filtro(ArrayList<MCarrera> filtrados){
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
