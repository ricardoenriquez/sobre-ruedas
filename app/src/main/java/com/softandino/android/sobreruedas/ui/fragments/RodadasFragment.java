package com.softandino.android.sobreruedas.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softandino.android.sobreruedas.R;
import com.softandino.android.sobreruedas.adapter.RodadasAdapter;
import com.softandino.android.sobreruedas.dto.RodadaDTO;
import com.softandino.android.sobreruedas.ui.DetalleRodadaActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RodadasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RodadasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RodadasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyckerRodada;
    ArrayList<RodadaDTO> listaRodadas;

    public RodadasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RodadasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RodadasFragment newInstance(String param1, String param2) {
        RodadasFragment fragment = new RodadasFragment();
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
        View vista = inflater.inflate(R.layout.fragment_rodadas, container, false);

        listaRodadas = new ArrayList();
        recyckerRodada = (RecyclerView) vista.findViewById(R.id.recyclerId);
        recyckerRodada.setLayoutManager(new LinearLayoutManager(getContext()));

        //AppDatabase database = AppDatabase.getInstance(getContext());
        //listaRodadas = Cast.castListRodadaEntityToDTO(database.rodadaDao().cargarRodada().getValue());
        listaRodadas.add(new RodadaDTO(2, "Bendicion Motera", "Rodada por buga todo el dia", "Ricardo Enriquez2", "40.000", "1", "Alianza Regional"));
        listaRodadas.add(new RodadaDTO(2, "Zipaquira", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));
        listaRodadas.add(new RodadaDTO(2, "Bendicion Motera2", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));
        listaRodadas.add(new RodadaDTO(2, "Bendicion Motera2", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));
        listaRodadas.add(new RodadaDTO(2, "Bendicion Motera2", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));
        listaRodadas.add(new RodadaDTO(2, "Bendicion Motera2", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));
        listaRodadas.add(new RodadaDTO(2, "Bendicion Motera2", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));
        listaRodadas.add(new RodadaDTO(2, "Bendicion Motera2", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));

        RodadasAdapter adapter = new RodadasAdapter(listaRodadas);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RodadaDTO rodadaSelected = listaRodadas.get(recyckerRodada.getChildAdapterPosition(v));

               // Toast.makeText(getContext(), rodadaSelected.getDescripcion(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),DetalleRodadaActivity.class);
                intent.putExtra("detalle", rodadaSelected);
                startActivity(intent);
            }
        });
        recyckerRodada.setAdapter(adapter);
        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        void onFragmentInteraction(Uri uri);
    }
}
