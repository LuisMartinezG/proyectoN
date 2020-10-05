package com.example.luismartinez.manejandousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luismartinez.manejandousuario.Model.BdStatic;
import com.example.luismartinez.manejandousuario.Model.Usuario;

public class MostrarUsuariosActivity extends AppCompatActivity {
    private TextView lblTiulo, lblNombre, lblApellido, lblRut, lblEdad, lblSexo, lblDeporteF, lblMinLista, lblActualLista, lblMaxLista;
    private Button btnAnterior, btnSiguiente, btnVolver;
    private int numUsuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios);

        lblTiulo = (TextView) findViewById(R.id.lblVTituloMostrarUsuario);
        lblNombre = (TextView) findViewById(R.id.lblVMostrarNombre);
        lblApellido = (TextView) findViewById(R.id.lblVMostrarApellido);
        lblRut = (TextView) findViewById(R.id.lblVMostrarRut);
        lblEdad = (TextView) findViewById(R.id.lblVMostrarEdad);
        lblSexo = (TextView) findViewById(R.id.lblVMostrarSexo);
        lblDeporteF = (TextView) findViewById(R.id.lblVMostrarDeporteF);

        lblMinLista = (TextView) findViewById(R.id.lblVMinLista);
        lblActualLista = (TextView) findViewById(R.id.lblVActualLista);
        lblMaxLista = (TextView) findViewById(R.id.lblVMaxLista);

        btnAnterior = (Button) findViewById(R.id.btnVAnteriorUsuario);
        btnSiguiente = (Button) findViewById(R.id.btnVSiguienteUsuario);
        btnVolver = (Button) findViewById(R.id.btnVVolverDesdeMostrarUsu);

        if(BdStatic.listaUsus.size() == 0){
            lblTiulo.setText("Sin Registros");
            lblMinLista.setText("0");
            lblActualLista.setText("0");
            lblMaxLista.setText("0");
        }else{
            llenarUsuario(BdStatic.listaUsus.get(0));
            lblMinLista.setText("1");
            lblActualLista.setText("1");
            lblMaxLista.setText(String.valueOf(BdStatic.listaUsus.size()));
            numUsuarioActual = 1;
        }

        init();

    }

    private void init() {
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numUsuarioActual>1){
                    numUsuarioActual--;
                    llenarUsuario(BdStatic.listaUsus.get(numUsuarioActual-1));
                    lblActualLista.setText(String.valueOf(numUsuarioActual));
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numUsuarioActual<BdStatic.listaUsus.size()){
                    llenarUsuario(BdStatic.listaUsus.get(numUsuarioActual));
                    numUsuarioActual++;
                    lblActualLista.setText(String.valueOf(numUsuarioActual));
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void llenarUsuario(Usuario u){
        lblTiulo.setText("Usuario: "+u.getNombre());
        lblNombre.setText(u.getNombre());
        lblApellido.setText(u.getApellido());
        lblRut.setText(u.getRut());
        lblEdad.setText(String.valueOf(u.getEdad()));
        if(u.isSexo()){
            lblSexo.setText("Mujer");
        }else{
            lblSexo.setText("Hombre");
        }
        lblDeporteF.setText(u.getDeporteF());

    }
}
