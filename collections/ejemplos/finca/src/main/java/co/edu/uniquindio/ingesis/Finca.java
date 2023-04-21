package co.edu.uniquindio.ingesis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Finca {
    private List<Empleado> empleados;

    public void adicionarEmpleado(Empleado empleado){
        // TODO faltan validaciones
        empleados.add(empleado);
    }

    public List<EmpleadoTiempoParcial> listarEmpleadosTiempoParcial(){

//        List<EmpleadoTiempoParcial> resultado = new ArrayList<>();
//        for (int i = 0; i < empleados.size() ; i++) {
//            if( empleados.get(i) instanceof EmpleadoTiempoParcial ){
//                resultado.add((EmpleadoTiempoParcial) empleados.get(i));
//            }
//        }
//        resultado.sort(Comparator.comparing(EmpleadoTiempoParcial::calcularSalario));
//        return resultado;

        return empleados
                .stream()
                .filter( empleado -> empleado instanceof EmpleadoTiempoParcial )
                .sorted(Comparator.comparing(Empleado::calcularSalario))
                .map(empleado -> (EmpleadoTiempoParcial)empleado)
                .collect(Collectors.toList());
    }

    public List<Empleado> listarEmpleadosSalarioMayorPromedio(){
        final long salarioPromedio = calcularSalarioPromedio();
        return empleados.stream()
                .filter( empleado -> empleado.calcularSalario() > salarioPromedio )
                .collect(Collectors.toList());
    }

    private long calcularSalarioPromedio() {
        return (long) empleados.stream()
                .mapToLong(Empleado::calcularSalario)
                //.mapToLong( empleado-> empleado.calcularSalario())
                .average()
                .orElse(0.0);
    }

    public List<String> listarNombreEmpleados(){
        return empleados.stream()
                .map(Empleado::getNombre)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
