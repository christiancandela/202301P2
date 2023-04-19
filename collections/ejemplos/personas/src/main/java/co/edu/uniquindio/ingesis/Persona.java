package co.edu.uniquindio.ingesis;

public class Persona {
    private final String cedula;
    private final String nombre;
    private final float peso;
    private final float estatura;

    private final int edad;

    private final Genero genero;

    public Persona(String cedula, String nombre, float peso, float estatura, int edad, Genero genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.genero = genero;
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

    public int getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return nombre + " Peso "+peso+" cedula "+cedula+" estatura "+estatura+" edad "+edad;
    }
}
