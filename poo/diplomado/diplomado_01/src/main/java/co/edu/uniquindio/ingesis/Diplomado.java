package co.edu.uniquindio.ingesis;

import java.time.LocalDate;
import java.util.*;

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
//        for (Estudiante estudiante:estudiantes ) {
//            if(estudiante.getNui().equals(nui) ){
//                return Optional.of(estudiante);
//            }
//        }
        return estudiantes.stream().filter( (estudiante)->estudiante.getNui().equals(nui) ).findFirst();
    }

    public void registrarEstudiante(String nui, String nombre, String apellido, Genero genero){
        estudiantes.add(new Estudiante( nui,  nombre,  apellido,  genero));
    }

    public void registrarNota(String nui,Float nota) throws Exception {
        Objects.requireNonNull(nui,"El número de identificación es requerido");
        var estudiante = getEstudiante(nui);
        if( estudiante.isEmpty() ){
            throw new Exception("El estudiante no esta registrado");
        }
        estudiante.ifPresent( e->e.addNota(nota) );
    }

    public void cancelarInscripcion(String nui) throws Exception {
        Estudiante estudiante = getEstudiante(nui).orElseThrow(()->new Exception("Estudiante no encontrado"));
        if( estudiante.numeroNotas() >0 ){
            throw new Exception("No se puede cancelar la inscripción de un estudiante con notas");
        }
    }

    public DoubleSummaryStatistics getEstadisticas(int indiceParcial, Genero genero){
        return estudiantes.stream().filter( estudiante -> estudiante.getGenero().equals(genero) )
                .mapToDouble(estudiante -> estudiante.getNota(indiceParcial))
                .summaryStatistics();
    }
}
