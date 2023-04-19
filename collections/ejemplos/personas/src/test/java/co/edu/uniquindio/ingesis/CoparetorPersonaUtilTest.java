package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static co.edu.uniquindio.ingesis.Genero.*;

class CoparetorPersonaUtilTest {

    @Test
    void test00() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f, 18, NO_BINARIO) );
        personas.add( new Persona("124","juan",68f,1.7f, 17, MASCULINO) );
        personas.add( new Persona("423","luis",88f,1.72f, 20, MASCULINO) );
        personas.add( new Persona("223","maria",58f,1.56f, 15, FEMENINO) );



        personas.sort( CoparetorPersonaUtil::compararPorNombre );

        for (int i = 0; i < personas.size(); i++) {
            System.out.println( personas.get(i) );
        }

    }

    @Test
    void test01() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f, 18, NO_BINARIO) );
        personas.add( new Persona("124","juan",68f,1.7f, 17, MASCULINO) );
        personas.add( new Persona("423","luis",88f,1.72f, 20, MASCULINO) );
        personas.add( new Persona("223","maria",58f,1.56f, 15, FEMENINO) );



        personas.sort( CoparetorPersonaUtil::compararPorPeso );

        personas.forEach( System.out::println );

    }


    @Test
    void testFilter01() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f, 18, NO_BINARIO) );
        personas.add( new Persona("124","juan",68f,1.7f, 17, MASCULINO) );
        personas.add( new Persona("423","luis",88f,1.72f, 20, MASCULINO) );
        personas.add( new Persona("223","maria",58f,1.56f, 15, FEMENINO) );
        personas.add( new Persona("153","miguel",78f,1.8f, 18, MASCULINO) );

        var resultado = personas.stream()
                .filter( persona -> persona.getEdad() >= 18 )
                .sorted(Comparator.comparing(Persona::getEdad).thenComparing(Persona::getNombre))
                .collect(Collectors.toList());


        resultado.forEach(System.out::println);

//        resultado.forEach(persona -> System.out.println(persona));

//        resultado.forEach(persona -> {
//            System.out.println(persona);
//        }
//        );

//        for (int i = 0; i < resultado.size(); i++) {
//            System.out.println( resultado.get(i) );
//        }

    }

    @Test
    void testFilter02() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f, 18, NO_BINARIO) );
        personas.add( new Persona("124","juan",68f,1.7f, 17, MASCULINO) );
        personas.add( new Persona("423","luis",88f,1.72f, 20, MASCULINO) );
        personas.add( new Persona("223","maria",58f,1.56f, 15, FEMENINO) );
        personas.add( new Persona("153","miguel",78f,1.8f, 18, MASCULINO) );

        var resultado = personas.stream()
                .filter( PersonaFilterUtil::mayorEdad )
                .sorted(Comparator.comparing(Persona::getEdad).thenComparing(Persona::getNombre))
                .collect(Collectors.toList());



        resultado.forEach(System.out::println);

    }

    @Test
    void testFilter03() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f, 18, NO_BINARIO) );
        personas.add( new Persona("124","juan",68f,1.7f, 17, MASCULINO) );
        personas.add( new Persona("423","luis",88f,1.72f, 20, MASCULINO) );
        personas.add( new Persona("223","maria",58f,1.56f, 15, FEMENINO) );
        personas.add( new Persona("153","miguel",78f,1.8f, 18, MASCULINO) );

        Genero genero = NO_BINARIO;
        var resultado = personas.stream()
                .filter( PersonaFilterUtil.filtarPorGenero(genero).negate() )
                .sorted(Comparator.comparing(Persona::getEdad).thenComparing(Persona::getNombre))
                .collect(Collectors.toList());



        resultado.forEach(System.out::println);

    }

    @Test
    void testFilter04() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f, 18, NO_BINARIO) );
        personas.add( new Persona("124","juan",68f,1.7f, 17, MASCULINO) );
        personas.add( new Persona("423","luis",88f,1.72f, 20, MASCULINO) );
        personas.add( new Persona("223","maria",58f,1.56f, 15, FEMENINO) );
        personas.add( new Persona("153","miguel",78f,1.8f, 18, MASCULINO) );
        personas.add( new Persona("223","Alexa",58f,1.56f, 30, FEMENINO) );

        Genero genero = NO_BINARIO;
        var resultado = personas.stream()
                .filter( PersonaFilterUtil.filtarPorGenero(genero).negate().and(PersonaFilterUtil.mayorA(17)) )
                .sorted(Comparator.comparing(Persona::getEdad).thenComparing(Persona::getNombre))
                .collect(Collectors.toList());



        resultado.forEach(System.out::println);

    }

}