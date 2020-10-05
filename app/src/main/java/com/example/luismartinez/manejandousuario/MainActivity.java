package com.example.luismartinez.manejandousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button btnCRegistrarUsuarios, btnCMostrarUsuarios, btnCListarUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCRegistrarUsuarios = (Button) findViewById(R.id.btnVRegistrarUsuario);
        btnCMostrarUsuarios = (Button) findViewById(R.id.btnVMostrarUsuarios);
        btnCListarUsuarios = (Button) findViewById(R.id.btnVListarUsuarios);

        init();
    }

    private void init() {
        btnCRegistrarUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistrarUsuarioActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnCMostrarUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MostrarUsuariosActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnCListarUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MostrarUsuariosListaActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
