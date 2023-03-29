package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {

    @Test
    void calcularArea() throws Exception {
        Figura circulo = new Circulo(3f);
        System.out.println( "Area "+circulo.calcularArea()  + " Clase "+circulo.getClass().getName());

        Figura anonima = new Figura(){
            @Override
            public float calcularArea() {
                return 0;
            }
        };

        System.out.println( "Area "+anonima.calcularArea() + " Clase "+anonima.getClass().getName());

    }

    @Test
    void test02() throws Exception {
        Figura circulo = new Circulo(3f);
        imprimirArea(circulo);

        float lado = 3f;
        imprimirArea( ()->{
            return lado * lado;
        }
        );
    }

    public void imprimirArea(Figura figura){
        System.out.println( "El area es"+figura.calcularArea() + " Clase "+figura.getClass().getName());
    }

    public void test03() throws Exception {
        List<Figura> figuras = new ArrayList<>();
        Figura circulo = new Circulo(3f);
        Figura circulo2 = new Circulo(1f);
        Figura circulo4 = new Circulo(5f);
        figuras.add( circulo );
        figuras.add( circulo2 );
        figuras.add( circulo4 );
        figuras.add( ()->9f );

        var listaOrdenada1 = figuras.stream()
                .sorted( new ComparadorFiguras() )
                .collect(Collectors.toList());
        var listaOrdenada = figuras.stream()
                .sorted( ( figura1, figura2)->
             Float.compare(figura1.calcularArea(), figura2.calcularArea())
         ).collect(Collectors.toList());
    }
}