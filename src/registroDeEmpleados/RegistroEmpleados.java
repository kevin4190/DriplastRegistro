package registroDeEmpleados;

import java.util.ArrayList;

public class RegistroEmpleados {
    private ArrayList<Empleado> listaEmpleados;

    public RegistroEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }
    }

    public Empleado buscarEmpleadoPorCodigo(int codigo) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getCodigo() == codigo) {
                return empleado;
            }
        }
        return null; // Si no se encuentra el empleado
    }
}
