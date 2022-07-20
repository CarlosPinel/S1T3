package N102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Crea i emplena un List<Integer>.
 * 
 * Crea un segon List<Integer> i insereix a la segona llista els elements de la
 * primera en ordre invers.
 * 
 * Empra els objectes ListIterator per a llegir els elements de la primera
 * llista i inserir-los en la segona.
 *
 */

public class Main {

	public static void main(String[] args) {

		// Crear y llenar una List<Integer>
		List<Integer> numeros1 = new ArrayList<Integer>();
		numeros1.add(1);
		numeros1.add(5);
		numeros1.add(9);
		numeros1.add(23);
		numeros1.add(4);
		numeros1.add(1);
		numeros1.add(8);

		List<Integer> numeros2 = new ArrayList<Integer>();

		// Usar ListIterator para leer elementos de la lista 1 y a�adirlos a la lista2 en orden inverso.
		ListIterator<Integer> it = numeros1.listIterator();
		while (it.hasNext()) {
			it.next();
		}
		while(it.hasPrevious()) {
			numeros2.add(it.previous());
		}
		// se puede imprimir con iterador o con foreach
		ListIterator<Integer> it2 = numeros2.listIterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}

		//Otra forma:
		//orden inverso
		List<Integer> numeros3 = new ArrayList<Integer>();
		numeros3.addAll(numeros1);
		Collections.sort(numeros3, Collections.reverseOrder());
		//impresion
		for (Integer n : numeros3) {
			System.out.println(n);
		}
	}

}
