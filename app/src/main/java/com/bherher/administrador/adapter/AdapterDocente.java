package com.bherher.administrador.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bherher.administrador.R;
import com.bherher.administrador.modelo.MCarrera;
import com.bherher.administrador.modelo.MDocente;

import java.util.ArrayList;

public class AdapterDocente extends RecyclerView.Adapter<AdapterDocente.ViewHolder> {
        private ArrayList<MDocente> lista;
        private Bundle paquete;
public AdapterDocente(ArrayList<MDocente> lista){
    this.lista =lista;
}

    @NonNull
    @Override
    public AdapterDocente.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_docentes,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDocente.ViewHolder holder, int position) {
                            MDocente mDocente=lista.get(position);
                            MDocente doc=lista.get(position);
                            holder.idDocente.setText(mDocente.getIdDocente()+"");
                            holder.lblNombre.setText(mDocente.getNombre()+"");
                            holder.lblCarrera.setText(mDocente.getCarrera()+"");
                            holder.lblPeriodo.setText(mDocente.getPeriodo()+"");
                            holder.lblGrpTuroado.setText(mDocente.getIdGrupo()+"");



                            paquete =new Bundle();

                            holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    paquete.putSerializable("objeto" , doc);
                                    clicEliminar(v);
                                }
                            });




    }
    private void clicEliminar(View v) {
        NavController nav = Navigation.findNavController(v);
        paquete.putInt("op",1);
        nav.navigate(R.id.action_inicio_to_docentes,paquete);
    }

    @Override
    public int getItemCount() {return lista.size();}
    public void filtro(ArrayList<MDocente>filtrados){
            this.lista=filtrados;
            notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView idDocente, lblNombre, lblCarrera, lblPeriodo, lblGrpTuroado;
        private ImageView btnEditar, btnEliminar;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            btnEliminar=itemView.findViewById(R.id.item_doc_eliminar);
            btnEditar=itemView.findViewById(R.id.item_doc_editar);
            idDocente=itemView.findViewById(R.id.item_Doc_clave);
            lblNombre=itemView.findViewById(R.id.item_doc_Nom);
            lblGrpTuroado=itemView.findViewById(R.id.item_Doc_tutorados);
            lblPeriodo=itemView.findViewById(R.id.item_Doc_Periodo);
            lblCarrera=itemView.findViewById(R.id.item_Doc_carrera);


        }
    }
}
