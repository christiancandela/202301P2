package co.edu.uniquindio.ingesis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caja {
    private float capacidad;
    private List<Objeto> objetos;
    private Objeto[] objetos2;

    public Caja(float capacidad) {
        this.capacidad = capacidad;
        objetos = new ArrayList<>();
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    public List<Objeto> getObjetos() {
        return Collections.unmodifiableList(objetos);
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }
}
