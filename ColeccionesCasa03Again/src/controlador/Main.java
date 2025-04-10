package controlador;
import java.util.Random;
import java.util.TreeSet;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>(Collections.reverseOrder());
        Random random = new Random();

        // Generar 20 números aleatorios distintos menores que 100
        while (numeros.size() < 20) {
            int numeroAleatorio = random.nextInt(100); // Genera un número entre 0 y 99
            numeros.add(numeroAleatorio); // TreeSet se encarga de evitar duplicados
        }

        // Mostrar la colección resultante
        System.out.println("Números aleatorios distintos en orden decreciente:");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
    }
}