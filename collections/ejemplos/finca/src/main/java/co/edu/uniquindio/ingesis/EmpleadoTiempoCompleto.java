package co.edu.uniquindio.ingesis;

public class EmpleadoTiempoCompleto extends Empleado{
    private long salario;

    public EmpleadoTiempoCompleto(String nombre, String cargo, long salario) {
        super(nombre, cargo);
        this.salario = salario;
    }

    @Override
    public long calcularSalario() {
        return salario;
    }
}
