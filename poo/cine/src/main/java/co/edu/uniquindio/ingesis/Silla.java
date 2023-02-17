package co.edu.uniquindio.ingesis;

import java.util.Objects;

public class Silla {
    private final TipoSilla tipo;
    private EstadoSilla estado;
    private final String posicion;

    private String cliente;

    public Silla( TipoSilla tipoInicial , String posicionInicial ) throws Exception {

        tipo = Objects.requireNonNull(tipoInicial,"El tipo no puede ser nulo");
        posicion = Objects.requireNonNull(posicionInicial,"La posición no puede ser nula");

        if( !validarPosicion(posicion) ){
            throw new Exception("La posición no es valida");
        }

        estado = EstadoSilla.DISPONIBLE;
    }

    private boolean validarPosicion(String posicion) {
        // TODO Construir metodo para validar la posición
        throw new RuntimeException("AUN NO SE HA IMPLEMENTADO");
    }

    public TipoSilla getTipo() {
        return tipo;
    }
}
