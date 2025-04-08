package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Socio implements Serializable, Comparable<Socio> {
    private String dni;
    private String nombre;
    private LocalDate fechaAlta;

    public Socio(String dni, String nombre, LocalDate fechaAlta) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public int antiguedad() {
        return LocalDate.now().getYear() - fechaAlta.getYear();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Socio)) return false;
        Socio socio = (Socio) obj;
        return dni.equals(socio.dni);
    }

    @Override
    public int compareTo(Socio otro) {
        return this.dni.compareTo(otro.dni);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "DNI: " + dni + ", Nombre: " + nombre + ", Fecha de Alta: " + fechaAlta.format(formatter);
    }
}