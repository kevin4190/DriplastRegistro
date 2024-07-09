package registroDeEmpleados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistroEmpleados registro = new RegistroEmpleados();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de empleados a registrar:");
        int numEmpleados = scanner.nextInt();

        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("Ingrese los datos del empleado " + (i + 1) + ":");

            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();  

            System.out.print("DNI: ");
            String dni = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();  

            if (edad < 18) {
                System.out.println("El empleado es menor de edad y no puede ser registrado.");
                continue;  
            }

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Puesto: ");
            String puesto = scanner.nextLine();

            System.out.print("Horario: ");
            String horario = scanner.nextLine();

            Empleado empleado = new Empleado(codigo, dni, edad, nombre, apellido, puesto, horario);
            registro.agregarEmpleado(empleado);
        }

        System.out.println("Lista de empleados registrados:");
        registro.mostrarEmpleados();

        System.out.println("¿Desea cambiar el horario de algún empleado? (si/no)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Ingrese el código del empleado: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();  

            Empleado empleado = registro.buscarEmpleadoPorCodigo(codigo);
            if (empleado != null) {
                System.out.print("Ingrese el nuevo horario: ");
                String nuevoHorario = scanner.nextLine();
                empleado.setHorario(nuevoHorario);
                System.out.println("Horario actualizado con éxito.");
            } else {
                System.out.println("Empleado no encontrado.");
            }
        }

        System.out.println("¿Desea marcar la asistencia de algún empleado? ");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Ingrese el código del empleado: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); 

            Empleado empleado = registro.buscarEmpleadoPorCodigo(codigo);
            if (empleado != null) {
                empleado.marcarAsistencia();
                if (empleado.asistencia.equals("Tardanza")) {
                    System.out.println("Asistencia marcada como tardanza.");
                } else {
                    System.out.println("Asistencia marcada con éxito.");
                }
            } else {
                System.out.println("Empleado no encontrado.");
            }
        }

        System.out.println("Lista de empleados actualizada:");
        registro.mostrarEmpleados();
    }
}