package com.softandino.android.sobreruedas.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.softandino.android.sobreruedas.MainActivity;
import com.softandino.android.sobreruedas.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mailET;
    private EditText pssET;
    private Button registroBtn;
    private Button loginBtn;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        mailET = findViewById(R.id.et_mail);
        pssET = findViewById(R.id.et_pss);
        registroBtn = findViewById(R.id.btn_registro);
        loginBtn = findViewById(R.id.btn_login);
        progressDialog = new ProgressDialog(this);

        registroBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    private void registrarUsuario() {
        final String mail = mailET.getText().toString().trim();
        String pss = pssET.getText().toString().trim();
        validarCampos(mail, pss);
        progressDialog.setMessage("Realizando el registro en linea");
        progressDialog.show();

        //Creando el usuario
        firebaseAuth.createUserWithEmailAndPassword(mail, pss).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Se ha registrado correctamente email " + mail, Toast.LENGTH_LONG).show();
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(LoginActivity.this, "El email ya se encuentra registrado", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "No se pudo registrar el email " + mail, Toast.LENGTH_LONG).show();
                    }
                }
                progressDialog.dismiss();
            }
        });

    }

    private void validarCampos(String mail, String pss) {
        if (TextUtils.isEmpty(mail)) {
            Toast.makeText(this, "Se debe ingrtesar un email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pss)) {
            Toast.makeText(this, "Se debe ingrtesar una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    private void logearUsuario() {
        final String mail = mailET.getText().toString().trim();
        String pss = pssET.getText().toString().trim();
        validarCampos(mail, pss);
        progressDialog.setMessage("Realizando consulta en linea");
        progressDialog.show();

        //loguear usuario
        firebaseAuth.signInWithEmailAndPassword(mail, pss).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Bienvenido" + mail, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    startActivity(intent);
                } else {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(LoginActivity.this, "Credenciales invalidas", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "No se pudo inciar sesión", Toast.LENGTH_LONG).show();
                    }
                }
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_registro:
                registrarUsuario();
                break;
            case R.id.btn_login:
                logearUsuario();
                break;
        }
    }
}
