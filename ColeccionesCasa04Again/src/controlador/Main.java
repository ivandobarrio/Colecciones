package controlador;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedHashSet<String> nombres = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        String nombre;

        System.out.println("Introduce nombres (escribe 'fin' para terminar):");

        // Leer nombres hasta que se introduzca "fin"
        while (true) {
            nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) {
                break; // Salir del bucle si se introduce "fin"
            }
            nombres.add(nombre); // Agregar el nombre a la colección
        }

        // Mostrar la colección de nombres
        System.out.println("\nNombres introducidos:");
        for (String n : nombres) {
            System.out.println(n);
        }

        scanner.close();
    }
}