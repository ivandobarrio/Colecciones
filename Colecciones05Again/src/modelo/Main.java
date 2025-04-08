package modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();

        // Insertar 20 números aleatorios en la colección
        for (int i = 0; i < 20; i++) {
            int numeroAleatorio = random.nextInt(100); // Genera un número aleatorio entre 0 y 99
            numeros.add(numeroAleatorio);
        }

        // Mostrar la colección original
        System.out.println("Colección original: " + numeros);

        // Ordenar de menor a mayor
        Collections.sort(numeros);
        System.out.println("Colección ordenada de menor a mayor: " + numeros);

        // Convertir la lista a un array (tabla)
        Integer[] array = new Integer[numeros.size()];
        array = numeros.toArray(array);

        // Convertir el array de nuevo a una lista
        List<Integer> listaOrdenada = new ArrayList<>();
        Collections.addAll(listaOrdenada, array);

        // Ordenar de mayor a menor
        Collections.sort(listaOrdenada, Collections.reverseOrder());
        System.out.println("Colección ordenada de mayor a menor: " + listaOrdenada);
    }
}