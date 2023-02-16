package co.edu.uniquindio.ingesis;

import static co.edu.uniquindio.ingesis.TipoPago.*;
import static co.edu.uniquindio.ingesis.TipoSilla.*;

public class Main {
    public static void main(String[] args) {

        TipoPago tipo = PUNTOS;
        tipo = PSE;
        tipo = TARJETA;
        String a = "";
        Silla miSilla = new Silla(PREFERENCIAL,"K2");
        int[] arreglo = { 3,1,8,9 };

        System.out.println("Hello world!");
    }
}