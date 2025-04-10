package controlador;
import java.util.Queue;
import java.util.Scanner;

import modelo.Supercola;

public class Main {
    public static void main(String[] args) {
        Supercola supercola = new Supercola();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Supercola ---");
            System.out.println("1. Encolar en cola1");
            System.out.println("2. Encolar en cola2");
            System.out.println("3. Desencolar de cola 1");
            System.out.println("4. Desencolar de cola 2");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce un número para encolar en cola1: ");
                    int valor1 = scanner.nextInt();
                    supercola.encolarEnCola1(valor1);
                    break;
                case 2:
                    System.out.print("Introduce un número para encolar en cola2: ");
                    int valor2 = scanner.nextInt();
                    supercola.encolarEnCola2(valor2);
                    break;
                case 3:
                    Integer desencolado1 = supercola.desencolarCola1();
                    if (desencolado1 != null) {
                        System.out.println("Desencolado de cola1: " + desencolado1);
                    } else {
                        System.out.println("Ambas colas están vacías.");
                    }
                    break;
                case 4:
                    Integer desencolado2 = supercola.desencolarCola2();
                    if (desencolado2 != null) {
                        System.out.println("Desencolado de cola2: " + desencolado2);
                    } else {
                        System.out.println("Ambas colas están vacías.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

            // Mostrar el estado de las colas
            mostrarEstadoColas(supercola);

        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarEstadoColas(Supercola supercola) {
        Queue<Integer> cola1 = supercola.getCola1();
        Queue<Integer> cola2 = supercola.getCola2();

        System.out.println("Estado de cola1: " + cola1);
        System.out.println("Estado de cola2: " + cola2);
    }
}