package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiplomadoTest {

    /*
    Nui	         Nota	Resultado
    null		        Error
    123	null	        Error
    null	    null    Error
    123 (No existe)	3	Error
    -123        		Error
    ""	            	Error
    1345(valido)	-1	Error
    1345(valido)	6	Error
    1345(valido)	4	Ok
     */
    @Test
    void registrarNota01() {
        Diplomado diplomado = new Diplomado("Diplomado", LocalDate.now(),LocalDate.now(),10000f);
        diplomado.registrarEstudiante("1345","pedro","perez",Genero.MASCULINO);
        assertThrows(Exception.class,()->diplomado.registrarNota(null,3f));
    }

    @Test
    void registrarNota02() {
        Diplomado diplomado = new Diplomado("Diplomado", LocalDate.now(),LocalDate.now(),10000f);
        diplomado.registrarEstudiante("1345","pedro","perez",Genero.MASCULINO);
        assertThrows(Exception.class,()->diplomado.registrarNota("1345",null));
    }

    @Test
    void registrarNota03() {
        Diplomado diplomado = new Diplomado("Diplomado", LocalDate.now(),LocalDate.now(),10000f);
        diplomado.registrarEstudiante("1345","pedro","perez",Genero.MASCULINO);
        assertThrows(Exception.class,()->diplomado.registrarNota(null,null));
    }

    @Test
    void registrarNota04() {
        Diplomado diplomado = new Diplomado("Diplomado", LocalDate.now(),LocalDate.now(),10000f);
        diplomado.registrarEstudiante("1345","pedro","perez",Genero.MASCULINO);
        assertThrows(Exception.class,()->diplomado.registrarNota("123",3f));
    }

    @Test
    void registrarNota05() {
        Diplomado diplomado = new Diplomado("Diplomado", LocalDate.now(),LocalDate.now(),10000f);
        diplomado.registrarEstudiante("1345","pedro","perez",Genero.MASCULINO);
        assertThrows(Exception.class,()->diplomado.registrarNota("-123",3f));
    }
}