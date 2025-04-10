package modelo;
import java.util.LinkedList;
import java.util.Queue;

public class Supercola {
    private Queue<Integer> cola1;
    private Queue<Integer> cola2;

    public Supercola() {
        cola1 = new LinkedList<>();
        cola2 = new LinkedList<>();
    }

    public void encolarEnCola1(int valor) {
        cola1.offer(valor);
    }

    public void encolarEnCola2(int valor) {
        cola2.offer(valor);
    }

    public Integer desencolarCola1() {
        if (!cola1.isEmpty()) {
            return cola1.poll();
        } else if (!cola2.isEmpty()) {
            return cola2.poll();
        }
        return null; // Ambas colas están vacías
    }

    public Integer desencolarCola2() {
        if (!cola2.isEmpty()) {
            return cola2.poll();
        } else if (!cola1.isEmpty()) {
            return cola1.poll();
        }
        return null; // Ambas colas están vacías
    }

    public Queue<Integer> getCola1() {
        return cola1;
    }

    public Queue<Integer> getCola2() {
        return cola2;
    }
}