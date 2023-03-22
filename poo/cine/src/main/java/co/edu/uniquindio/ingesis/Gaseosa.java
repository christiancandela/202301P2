package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.exceptions.CantidadInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.NombreInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.PrecioInvalidoException;

public class Gaseosa extends Producto{
    private int cantidad;

    public Gaseosa(String nombre, float precio, int cantidad)
            throws NombreInvalidoException, PrecioInvalidoException, CantidadInvalidoException {
        super(nombre, precio);
        this.cantidad = validarCantidad(cantidad);
    }

    public int getCantidad() {
        return cantidad;
    }

    private int validarCantidad(int cantidad) throws CantidadInvalidoException {
        if( cantidad <= 0 ){
            throw new CantidadInvalidoException("La cantidad debe ser mayor a 0");
        }
        return cantidad;
    }
}
