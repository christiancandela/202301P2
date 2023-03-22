package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.exceptions.NombreInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.PrecioInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    /**
     * Nombre   Precio  Resultado
     * gaseosa  3500    ok
     * null     -1      error
     * null     3500    error
     * gaseosa  -1      error
     * "  "     3500    error
     */


    @Test
    void test01() throws Exception {
        Producto p = new Producto("gaseosa",3500);
    }

    @Test
    void test02()  {
        assertThrows( Exception.class, ()->new Producto(null,-1));
    }

    @Test
    void test03()  {
        assertThrows( NombreInvalidoException.class, ()->new Producto(null,3500));
    }

    @Test
    void test04()  {
        assertThrows( PrecioInvalidoException.class, ()->new Producto("gaseosa",-1));
    }

    @Test
    void test05()  {
        assertThrows( NombreInvalidoException.class, ()->new Producto("   ",3500));
    }
}