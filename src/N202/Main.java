package N202;

import java.util.TreeSet;

/**
 * Utilitzant la classe del programa anterior, crea la implementació necessària
 * perquè els objectes de la classe Restaurant estiguin ordenats per nom i per
 * puntuació en ordre ascendent.
 * 
 * Exemple:
 * 
 * nom: restaurant1, puntuació: 8
 * 
 * nom: restaurant1, puntuació: 7
 *
 */

public class Main {

	static TreeSet<Restaurante2> restaurantesTS = new TreeSet<Restaurante2>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		crearAnadirRest("Manolo", 10);
		crearAnadirRest("Manolo", 10);
		crearAnadirRest("manolo", 9);
		crearAnadirRest("tierra_y_mar", 8);
		crearAnadirRest("tagliatella", 10);
		crearAnadirRest("merquen", 5);
		crearAnadirRest("tapas_y_birras", 4);

		
		System.out.println(restaurantesTS.size());
		for (Restaurante2 rest : restaurantesTS) {
			System.out.println(rest.toString());
		}
		
	}

	// Metodo crear restaurante y añadir al hashset restaurantes

	public static void crearAnadirRest(String nombre, int puntuacion) {
		Restaurante2 restaurante = new Restaurante2(nombre, puntuacion);
		restaurantesTS.add(restaurante);
	}
}