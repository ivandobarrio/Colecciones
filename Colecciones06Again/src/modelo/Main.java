package modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        // Pedir números enteros positivos hasta que se introduzca uno negativo
        while (true) {
            System.out.print("Introduce un número entero positivo (negativo para terminar): ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                break; // Salir del bucle si se introduce un número negativo
            } else {
                numeros.add(numero); // Agregar el número a la lista
            }
        }

        // Recorrer la lista y mostrar los índices de los elementos pares multiplicados por 100
        System.out.println("\nÍndices de elementos pares multiplicados por 100:");
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) { // Verificar si el número es par
                int valorMultiplicado = numeros.get(i) * 100; // Multiplicar por 100
                System.out.println("Índice: " + i + ", Valor: " + valorMultiplicado);
            }
        }

        scanner.close();
    }
}