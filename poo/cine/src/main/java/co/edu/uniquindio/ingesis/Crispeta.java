package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.exceptions.CantidadInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.NombreInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.PrecioInvalidoException;

import java.util.Objects;

public class Crispeta extends Producto{
    private TamanioCrispeta tamanio;

    public Crispeta(String nombre, float precio, TamanioCrispeta tamanio)
            throws NombreInvalidoException, PrecioInvalidoException, CantidadInvalidoException {
        super(nombre, precio);
        this.tamanio = Objects.requireNonNull(tamanio,"Se debe ingresar un tamaño");
    }

    public TamanioCrispeta getTamanio() {
        return tamanio;
    }
}
