package co.edu.uniquindio.ingesis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Diplomado {
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final Float costo;
    private final List<Estudiante> estudiantes;

    public Diplomado(String nombre, LocalDate fechaInicio, LocalDate fechaFin, Float costo) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Float getCosto() {
        return costo;
    }

    public List<Estudiante> getEstudiantes() {
        return Collections.unmodifiableList(estudiantes);
    }

    public Optional<Estudiante> getEstudiante(String nui){
        return estudiantes.stream().filter( e->e.getNui().equals(nui) ).findFirst();
    }

    public void registrarEstudiante(String nui, String nombre, String apellido, Genero genero){
        estudiantes.add(new Estudiante( nui,  nombre,  apellido,  genero));
    }

    public void registrarNota(String nui,Float nota){
        getEstudiante(nui).ifPresent( e->e.addNota(nota) );
    }
}
