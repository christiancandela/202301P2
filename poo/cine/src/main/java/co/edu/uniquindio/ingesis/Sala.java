package co.edu.uniquindio.ingesis;

import java.util.ArrayList;
import java.util.Collection;

public class Sala {
    private final Collection<Silla> sillas;
    private final String nombre;

    public Sala(String nombre) {
        this.sillas = new ArrayList<>();
        this.nombre = nombre;
    }

    public void adicionarSilla(TipoSilla tipoSilla,String posicion) throws Exception {

        Silla silla = new Silla(tipoSilla,posicion);
        sillas.add(silla);
    }
}
