package co.edu.uniquindio.ingesis;

public class EmpleadoTiempoParcial extends Empleado{
    private int numeroHoras;
    private long salarioHora;

    public EmpleadoTiempoParcial(String nombre, String cargo, int numeroHoras, long salarioHora) {
        super(nombre, cargo);
        this.numeroHoras = numeroHoras;
        this.salarioHora = salarioHora;
    }

    @Override
    public long calcularSalario() {
        return numeroHoras * salarioHora;
    }
}
