package controlador;
import java.util.*;

import modelo.Academico;

public class Main {
    private static final Set<Character> LETRAS_VALIDAS = new HashSet<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    ));

    public static boolean nuevoAcademico(Map<Character, Academico> academia, Academico nuevo, Character letra) {
        if (LETRAS_VALIDAS.contains(letra) && !academia.containsKey(letra)) {
            academia.put(letra, nuevo);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Character, Academico> academia = new TreeMap<>();
        
        // Crear académicos
        Academico a1 = new Academico("Alberto", 2020);
        Academico a2 = new Academico("Beatriz", 2019);
        Academico a3 = new Academico("Carlos", 2021);
        Academico a4 = new Academico("Diana", 2018);
        Academico a5 = new Academico("Eduardo", 2022);

        // Insertar académicos en el mapa
        nuevoAcademico(academia, a1, 'A');
        nuevoAcademico(academia, a2, 'B');
        nuevoAcademico(academia, a3, 'C');
        nuevoAcademico(academia, a4, 'D');
        nuevoAcademico(academia, a5, 'E');

        // Listado sin letra, por orden de nombre
        System.out.println("Listado de académicos (sin letra, por nombre):");
        List<Academico> listaAcademicos = new ArrayList<>(academia.values());
        Collections.sort(listaAcademicos); // Ordenar por nombre
        for (Academico academico : listaAcademicos) {
            System.out.println(academico);
        }

        System.out.println("\nListado de académicos (con letra, por letra):");
        for (Map.Entry<Character, Academico> entry : academia.entrySet()) {
            Character letra = entry.getKey();
            Academico academico = entry.getValue();
            System.out.println("Letra: " + letra + " - " + academico);
        }
    }
}