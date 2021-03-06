package com.softandino.android.sobreruedas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softandino.android.sobreruedas.R;
import com.softandino.android.sobreruedas.dto.RodadaDTO;

import java.util.ArrayList;


/**
 * Created by CHENAO on 13/07/2017.
 */

public class RodadasAdapter extends RecyclerView.Adapter<RodadasAdapter.RodadasViewHolder> implements View.OnClickListener {

    ArrayList<RodadaDTO> listaRodadas;
    View.OnClickListener lister;

    public RodadasAdapter(ArrayList<RodadaDTO> listaPersonaje) {
        this.listaRodadas = listaPersonaje;
    }

    @Override
    public RodadasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        view.setOnClickListener(this);
        return new RodadasViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RodadasViewHolder holder, int position) {
        holder.txtNombre.setText(listaRodadas.get(position).getRodada());
        holder.txtInformacion.setText(listaRodadas.get(position).getDescripcion());
        //holder.txtFecha.setText(listaRodadas.get(position).getDias());
        //holder.txtEncargado.setText(listaRodadas.get(position).getEncargado());
        holder.txtCosto.setText("$ " + listaRodadas.get(position).getCosto());
        //holder.foto.setImageResource(listaRodadas.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaRodadas.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.lister = listener;
    }

    @Override
    public void onClick(View view) {
        if (lister != null) {
            lister.onClick(view);
        }

    }

    public class RodadasViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtInformacion;
        TextView txtCosto;
        TextView txtFecha;
        TextView txtEncargado;
        ImageView foto;

        public RodadasViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.idNombre);
            txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            txtCosto = (TextView) itemView.findViewById(R.id.costo);
            txtFecha = (TextView) itemView.findViewById(R.id.fecha);
            txtEncargado = (TextView) itemView.findViewById(R.id.encargado);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}