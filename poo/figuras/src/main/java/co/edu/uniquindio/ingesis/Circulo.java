package co.edu.uniquindio.ingesis;

public class Circulo implements Figura{
    private final float radio;

    public Circulo(float radio) throws Exception {
        if( radio <= 0 ){
            throw new Exception("El radio debe ser mayor a 0");
        }
        this.radio = radio;
    }

    @Override
    public float calcularArea() {
        return (float) (radio * radio * Math.PI);
    }
}
