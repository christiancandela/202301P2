package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CoparetorPersonaUtilTest {

    @Test
    void test00() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f) );
        personas.add( new Persona("124","juan",68f,1.7f) );
        personas.add( new Persona("423","luis",88f,1.72f) );
        personas.add( new Persona("223","maria",58f,1.56f) );



        personas.sort( CoparetorPersonaUtil::compararPorNombre );

        for (int i = 0; i < personas.size(); i++) {
            System.out.println( personas.get(i) );
        }

    }

    @Test
    void test01() {
        List<Persona> personas = new ArrayList<>();

        personas.add( new Persona("123","pedro",78f,1.8f) );
        personas.add( new Persona("124","juan",68f,1.7f) );
        personas.add( new Persona("423","luis",88f,1.72f) );
        personas.add( new Persona("223","maria",58f,1.56f) );



        personas.sort( CoparetorPersonaUtil::compararPorPeso );

        personas.forEach( System.out::println );

    }
}