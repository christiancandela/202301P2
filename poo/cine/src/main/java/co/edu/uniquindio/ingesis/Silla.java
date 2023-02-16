package co.edu.uniquindio.ingesis;

import java.util.Objects;

public class Silla {
    private final TipoSilla tipo;
    private EstadoSilla estado;
    private final String posicion;

    private String cliente;

    public Silla( TipoSilla tipoInicial , String posicionInicial ){
        tipo = Objects.requireNonNull(tipoInicial,"El tipo no puede ser nulo");
        posicion = Objects.requireNonNull(posicionInicial,"La posición no puede ser nulo");
        estado = EstadoSilla.DISPONIBLE;
    }

    public TipoSilla getTipo() {
        return tipo;
    }
}
