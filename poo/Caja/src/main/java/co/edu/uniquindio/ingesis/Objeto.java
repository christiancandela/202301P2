package co.edu.uniquindio.ingesis;

import java.util.Objects;

public class Objeto {
    private String nombre;
    private float peso;

    public Objeto(String nombre, float peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre,"El nombre no puede ser nulo");
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        if( peso < 0 ){
            throw new RuntimeException("El peso no puede ser negativo");
        }
        this.peso = peso;
    }
}
