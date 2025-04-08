package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numeros = new ArrayList<>();
		
		while(true) {
			System.out.println("Introduce numeros enteros hasta que introduzcas -1");
			int numero = sc.nextInt();
			
			if (numero == -1) {
				System.out.println("Has introducido un -1, ya no puedes meter mas numeros");
				break;
			}else if(numero < 0) {
				System.out.println("Debes introducir numeros positivos");
			}else {
				System.out.println("Se va a proceder a meter el numero introducido...");
				numeros.add(numero);
			}
		}
		System.out.println("La colección de numeros es la siguiente: " + numeros);
		
		for(int numero:numeros) {
			if(numero%2==0) {
				System.out.println(numero);
			}
		}
		Iterator<Integer> iterator = numeros.iterator();
		while(iterator.hasNext()) {
			if(iterator.next()%3==0) {
				iterator.remove();
			}
		}
		System.out.println("Coleccion sin multiplos de 3: " + numeros);
		
		sc.close();
	}

}
