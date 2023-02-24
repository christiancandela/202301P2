package co.edu.uniquindio.ingesis;

import java.util.Objects;

public class Usuario {
    private final String nombre;
    private final String cedula;

    public Usuario(String nombre, String cedula) {

        this.nombre = Objects.requireNonNull(nombre,"El nombre es requerido");
        if( nombre.isBlank() ){
            throw new RuntimeException("El nombre es requerido");
        }
        this.cedula = Objects.requireNonNull(cedula,"La cédula es requirida");
        if( cedula.isBlank() ){
            throw new RuntimeException("La cédula es requirida");
        }
        Integer.parseInt(cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }
}
