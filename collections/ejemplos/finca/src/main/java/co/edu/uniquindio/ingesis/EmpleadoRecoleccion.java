package co.edu.uniquindio.ingesis;

public class EmpleadoRecoleccion extends Empleado{
    private int numeroKilos;
    private long valorKilo;

    public EmpleadoRecoleccion(String nombre, String cargo, int numeroKilos, long valorKilo) {
        super(nombre, cargo);
        this.numeroKilos = numeroKilos;
        this.valorKilo = valorKilo;
    }

    @Override
    public long calcularSalario() {
        return numeroKilos * valorKilo;
    }
}
