package com.example.luismartinez.manejandousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.luismartinez.manejandousuario.Model.BdStatic;
import com.example.luismartinez.manejandousuario.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MostrarUsuariosListaActivity extends AppCompatActivity {
    private ListView lvUsuarios;
    private ArrayAdapter<String> adaptadorUsu;

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios_lista);

        lvUsuarios = (ListView) findViewById(R.id.listVMostrarUsuarios);
        btnVolver = (Button) findViewById(R.id.btnVVolverDesdeLista);

        List<String> nombres = new ArrayList<>();//Tal cual 200 100 lucas
        for(Usuario u: BdStatic.listaUsus){
            nombres.add(u.getNombre()+" "+u.getApellido()+" "+u.getEdad());
        }

        adaptadorUsu = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        lvUsuarios.setAdapter(adaptadorUsu);

        init();
    }

    private void init() {
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
