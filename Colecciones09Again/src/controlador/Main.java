package controlador;

import java.util.Scanner;
import java.util.Set;

import modelo.Sorteo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sorteo<String> sorteo = new Sorteo<>();

        System.out.println("Ingrese elementos para el sorteo (escriba 'fin' para terminar):");

        while (true) {
            String elemento = scanner.nextLine();
            if (elemento.equalsIgnoreCase("fin")) {
                break;
            }
            if (sorteo.add(elemento)) {
                System.out.println("Elemento añadido: " + elemento);
            } else {
                System.out.println("El elemento ya está presente: " + elemento);
            }
        }

        System.out.print("¿Cuántos premiados desea generar? ");
        int numPremiados = scanner.nextInt();

        try {
            Set<String> ganadores = sorteo.premiados(numPremiados);
            System.out.println("Combinación ganadora: " + ganadores);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}