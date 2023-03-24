package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.exceptions.NombreInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.PrecioInvalidoException;

import java.util.Objects;

public class Producto implements Comparable<Producto> {
    private final String nombre;
    private float precio;

    public Producto(String nombre, float precio) throws NombreInvalidoException,PrecioInvalidoException {
        this.nombre = validarNombre( nombre );
        this.precio = validarPrecio(precio);
    }


    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) throws Exception {
        this.precio = validarPrecio(precio);
    }

    private String validarNombre(String nombre) throws NombreInvalidoException {
        if( nombre == null ||nombre.isBlank() ){
            throw new NombreInvalidoException("Debe ingresar un nombre");
        }
        return nombre;
    }

    private float validarPrecio(float precio) throws PrecioInvalidoException {
        if( precio < 0 ){
            throw new PrecioInvalidoException("El precio debe ser mayor o igual a 0");
        }
        return precio;
    }

    @Override
    public int compareTo(Producto otroPructo) {
        return Float.compare(precio, otroPructo.getPrecio());
        //return -1* nombre.compareTo(otroPructo.getNombre() );
    }
}
