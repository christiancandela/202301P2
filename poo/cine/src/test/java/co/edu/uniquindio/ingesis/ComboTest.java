package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.exceptions.CantidadInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.NombreInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.PrecioInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboTest {

    /**
     * Producto         Lista       Resultado
     * gaseosa          {}          {gaseosa}
     * crispeta         {gaseosa}   {gaseosa,crispeta}
     * null             {}          Exception
     * gaseosa          {gaseosa}   {gaseosa,gaseosa}
     */

    @Test
    void test01() throws NombreInvalidoException, PrecioInvalidoException, CantidadInvalidoException {
        Combo combo = new Combo("Mi combo",15000);
        Producto gaseosa = new Gaseosa("Mi tierra",7500,250);
        combo.addProducto(gaseosa);
        assertTrue( combo.getProductos().contains(gaseosa) );
    }

    @Test
    void test02() throws NombreInvalidoException, PrecioInvalidoException, CantidadInvalidoException {
        Combo combo = new Combo("Mi combo",15000);
        Producto gaseosa = new Gaseosa("Mi tierra",7500,250);
        combo.addProducto(gaseosa);
        assertTrue( combo.getProductos().contains(gaseosa) );

        Producto crispeta = new Crispeta("Crispeta sal pequeña",8000,TamanioCrispeta.PEQUENIO);
        combo.addProducto(crispeta);

        assertTrue( combo.getProductos().contains(crispeta) );

        assertEquals(2,combo.getProductos().size());
    }

    @Test
    void test03() throws NombreInvalidoException, PrecioInvalidoException, CantidadInvalidoException {
        Combo combo = new Combo("Mi combo",15000);
        assertThrows(Exception.class,()-> combo.addProducto(null));
        assertTrue( combo.getProductos().isEmpty() );
    }

    @Test
    void test04() throws NombreInvalidoException, PrecioInvalidoException, CantidadInvalidoException {
        Combo combo = new Combo("Mi combo",15000);
        Producto gaseosa = new Gaseosa("Mi tierra",7500,250);
        combo.addProducto(gaseosa);
        assertTrue( combo.getProductos().contains(gaseosa) );

        Producto gaseosa2 = new Gaseosa("Quindianita",10500,250);
        combo.addProducto(gaseosa2);

        assertTrue( combo.getProductos().contains(gaseosa2) );

        assertEquals(2,combo.getProductos().size());
    }

    @Test
    void test05() throws NombreInvalidoException, PrecioInvalidoException, CantidadInvalidoException {
        Combo combo = new Combo("Mi combo",15000);
        Producto gaseosa = new Gaseosa("Mi tierra",7500,250);
        combo.addProducto(gaseosa);
        assertTrue( combo.getProductos().contains(gaseosa) );

        assertEquals(1,combo.getProductos().size());

        combo.addProducto(gaseosa);

        assertTrue( combo.getProductos().contains(gaseosa) );

        assertEquals(2,combo.getProductos().size());
    }
}