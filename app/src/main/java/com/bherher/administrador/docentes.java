package com.bherher.administrador;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bherher.administrador.adapter.AdapterDocente;
import com.bherher.administrador.modelo.MDocente;
import com.bherher.administrador.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.bherher.administrador.volley.API;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link docentes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class docentes extends Fragment {
    private EditText txtFiltro;
    private AdapterDocente adapter;
    private ArrayList<MDocente> lista;
    private Bundle paquete;
    private RecyclerView rec;
    private NavController navegador;
    private ImageView btnAgrgarTutorado;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtFiltro = view.findViewById(R.id.tut_txt_filtro);
        btnAgrgarTutorado=view.findViewById(R.id.tut_btn_addDocente);
        navegador = Navigation.findNavController(view);
        btnAgrgarTutorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicAddDoc();
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


        rec=view.findViewById(R.id.recycler_view_docentes);

        lista=llenadoDesdeBD();
    }

    private void clicAddDoc() {
        //navegador.navigate(R.id.action_frg_Tutorados_to_frg_AgregarTutorado);
    }

    private void buscador(String s) {
        ArrayList<MDocente> lista2 = new ArrayList<>();

        if (s != null && !s.isEmpty()) {
            // Convertimos 's' a minúsculas para una búsqueda más flexible
            String searchTerm = s.toLowerCase();

            for (MDocente gpo : lista) {
                // Verificamos que los valores no sean nulos antes de hacer contains()
                if ((gpo.getMatricula() != null && gpo.getMatricula().toLowerCase().contains(searchTerm)) ||
                        (gpo.getNombre() != null && gpo.getNombre().toLowerCase().contains(searchTerm)) ||
                        (gpo.getApp() != null && gpo.getApp().toLowerCase().contains(searchTerm)) ||
                        (gpo.getApm() != null && gpo.getApm().toLowerCase().contains(searchTerm))) {

                    lista2.add(gpo);
                }
            }
        }

        // Enviar la lista filtrada al adaptador
        adapter.filtro(lista2);
    }


    private ArrayList<MDocente> llenadoDesdeBD() {
        ArrayList<MDocente> lista=new ArrayList<MDocente>();

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
        StringRequest solicitud= new StringRequest(Request.Method.POST,API.LISTAR_DOCENTE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();//apaga el cuadro de dialogo
                        try {
                            //LEER AQUI EL CONTENIDO DE LA VARIABLE response

                            JSONObject contenido = new JSONObject(response);
                            JSONArray array=contenido.getJSONArray("contenido");
                            MDocente obj=new MDocente();
                            for (int i = 0; i < array.length(); i++) {
                                obj=new MDocente();
                                JSONObject pos=new JSONObject(array.getString(i));


                                obj.setNombre(pos.getString("nombre")+" "+pos.getString("app") + " "+
                                        pos.getString("apm"));
                                obj.setCorreo(pos.getString("correo"));
                                obj.setMatricula(pos.getString("matricula"));

                                //   obj.setIdGrupo(pos.getInt("idGrupo"));
                                // obj.setNombreCorto(pos.getString("nombreCorto"));
                                obj.setClave(pos.getString("idClave"));

                                obj.setEdo(pos.getString("edo"));
                                obj.setMuni(pos.getString("muni"));
                                obj.setCol(pos.getString("col"));
                                obj.setGen(pos.getString("gen"));
                                obj.setContrasenia(pos.getString("contrasenia"));
                                obj.setIdDocente(pos.getInt("idDocente"));

                                lista.add(obj);
                            }

                            rec.setHasFixedSize(true);
                            rec.setLayoutManager(new LinearLayoutManager(getContext()));
                            adapter=new AdapterDocente(lista);
                            rec.setAdapter(adapter);



                        }catch (Exception ex){
                            //DETECTA ERRORES EN LA LECTURA DEL ARCHIVO JSON

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
                param.put("id","1");
                param.put("clave","TO1");
                return param;
            }
        };
        //ENVIA LA SOLICITUD
        colaDeSolicitudes.add(solicitud);


        return lista;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public docentes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment docentes.
     */
    // TODO: Rename and change types and number of parameters
    public static docentes newInstance(String param1, String param2) {
        docentes fragment = new docentes();
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
        return inflater.inflate(R.layout.fragment_docentes, container, false);
    }
}