package registroDeEmpleados;

import java.util.Calendar;

public class Empleado {
    private int codigo;
    private String dni;
    private int edad;
    private String nombre;
    private String apellido;
    private String puesto;
    private String horario;
    String asistencia;  // Atributo para asistencia

    public Empleado(int codigo, String dni, int edad, String nombre, String apellido, String puesto, String horario) {
        this.codigo = codigo;
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.horario = horario;
        this.asistencia = "Ausente";  // Inicialmente, la asistencia es "Ausente"
    }

    public int getEdad() {
        return edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void marcarAsistencia() {
        Calendar ahora = Calendar.getInstance();
        int hora = ahora.get(Calendar.HOUR_OF_DAY);
        int minutos = ahora.get(Calendar.MINUTE);
        if (hora > 9 || (hora == 9 && minutos > 0)) {
            this.asistencia = "Tardanza";
        } else {
            this.asistencia = "Presente";
        }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puesto='" + puesto + '\'' +
                ", horario='" + horario + '\'' +
                ", asistencia='" + asistencia + '\'' +
                '}';
    }
}