package com.bherher.administrador;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bherher.administrador.adapter.AdapterDocente;
import com.bherher.administrador.modelo.MDocente;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link estudiantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class estudiantes extends Fragment {

    private EditText txtFiltro;
    private AdapterDocente adapter;
    private ArrayList<MDocente> lista;
    private Bundle paquete;
    private RecyclerView rec;
    private NavController navegador;
    private ImageView btnAgregarEstudiante;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle  savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
    txtFiltro = view.findViewById(R.id.Est_txt_filtro);
    btnAgregarEstudiante = view.findViewById(R.id.Est_btn_addEstudiante);
    navegador = Navigation.findNavController(view);
    btnAgregarEstudiante.setOnClickListener(new View.OnClickListener() {p
        @Override
        public void onClick(View v) {
            clicAddEst();
        }
    });
        txtFiltro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buscador(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        rec=view.findViewById(R.id.recycler_view_Estudiantes);

        lista=llenadoDesdeBD();
    }

    private void clicAddEst() {
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public estudiantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment estudiantes.
     */
    // TODO: Rename and change types and number of parameters
    public static estudiantes newInstance(String param1, String param2) {
        estudiantes fragment = new estudiantes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estudiantes, container, false);
    }
}