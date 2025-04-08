package modelo;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstacionMeteorologica {
    private List<Registro> registros;
    private Scanner scanner;

    public EstacionMeteorologica() {
        this.registros = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void nuevoRegistro() {
        System.out.print("Ingrese la temperatura en grados Celsius: ");
        double temperatura = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        registros.add(new Registro(temperatura));
        System.out.println("Registro añadido.");
    }

    public void listarRegistros() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros disponibles.");
            return;
        }
        System.out.println("Registros de temperatura:");
        for (Registro registro : registros) {
            System.out.println(registro);
        }
    }

    public void mostrarEstadisticas() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros disponibles.");
            return;
        }
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        double suma = 0;

        for (Registro registro : registros) {
            double temperatura = registro.getTemperatura();
            if (temperatura > max) {
                max = temperatura;
            }
            if (temperatura < min) {
                min = temperatura;
            }
            suma += temperatura;
        }
        double promedio = suma / registros.size();
        System.out.printf("Máxima: %.2f°C, Mínima: %.2f°C, Promedio: %.2f°C%n", max, min, promedio);
    }

    public void guardarRegistros() {
        String fecha = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
        String nombreArchivo = "registros" + fecha + ".dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(registros);
            System.out.println("Registros guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los registros: " + e.getMessage());
        }
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Estación Meteorológica ---");
            System.out.println("1. Nuevo registro");
            System.out.println("2. Listar registros");
            System.out.println("3. Mostrar estadística");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    nuevoRegistro();
                    break;
                case 2:
                    listarRegistros();
                    break;
                case 3:
                    mostrarEstadisticas();
                    break;
                case 4:
                    guardarRegistros();
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        EstacionMeteorologica estacion = new EstacionMeteorologica();
        estacion.menu();
    }
}