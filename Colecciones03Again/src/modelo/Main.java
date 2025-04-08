package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> numeros = new ArrayList<>();
		
		for(int i = 0; i<20;i++) {
			int numeroAleatorio = random.nextInt(10) + 1;
			numeros.add(numeroAleatorio);
		}
		System.out.println("Coleccion de numeros con repeticiones: " + numeros);
		
		Iterator<Integer> iterator = numeros.iterator();
		while(iterator.hasNext()) {
			if(iterator.next()==5) {
				iterator.remove();
			}
		}
		

	}

}
