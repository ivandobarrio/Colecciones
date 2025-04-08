package modelo;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sorteo<T> {
    private Set<T> elementos;

    public Sorteo() {
        this.elementos = new HashSet<>();
    }

    // Método para añadir un elemento al conjunto
    public boolean add(T elemento) {
        return elementos.add(elemento); // add() devuelve true si el elemento fue añadido
    }

    // Método para generar una combinación premiada
    public Set<T> premiados(int numPremiados) {
        if (numPremiados > elementos.size()) {
            throw new IllegalArgumentException("No hay suficientes elementos para generar premiados.");
        }

        Set<T> ganadores = new HashSet<>();
        Random random = new Random();
        T[] elementosArray = (T[]) elementos.toArray(); // Convertir el conjunto a un array

        while (ganadores.size() < numPremiados) {
            int indiceAleatorio = random.nextInt(elementosArray.length);
            ganadores.add(elementosArray[indiceAleatorio]);
        }

        return ganadores;
    }
}
