package modelo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();

        // Insertar 20 números aleatorios entre 1 y 10 en la lista
        for (int i = 0; i < 20; i++) {
            int numeroAleatorio = random.nextInt(10) + 1; // Genera un número entre 1 y 10
            numeros.add(numeroAleatorio);
        }

        // Mostrar la lista original
        System.out.println("Lista original: " + numeros);

        // Crear un conjunto para los elementos únicos (sin repetir)
        Set<Integer> conjuntoUnicos = new HashSet<>(numeros);

        // Crear un conjunto para los elementos repetidos
        Set<Integer> conjuntoRepetidos = new HashSet<>();
        Set<Integer> conjuntoUnaVez = new HashSet<>();

        // Contar las ocurrencias de cada número
        for (Integer numero : numeros) {
            if (conjuntoRepetidos.contains(numero)) {
                conjuntoUnaVez.remove(numero); // Si ya está en repetidos, lo eliminamos de únicos
            } else {
                conjuntoRepetidos.add(numero);
                conjuntoUnaVez.add(numero); // Agregar a únicos
            }
        }

        // Eliminar de conjuntoUnaVez los elementos que están en conjuntoRepetidos
        conjuntoUnaVez.removeAll(conjuntoRepetidos);

        // Mostrar los conjuntos
        System.out.println("Conjunto de elementos únicos (sin repetir): " + conjuntoUnicos);
        System.out.println("Conjunto de elementos repetidos: " + conjuntoRepetidos);
        System.out.println("Conjunto de elementos que aparecen una sola vez: " + conjuntoUnaVez);
    }
}