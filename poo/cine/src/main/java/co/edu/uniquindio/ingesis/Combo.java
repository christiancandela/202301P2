package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.exceptions.NombreInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.PrecioInvalidoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Combo extends Producto{
    private final List<Producto> productos;

    public Combo(String nombre, float precio) throws NombreInvalidoException, PrecioInvalidoException {
        super(nombre, precio);
        productos = new ArrayList<>();
    }

    public void addProducto(Producto producto){
        Objects.requireNonNull(producto,"El producto no debe ser nulo");
        productos.add(producto);
        Collections.sort(productos);
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }
}
