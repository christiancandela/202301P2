package co.edu.uniquindio.ingesis;

import static co.edu.uniquindio.ingesis.TipoPago.*;
import static co.edu.uniquindio.ingesis.TipoSilla.*;

public class Main {
    public static void main(String[] args)  {

        try {
            Silla nuevaSilla = new Silla(GENERAL,"");
            ;
            ;
        } catch (Throwable e) {
            ;
            ;
            e.printStackTrace();
            System.err.println("Ocurrio un error inesperado");
            System.exit(-1);
            //throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}