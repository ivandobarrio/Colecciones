package controlador;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de listas ordenadas
        List<Integer> lista1 = List.of(1, 3, 5, 7, 9);
        List<Integer> lista2 = List.of(2, 4, 6, 8, 10);

        // Fusionar las listas
        List<Integer> listaFusionada = fusionarListas(lista1, lista2);

        // Mostrar la lista fusionada
        System.out.println("Lista fusionada: " + listaFusionada);
    }

    public static List<Integer> fusionarListas(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> listaFusionada = new ArrayList<>();
        int i = 0, j = 0;

        // Fusionar las dos listas
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                listaFusionada.add(lista1.get(i));
                i++;
            } else {
                listaFusionada.add(lista2.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes de lista1
        while (i < lista1.size()) {
            listaFusionada.add(lista1.get(i));
            i++;
        }

        // Agregar los elementos restantes de lista2
        while (j < lista2.size()) {
            listaFusionada.add(lista2.get(j));
            j++;
        }

        return listaFusionada;
    }
}