package co.edu.uniquindio.ingesis;

public class CoparetorPersonaUtil {
    private CoparetorPersonaUtil() {
    }

    public static int compararPorNombre(Persona persona1, Persona persona2){
        return persona1.getNombre().compareTo(persona2.getNombre());
    }

    public static int compararPorCedula(Persona persona1, Persona persona2){
        return persona1.getCedula().compareTo(persona2.getCedula());
    }

    public static int compararPorEstatura(Persona persona1, Persona persona2){
        return Float.compare(persona1.getEstatura(), persona2.getEstatura());
    }

    public static int compararPorPeso(Persona persona1, Persona persona2){
        return Float.compare(persona1.getPeso(), persona2.getPeso());
    }
}
