package N101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;



/**
 * Crea una classe anomenada Month amb un atribut "name" (que emmagatzemarà el
 * nom del mes de l'any). Afegeix 11 objectes Month (cadascun amb el seu atribut
 * diferent) en un ArrayList, a excepció de l'objecte amb atribut "Agost".
 * Després, efectua la inserció en el lloc que correspon a aquest mes i demostra
 * que l’ArrayList manté l'ordre correcte.
 * 
 * Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que
 * no permet duplicats.
 * 
 * Recorre la llista amb un for i amb un iterador.
 *
 */

public class Main {
	
	static ArrayList<Month> monthsArray = new ArrayList<Month>();

	public static void main(String[] args) {

		//Creacion de objetos Month e introduccion en arraylist, con metodo.
		crearMonth_IntroArrayList("Enero");
		crearMonth_IntroArrayList("Febrero");
		crearMonth_IntroArrayList("Marzo");
		crearMonth_IntroArrayList("Abril");
		crearMonth_IntroArrayList("Mayo");
		crearMonth_IntroArrayList("Junio");
		crearMonth_IntroArrayList("Julio");
		crearMonth_IntroArrayList("Septiembre");
		crearMonth_IntroArrayList("Octubre");
		crearMonth_IntroArrayList("Noviembre");
		crearMonth_IntroArrayList("Diciembre");
		
		Month AgostoObj = new Month("Agosto");
		monthsArray.add(7,AgostoObj);
		
		// con el siguiente foreach y println, se demuestra que Agosto se ha colocado en la posición 7.
		System.out.println("Impresión del ArrayList con foreach");
		for(Month m : monthsArray) {
			System.out.println(m.getName());
		}
		// conversión del ArrayList a HashSet, por medio del constructor de hashset.
		// Se imprimen desordenados.
		System.out.println("Impresión del HashSet con foreach");
		HashSet<Month> monthsSet = new HashSet<Month>(monthsArray);
		for(Month m : monthsSet) {
			System.out.println(m.getName());
		}
		// comprobación de que hashset no permite duplicados
		// no añade objeto AgostoObj a la colección al ser duplicado
		System.out.println("tamaño de la colección monthSet: " + monthsSet.size());
		monthsSet.add(AgostoObj);
		System.out.println("tamaño de la colección monthSet añadiendo objeto duplicado: " + monthsSet.size());
		System.out.println("Impresión del HashSet con foreach");
		for(Month m : monthsSet) {
			System.out.println(m.getName());
		}
		// Si añade objeto a la colección (aunque tenga el mismo valor)
		System.out.println("tamaño de la colección monthSet: " + monthsSet.size());
		Month InventadoObj = new Month("Agosto"); 
		monthsSet.add(InventadoObj);
		System.out.println("tamaño de la colección monthSet con objeto no duplicado inventado: " + monthsSet.size());
		System.out.println("Impresión del HashSet con foreach");
		for(Month m : monthsSet) {
			System.out.println(m.getName());
		}
		// recorrer la colección con un iterador
		System.out.println("Impresión del HashSet con iterator");
		Iterator<Month> mon = monthsSet.iterator();
		while(mon.hasNext()) {
			System.out.println(mon.next().getName());
		}
		// eliminar el objeto InventadoObj e impresión con iterator
		System.out.println("Impresión sin mes de Inventado");
		monthsSet.remove(InventadoObj);
		mon = monthsSet.iterator();
		while(mon.hasNext()) {
			System.out.println(mon.next().getName());
		}
	}
	
	//Metodo crear objeto e introducirlo en arrayList months
	public static void crearMonth_IntroArrayList(String nombre) {
		Month month = new Month(nombre);
		monthsArray.add(month);
	}
}
