package com.softandino.android.sobreruedas.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.softandino.android.sobreruedas.R;
import com.softandino.android.sobreruedas.dto.RodadaDTO;

public class DetalleRodadaActivity extends AppCompatActivity {


    private TextView club;
    private TextView valor;
    private TextView descripcion;
    private TextView fecha;
    private TextView encargado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_rodada);

        RodadaDTO rodada = (RodadaDTO) getIntent().getSerializableExtra(("detalle"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(rodada.getRodada());
        setSupportActionBar(toolbar);

        club = (TextView) findViewById(R.id.club);
        descripcion = (TextView) findViewById(R.id.descripcion);
        valor = (TextView) findViewById(R.id.costo);
        //fecha = (TextView) findViewById(R.id.fecha);
        //encargado = (TextView) findViewById(R.id.encargado);

        club.setText("Organizada Por : " + rodada.getClub());
        valor.setText(rodada.getCosto());
        descripcion.setText(rodada.getDescripcion());
        //fecha.setText(rodada.getDias());
        //encargado.setText(rodada.getEncargado());
    }

}
