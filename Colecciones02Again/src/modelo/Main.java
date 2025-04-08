package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> numeros = new ArrayList<>();
		
		for(int i = 0; i<20;i++) {
			int numeroAleatorio = random.nextInt(10) + 1;
			numeros.add(numeroAleatorio);
		}
		System.out.println("Coleccion de numeros con repeticiones: " + numeros);
		
		Set<Integer> numerosSinRepeticiones = new HashSet<>(numeros);
		List<Integer> numerosSinRepeticionesLista = new ArrayList<>(numerosSinRepeticiones);
		
		System.out.println("Coleccion de numeros sin repeticiones: " + numerosSinRepeticionesLista);

	}

}
