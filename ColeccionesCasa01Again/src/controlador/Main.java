package controlador;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la frase al usuario
        System.out.print("Introduce una frase (palabras separadas por espacios): ");
        String frase = scanner.nextLine();

        // Dividir la frase en palabras
        String[] palabrasArray = frase.split("\\s+");
        List<String> palabras = new ArrayList<>(Arrays.asList(palabrasArray));

        // Usar un mapa para contar las ocurrencias de cada palabra
        Map<String, Integer> contadorPalabras = new HashMap<>();

        for (String palabra : palabras) {
            contadorPalabras.put(palabra, contadorPalabras.getOrDefault(palabra, 0) + 1);
        }

        // Listas para palabras repetidas y no repetidas
        List<String> palabrasRepetidas = new ArrayList<>();
        List<String> palabrasNoRepetidas = new ArrayList<>();

        // Clasificar las palabras en repetidas y no repetidas
        for (Map.Entry<String, Integer> entry : contadorPalabras.entrySet()) {
            if (entry.getValue() > 1) {
                palabrasRepetidas.add(entry.getKey());
            } else {
                palabrasNoRepetidas.add(entry.getKey());
            }
        }

        // Mostrar resultados
        System.out.println("\nPalabras repetidas:");
        if (palabrasRepetidas.isEmpty()) {
            System.out.println("No hay palabras repetidas.");
        } else {
            for (String palabra : palabrasRepetidas) {
                System.out.println(palabra);
            }
        }

        System.out.println("\nPalabras no repetidas:");
        if (palabrasNoRepetidas.isEmpty()) {
            System.out.println("No hay palabras no repetidas.");
        } else {
            for (String palabra : palabrasNoRepetidas) {
                System.out.println(palabra);
            }
        }

        scanner.close();
    }
}