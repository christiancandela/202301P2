package co.edu.uniquindio.ingesis;

import java.util.Comparator;

public class ComparadorFiguras implements Comparator<Figura> {
    @Override
    public int compare(Figura figura1, Figura figura2) {
        return Float.compare(figura1.calcularArea(), figura2.calcularArea());
    }
}
