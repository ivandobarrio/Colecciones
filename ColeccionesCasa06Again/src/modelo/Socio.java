package modelo;
import java.io.Serializable;
import java.time.LocalDate;

public class Socio implements Serializable {
    private String apodo;
    private String nombre;
    private LocalDate fechaIngreso;

    public Socio(String apodo, String nombre, LocalDate fechaIngreso) {
        this.apodo = apodo;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
    }

    public String getApodo() {
        return apodo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public String toString() {
        return "Apodo: " + apodo + ", Nombre: " + nombre + ", Fecha de Ingreso: " + fechaIngreso;
    }
}