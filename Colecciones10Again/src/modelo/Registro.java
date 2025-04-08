package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    private double temperatura;
    private LocalDateTime hora;

    public Registro(double temperatura) {
        this.temperatura = temperatura;
        this.hora = LocalDateTime.now();
    }

    public double getTemperatura() {
        return temperatura;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Temperatura: " + temperatura + "°C, Hora: " + hora.format(formatter);
    }
}