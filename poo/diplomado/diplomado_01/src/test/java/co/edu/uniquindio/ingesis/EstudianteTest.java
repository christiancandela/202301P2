package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    @Test
    void calcularDefinitiva() {
        Estudiante estudiante = new Estudiante("123","pedro","perez",Genero.MASCULINO);
        assertEquals(Float.NaN,estudiante.calcularDefinitiva());
        estudiante.addNota(2.0f);
        estudiante.addNota(4.0f);
        estudiante.addNota(3.0f);
        assertEquals(3.0f,estudiante.calcularDefinitiva());
    }
}