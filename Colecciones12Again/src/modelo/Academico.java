package modelo;
import java.util.Objects;

public class Academico implements Comparable<Academico> {
    private String nombre;
    private int anioIngreso;

    public Academico(String nombre, int anioIngreso) {
        this.nombre = nombre;
        this.anioIngreso = anioIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    @Override
    public int compareTo(Academico otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + anioIngreso + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Academico)) return false;
        Academico academico = (Academico) o;
        return anioIngreso == academico.anioIngreso && Objects.equals(nombre, academico.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, anioIngreso);
    }
}