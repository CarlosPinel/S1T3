package N101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;



/**
 * Crea una classe anomenada Month amb un atribut "name" (que emmagatzemar� el
 * nom del mes de l'any). Afegeix 11 objectes Month (cadascun amb el seu atribut
 * diferent) en un ArrayList, a excepci� de l'objecte amb atribut "Agost".
 * Despr�s, efectua la inserci� en el lloc que correspon a aquest mes i demostra
 * que l�ArrayList mant� l'ordre correcte.
 * 
 * Converteix l�ArrayList de l�exercici anterior en un HashSet i assegura�t que
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
		
		// con el siguiente foreach y println, se demuestra que Agosto se ha colocado en la posici�n 7.
		System.out.println("Impresi�n del ArrayList con foreach");
		for(Month m : monthsArray) {
			System.out.println(m.getName());
		}
		// conversi�n del ArrayList a HashSet, por medio del constructor de hashset.
		// Se imprimen desordenados.
		System.out.println("Impresi�n del HashSet con foreach");
		HashSet<Month> monthsSet = new HashSet<Month>(monthsArray);
		for(Month m : monthsSet) {
			System.out.println(m.getName());
		}
		// comprobaci�n de que hashset no permite duplicados
		// no a�ade objeto AgostoObj a la colecci�n al ser duplicado
		System.out.println("tama�o de la colecci�n monthSet: " + monthsSet.size());
		monthsSet.add(AgostoObj);
		System.out.println("tama�o de la colecci�n monthSet a�adiendo objeto duplicado: " + monthsSet.size());
		System.out.println("Impresi�n del HashSet con foreach");
		for(Month m : monthsSet) {
			System.out.println(m.getName());
		}
		// Si a�ade objeto a la colecci�n en caso de no ser duplicado (para objeto String, no tener mismo valor)
		System.out.println("tama�o de la colecci�n monthSet: " + monthsSet.size());
		Month InventadoObj = new Month("Inventado"); 
		monthsSet.add(InventadoObj);
		System.out.println("tama�o de la colecci�n monthSet con objeto no duplicado inventado: " + monthsSet.size());
		System.out.println("Impresi�n del HashSet con foreach");
		for(Month m : monthsSet) {
			System.out.println(m.getName());
		}
		// recorrer la colecci�n con un iterador
		System.out.println("Impresi�n del HashSet con iterator");
		Iterator<Month> mon = monthsSet.iterator();
		while(mon.hasNext()) {
			System.out.println(mon.next().getName());
		}
		// eliminar el objeto InventadoObj e impresi�n con iterator
		System.out.println("Impresi�n sin mes de Inventado");
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
