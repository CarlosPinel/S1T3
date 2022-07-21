package N201;

import java.util.HashSet;

/**
 * Crea una classe anomenada Restaurant amb dos atributs: nom(String) i
 * puntuació(int). Implementa els mètodes necessaris perquè no es puguin
 * introduir objectes Restaurant amb el mateix nom i la mateixa puntuació en un
 * HashSet creat en el main() de l’aplicació.
 * 
 * Important
 * 
 * Pot haver-hi restaurants amb el mateix nom amb diferent puntuació, però no
 * pot haver-hi restaurants amb el mateix nom i la mateixa puntuació.
 *
 */

public class Main {

	static HashSet<Restaurante> restaurantes = new HashSet<Restaurante>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		crearAnadirRest("Manolo",10);
		crearAnadirRest("Manolo",10);
		crearAnadirRest("manolo",9);
		crearAnadirRest("tierra_y_mar",8);
		crearAnadirRest("tagliatella",10);
		crearAnadirRest("merquen",5);
		crearAnadirRest("tapas_y_birras",4);
		
		System.out.println(restaurantes.size());
		for(Restaurante rest : restaurantes) {
			System.out.println(rest.toString());
		}

	}
	
	// Metodo crear restaurante y añadir al hashset restaurantes
	
	public static void crearAnadirRest(String nombre, int puntuacion) {
		Restaurante restaurante = new Restaurante(nombre, puntuacion);
		restaurantes.add(restaurante);
	}

}
