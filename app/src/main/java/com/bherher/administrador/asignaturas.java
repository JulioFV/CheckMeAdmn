package com.bherher.administrador;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bherher.administrador.adapter.AdapterAsignatura;
import com.bherher.administrador.modelo.MAsignatura;
import com.bherher.administrador.volley.VolleySingleton;
import com.bherher.administrador.volley.API;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link asignaturas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class asignaturas extends Fragment {
    private ImageView btnRegresar;
    private ArrayList<MAsignatura> lista;
    private AdapterAsignatura adapter;
    private NavController navigation;
    private RecyclerView rec;
    private String obj;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public asignaturas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment asignaturas.
     */
    // TODO: Rename and change types and number of parameters
    public static asignaturas newInstance(String param1, String param2) {
        asignaturas fragment = new asignaturas();
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
        return inflater.inflate(R.layout.fragment_asignaturas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rec=view.findViewById(R.id.frg_recycler_asignaturas);
        lista=llenadoDesdeBD();
        super.onViewCreated(view, savedInstanceState);
        btnRegresar=view.findViewById(R.id.regreso_administrador);
        navigation= Navigation.findNavController(view);



        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicRegresar();
            }
        });
    }

    private ArrayList<MAsignatura> llenadoDesdeBD() {
        ArrayList<MAsignatura> lista=new ArrayList<MAsignatura>();

        //Crea un AlertDialog
        AlertDialog.Builder msg = new AlertDialog.Builder(this.getContext());

        // Crear un ProgressBar
        ProgressBar progressBar = new ProgressBar(this.getContext());
        progressBar.setIndeterminate(true); // Estilo de carga indeterminada

        // Crear el AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Por favor, espera");
        builder.setMessage("Conectandose con el servidor...");
        builder.setView(progressBar);
        builder.setCancelable(false); // Evitar que se pueda cancelar
        AlertDialog dialog = builder.create();
        dialog.show();

        RequestQueue colaDeSolicitudes= VolleySingleton.getInstance(this.getContext()).getRequestQueue();
        StringRequest solicitud= new StringRequest(Request.Method.POST,API.LISTAR_ASIGNATURA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();//apaga el cuadro de dialogo
                        try {
                            //LEER AQUI EL CONTENIDO DE LA VARIABLE response

                            JSONObject contenido = new JSONObject(response);
                            JSONArray array=contenido.getJSONArray("contenido");
                            MAsignatura obj=new MAsignatura();
                            for (int i = 0; i < array.length(); i++) {
                                obj=new MAsignatura();
                                Log.e("objeto",response);
                                JSONObject pos=new JSONObject(array.getString(i));
                                obj.setIdAsignatura(pos.getInt("idAsignatura"));
                                obj.setNombreCorto(pos.getString("nombreCorto"));
                                obj.setNombreLargo(pos.getString("nombreLargo"));
                                obj.setClave(pos.getString("clave"));
                                obj.setIdCarrera(pos.getInt("idCarrera"));

                              //  obj.setIdAsignatura(pos.getInt("idAsignatura"));



                                lista.add(obj);
                            }

                            rec.setHasFixedSize(true);
                            rec.setLayoutManager(new LinearLayoutManager(getContext()));
                            adapter=new AdapterAsignatura(lista);
                            rec.setAdapter(adapter);

                        }catch (Exception ex){
                            //DETECTA ERRORES EN LA LECTURA DEL ARCHIVO JSON
                            Log.e("ërror",ex.getMessage());
                            msg.setTitle("Error");
                            msg.setMessage("La información no se pudo leer");
                            msg.setPositiveButton("Aceptar",null);
                            AlertDialog dialog=msg.create();
                            msg.show();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Log.e("nose conecta",error.getMessage());
                // DETECTA ERRORES EN LA COMUNICACIÓN
                msg.setTitle("Error");
                msg.setMessage("No se pudo conectar con el servidor");
                msg.setPositiveButton("Aceptar",null);
                AlertDialog dialog=msg.create();
                msg.show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> param=new HashMap<String,String>();
                //PASA PARAMETROS A LA SOLICITUD
               param.put("id",4+"");
                return param;
            }
        };
        //ENVIA LA SOLICITUD
        colaDeSolicitudes.add(solicitud);


        return lista;
    }

    private void clicRegresar() {
        navigation.navigate(R.id.inicio);
    }
}