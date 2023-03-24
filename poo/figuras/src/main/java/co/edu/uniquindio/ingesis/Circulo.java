package co.edu.uniquindio.ingesis;

import java.awt.event.MouseAdapter;

public class Circulo implements Figura{
    private final float radio;

    public Circulo(float radio) {
        this.radio = radio;
    }

    @Override
    public float calcularArea() {
        return (float) (radio * radio * Math.PI);
    }
}
