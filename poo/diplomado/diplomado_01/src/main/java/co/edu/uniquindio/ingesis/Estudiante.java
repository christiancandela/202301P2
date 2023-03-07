package co.edu.uniquindio.ingesis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Estudiante {
    private final String nui;
    private String nombre;
    private String apellido;
    private String email;
    private Genero genero;

    private final List<Float> notas;

    public Estudiante(String nui, String nombre, String apellido, Genero genero) {
        this.nui = Objects.requireNonNull(nui,"El número de identificación es requerido");
        setNombre(nombre);
        setApellido(apellido);
        setGenero(genero);
        notas = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre,"El nombre es requerido");
    }

    public void setApellido(String apellido) {
        this.apellido = Objects.requireNonNull(apellido,"El apellido es requerido");
    }

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email,"El email es requerido");
        if(!email.matches("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+/[\\w-]+$")){
            throw new RuntimeException("Debe ingresar un email valido");
        }
    }

    public void setGenero(Genero genero) {
        this.genero = Objects.requireNonNull(genero,"Debe ingresar un genero");
    }

    public String getNui() {
        return nui;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Genero getGenero() {
        return genero;
    }

    public List<Float> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    public Float getNota(int index){
        return notas.get(index);
    }

    public void addNota(Float nota){
        notas.add(validarNota(nota));
    }

    public void setNota(int index,Float nota){
        notas.set(index,validarNota(nota));
    }

    public Float calcularDefinitiva(){
        return (float) notas.stream().mapToDouble(Float::doubleValue).average().orElse(Double.NaN);
    }

    public int numeroNotas(){
        return notas.size();
    }

    private Float validarNota(Float nota){
        Objects.requireNonNull(nota,"La nota no puede ser null");
        if( nota < 0 || nota > 5){
            throw new RuntimeException("No es una nota válida");
        }
        return nota;
    }
}
