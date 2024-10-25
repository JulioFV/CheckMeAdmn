package com.bherher.administrador;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Inicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Inicio extends Fragment {
    private CardView btnCarreras, btnDocentes, btnEstudiantes, btnPadres, btnAsignaturas, btnPeriodos;
    private NavController navigation;
    private ImageView btnConf;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Inicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Inicio.
     */
    // TODO: Rename and change types and number of parameters
    public static Inicio newInstance(String param1, String param2) {
        Inicio fragment = new Inicio();
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
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnAsignaturas=view.findViewById(R.id.adm_card_asignaturas);
        btnCarreras=view.findViewById(R.id.adm_card_carreras);
        btnDocentes=view.findViewById(R.id.adm_card_Docentes);

        btnEstudiantes=view.findViewById(R.id.adm_card_Estudiantes);
        btnPadres=view.findViewById(R.id.adm_card_papas);
        btnPeriodos=view.findViewById(R.id.adm_card_periodos);
        btnConf=view.findViewById(R.id.config_administrador);
        navigation= Navigation.findNavController(view);

        btnAsignaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicAsignaturas();
            }
        });
        btnPeriodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicPeriodos();

            }
        });
        btnPadres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicPadres();
            }
        });

        btnEstudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicEstudiantes();
            }
        });

        btnCarreras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicCarreras();
            }
        });
        btnDocentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicDocentes();
            }
        });

    }

    private void clicDocentes() {

        navigation.navigate(R.id.action_inicio_to_docentes);
    }

    private void clicCarreras() {

        navigation.navigate(R.id.action_inicio_to_carreras);
    }



    private void clicEstudiantes() {

        navigation.navigate(R.id.action_inicio_to_estudiantes);
    }

    private void clicPadres() {

        navigation.navigate(R.id.action_inicio_to_padres);
    }

    private void clicPeriodos() {

        navigation.navigate(R.id.action_inicio_to_periodos);
    }

    private void clicAsignaturas() {

        navigation.navigate(R.id.action_inicio_to_asignaturas);
    }

}