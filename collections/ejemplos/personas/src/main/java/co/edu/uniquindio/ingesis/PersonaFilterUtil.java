package co.edu.uniquindio.ingesis;

import java.util.function.Predicate;

public class PersonaFilterUtil {
    public static boolean mayorEdad(Persona persona){
        return persona.getEdad() >= 18;
    }

    public static Predicate<Persona> mayorA(int edad){
        return persona -> persona.getEdad() > edad;
    }

    public static Predicate<Persona> filtarPorGenero(Genero genero ){
        return persona -> persona.getGenero() == genero;
    }

    public static Predicate<Persona> filtar(Integer edad,Genero genero){
        Predicate<Persona> predicate = persona -> true;
        if( edad != null ){
            predicate = predicate.and(mayorA(edad));
        }
        if ( genero != null ){
            predicate = predicate.and(filtarPorGenero(genero));
        }
        return predicate;
    }
}
