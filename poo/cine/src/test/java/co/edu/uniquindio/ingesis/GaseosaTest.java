package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.exceptions.CantidadInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.NombreInvalidoException;
import co.edu.uniquindio.ingesis.exceptions.PrecioInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GaseosaTest {

    /**
     * Nombre   Precio      cantidad    Resultado
     * gaseosa  3500        250         ok
     * null     -1          250         error
     * null     3500        250         error
     * gaseosa  -1          250         error
     * "  "     3500        250         error
     * gaseosa  3500        0           ok
     */


    @Test
    void test01() throws Exception {
        Producto p = new Gaseosa("gaseosa",3500,250);
    }

    @Test
    void testError()  {
        Class[] exceptions = {Exception.class,NombreInvalidoException.class,PrecioInvalidoException.class,NombreInvalidoException.class, CantidadInvalidoException.class};
        String[] nombres ={null,null,"gaseosa","  ","gaseosa"};
        float[] precios={-1,3500,-1,3500,3500};
        int[] cantidades={250,250,250,250,0};
        for( int i = 0 ; i < cantidades.length ; i++ ){
            final String nombre = nombres[i];
            final float precio = precios[i];
            final int cantidad = cantidades[i];

            assertThrows( exceptions[i],
                    ()->new Gaseosa(nombre,precio,cantidad));
        }

    }

}