package com.softandino.android.sobreruedas.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.softandino.android.sobreruedas.R;
import com.softandino.android.sobreruedas.dto.RodadaDTO;

import java.util.HashMap;
import java.util.Map;

public class CrearRodadaActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseReference mRootReference;
    Button mButtonSubirDatosFirebase;
    EditText etRodada;
    EditText etDescripcion;
    EditText etEncargado;
    EditText etCosto;
    EditText etDias;
    EditText etClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_rodada);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mButtonSubirDatosFirebase = findViewById(R.id.btnSubirDatos);
        mButtonSubirDatosFirebase.setOnClickListener(this);
        etRodada = findViewById(R.id.etRodada);
        etDescripcion = findViewById(R.id.etdescripcion);
        etEncargado = findViewById(R.id.etEncargado);
        etCosto = findViewById(R.id.etCosto);
        etDias = findViewById(R.id.etDias);
        etClub = findViewById(R.id.etClub);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        solicitarDatosFirebase();



    }
    private void solicitarDatosFirebase() {
        mRootReference.child("Rodada").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(final DataSnapshot snapshot : dataSnapshot.getChildren()){

                    mRootReference.child("Rodada").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            RodadaDTO rodadaDTO = snapshot.getValue(RodadaDTO.class);
                            String rodada = rodadaDTO.getRodada();
                            String descripcion = rodadaDTO.getDescripcion();
                            String costo = rodadaDTO.getCosto();
                            String encargado = rodadaDTO.getEncargado();
                            String dias = rodadaDTO.getDias();
                            String club = rodadaDTO.getDias();

                            Log.e("rodada:",""+rodada);
                            Log.e("descripcion:",""+descripcion);
                            Log.e("costo:",""+costo);
                            Log.e("encargado:",""+encargado);
                            Log.e("dias:",""+dias);
                            Log.e("club:",""+club);
                            Log.e("Datos:",""+snapshot.getValue());
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });



                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void cargarDatosFirebase(String rodada, String descripcion, String encargado, String costo, String dias, String club) {

        Map<String, Object> datosRodada = new HashMap<>();
        datosRodada.put("rodada", rodada);
        datosRodada.put("descripcion", descripcion);
        datosRodada.put("encargado", encargado);
        datosRodada.put("costo", costo);
        datosRodada.put("dias", dias);
        datosRodada.put("club", club);

        mRootReference.child("Rodada").push().setValue(datosRodada);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnSubirDatos:

                String rodada = etRodada.getText().toString();
                String descripcion= etDescripcion.getText().toString();
                String encargado = etEncargado.getText().toString();
                String costo = etCosto.getText().toString();
                String dias = etDias.getText().toString();
                String club = etClub.getText().toString();
                cargarDatosFirebase(rodada, descripcion, encargado, costo,dias,club);
                break;
        }

    }
}
