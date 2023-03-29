package co.edu.uniquindio.ingesis;

public class Persona {
    private final String cedula;
    private final String nombre;
    private final float peso;
    private final float estatura;

    public Persona(String cedula, String nombre, float peso, float estatura) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.peso = peso;
        this.estatura = estatura;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPeso() {
        return peso;
    }

    public float getEstatura() {
        return estatura;
    }

    @Override
    public String toString() {
        return nombre + " Peso "+peso+" cedula "+cedula+" estatura "+estatura;
    }
}
