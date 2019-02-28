package com.example.jan.restaurantapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrearReservaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrearReservaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrearReservaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText fecha = null;
    EditText comensales = null;
    EditText nombre = null;
    EditText telefono = null;
    EditText comentarios = null;
    Button sendBtn = null;
    private OnFragmentInteractionListener mListener;

    public CrearReservaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrearReservaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrearReservaFragment newInstance(String param1, String param2) {
        CrearReservaFragment fragment = new CrearReservaFragment();
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

        View view = inflater.inflate(R.layout.fragment_reservas, container, false);

        fecha = view.findViewById(R.id.fecha);
        comensales = view.findViewById(R.id.comensales);
        nombre = view.findViewById(R.id.nombre);
        telefono = view.findViewById(R.id.telefono);
        comentarios = view.findViewById(R.id.comentarios);
        sendBtn = view.findViewById(R.id.sendBtn);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reservas = database.getReference().child("reservas");
                DatabaseReference reserva = reservas.child(UUID.randomUUID().toString());

                DatabaseReference fechaFB = reserva.child("fecha");
                DatabaseReference comensalesFB = reserva.child("comensales");
                DatabaseReference nombreFB = reserva.child("nombre");
                DatabaseReference telefonoFB = reserva.child("telefono");
                DatabaseReference comentariosFB = reserva.child("comentarios");

                String fechaText = fecha.getText().toString();
                String comensalesText = comensales.getText().toString();
                String nombreText = nombre.getText().toString();
                String telefonoText = telefono.getText().toString();
                String comentariosText = comentarios.getText().toString();

                fechaFB.setValue(fechaText);
                comensalesFB.setValue(comensalesText);
                nombreFB.setValue(nombreText);
                telefonoFB.setValue(telefonoText);
                comentariosFB.setValue(comentariosText);

                mListener.pasarALista();

                fecha.setText("");
                comensales.setText("");
                nombre.setText("");
                telefono.setText("");
                comentarios.setText("");
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.pasarALista();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void pasarALista();
    }
}
