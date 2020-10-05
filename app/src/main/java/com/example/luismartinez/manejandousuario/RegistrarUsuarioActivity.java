package com.example.luismartinez.manejandousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luismartinez.manejandousuario.Model.BdStatic;
import com.example.luismartinez.manejandousuario.Model.Usuario;

public class RegistrarUsuarioActivity extends AppCompatActivity {
    private EditText txtCNombre, txtCApellido, txtCRut, txtCEdad;
    private TextView lblCCantidadUsus;
    private Switch swCSexo;
    private Spinner spnCDeporteF;
    private Button btnCRegistrar, btnCVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        txtCNombre = (EditText) findViewById(R.id.txtEdVNombreRegistro);
        txtCApellido = (EditText) findViewById(R.id.txtEdVApellidoRegistro);
        txtCRut = (EditText) findViewById(R.id.txtEdVRutRegistro);
        txtCEdad = (EditText) findViewById(R.id.txtEdVEdadRegistro);

        lblCCantidadUsus = (TextView) findViewById(R.id.lblVCantidadUsus);

        swCSexo = (Switch) findViewById(R.id.swtVSexoRegistro);

        spnCDeporteF = (Spinner) findViewById(R.id.spnVDeporteRegistro);

        btnCRegistrar = (Button) findViewById(R.id.btnVRegistrarRegistro);
        btnCVolver = (Button) findViewById(R.id.btnVVolverDesdeRegistroUsu);

        lblCCantidadUsus.setText(String.valueOf(BdStatic.listaUsus.size()));
        init();

    }

    private void init() {
        btnCRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, apellido, rut, deporteF;
                int edad;
                boolean sexo;

                nombre = txtCNombre.getText().toString();
                apellido = txtCApellido.getText().toString();
                rut = txtCRut.getText().toString();
                edad = Integer.parseInt(txtCEdad.getText().toString());

                if(swCSexo.isChecked()){
                    sexo = true;
                }else{
                    sexo = false;
                }

                deporteF = spnCDeporteF.getSelectedItem().toString();

                System.out.println(nombre+apellido+rut+edad+sexo+deporteF);

                Usuario u = new Usuario(nombre,apellido,rut,edad,sexo,deporteF);
                BdStatic.listaUsus.add(u);

                lblCCantidadUsus.setText(String.valueOf(BdStatic.listaUsus.size()));

                resetCampos();
                enviarMensaje("Usuario Registrado");
            }
        });

        btnCVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void resetCampos() {
        txtCNombre.setText("");
        txtCApellido.setText("");
        txtCRut.setText("");
        txtCEdad.setText("");
        swCSexo.setChecked(false);
        spnCDeporteF.setSelection(0);
    }

    private void enviarMensaje(String mensaje){
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
