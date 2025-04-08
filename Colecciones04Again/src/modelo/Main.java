package modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> positivos = new ArrayList<>();
        List<Double> negativos = new ArrayList<>();

        // Pedir números reales hasta que se introduzca un 0
        while (true) {
            System.out.print("Introduce un número real (0 para terminar): ");
            double numero = scanner.nextDouble();

            if (numero == 0) {
                break;
            } else if (numero > 0) {
                positivos.add(numero);
            } else {
                negativos.add(numero);
            }
        }

        // Mostrar ambas colecciones y sus sumas
        System.out.println("\nColección de números positivos: " + positivos);
        System.out.println("Suma de positivos: " + suma(positivos));

        System.out.println("\nColección de números negativos: " + negativos);
        System.out.println("Suma de negativos: " + suma(negativos));

        // Eliminar valores mayores que 10 o menores de -10
        eliminarValores(positivos, 10);
        eliminarValores(negativos, -10);

        // Mostrar las colecciones después de la eliminación
        System.out.println("\nColección de números positivos después de eliminar: " + positivos);
        System.out.println("Colección de números negativos después de eliminar: " + negativos);

        scanner.close();
    }

    // Método para calcular la suma de una lista
    private static double suma(List<Double> lista) {
        double suma = 0;
        for (double num : lista) {
            suma += num;
        }
        return suma;
    }

    // Método para eliminar valores mayores que un límite superior o menores que un límite inferior
    private static void eliminarValores(List<Double> lista, double limiteSuperior) {
        Iterator<Double> iterator = lista.iterator();
        while (iterator.hasNext()) {
            double num = iterator.next();
            if (num > limiteSuperior || num < -limiteSuperior) {
                iterator.remove();
            }
        }
    }
}