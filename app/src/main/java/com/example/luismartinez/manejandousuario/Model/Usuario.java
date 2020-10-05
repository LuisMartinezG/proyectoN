package com.example.luismartinez.manejandousuario.Model;

/**
 * Created by Luis Martinez on 20-09-2018.
 */

public class Usuario {
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;
    private boolean sexo;
    private String deporteF;

    public Usuario(String nombre, String apellido, String rut, int edad, boolean sexo, String deporteF) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.edad = edad;
        this.sexo = sexo;
        this.deporteF = deporteF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getDeporteF() {
        return deporteF;
    }

    public void setDeporteF(String deporteF) {
        this.deporteF = deporteF;
    }
}
