package N301;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.Iterator;

/**
 * Crea una aplicaci� capa� de llegir un fitxer CSV. Aquest fitxer t� 3 camps:
 * nom, cognom i DNI, per cada registre. Es tracta d�ordenar les persones
 * llegides del fitxer, mitjan�ant el seu nom, cognom o DNI. Pots fer servir la
 * llista que creguis m�s adient.
 * 
 * La classe Persona t� 3 atributs:
 * 
 * nom
 * 
 * cognom
 * 
 * DNI
 * 
 * 
 * 
 * La classe principal t� el seg�ent men�:
 * 
 * 1.- Introduir persona.
 * 
 * 2.- Mostrar les persones ordenades per nom (A-Z).
 * 
 * 3.- Mostrar les persones ordenades per nom (Z-A).
 * 
 * 4.- Mostrar les persones ordenades per cognoms (A-Z).
 * 
 * 5.- Mostrar les persones ordenades per cognoms (Z-A).
 * 
 * 6.- Mostrar les persones ordenades per DNI (1-9).
 * 
 * 7.- Mostrar les persones ordenades per DNI (9-1).
 * 
 * 0.- Sortir.
 * 
 * 
 * 
 * El programa haur� de llistar les persones com el seg�ent exemple:
 * 
 * ___Nom___ ____Cognoms___ __NIF__
 * 
 * Andreu Ballestero Llenas 34835767J
 * 
 * Miquel Bayona Font 48743957B
 * 
 * Guillem Capdevila Riu 33957834J
 * 
 * Albert Carbonell Ferrer 77364986R
 * 
 * Ferran Casas Coderch 23047848P
 * 
 * Maria Casellas Fuste 47102244S
 * 
 * Genis Ciutat Vendrell 39718459N
 *
 * 
 * 
 */

public class Main {

	
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Data
		int opcion = 0;
		String mensaje = "";
		String inputFilePath = "", outputFilePath = "";
		TreeSet<Persona> ListaPersonasTS = new TreeSet<Persona>();
		GestorLectura gestorL = new GestorLectura();
		GestorEscritura gestorE = new GestorEscritura();

		// Lectura de fichero CSV y conversion a TreeSet
		inputFilePath = ".\\src\\N301\\ListaPersonas.csv";
		ListaPersonasTS = gestorL.fileToTreeSet(inputFilePath);
		// Lista de trabajo para colecciones que se repiten campos
		ArrayList<Persona> ListaPersonasAL = new ArrayList<Persona>(ListaPersonasTS);
		
		// Dialogo
		do {
			System.out.println("Bienvenido al gestor de personal. \n" + "Indique la opcion que quiere realizar: \n"
					+ "0. Salir de la aplicacion. \n" + "1. Introducir persona \n"
					+ "2. Mostrar personas ordenadas por nombre (A-Z) \n"
					+ "3. Mostrar personas ordenadas por nombre (Z-A) \n"
					+ "4. Mostrar personas ordenadas por apellido (A-Z) \n"
					+ "5. Mostrar personas ordenadas por apellido (Z-A) \n"
					+ "6. Mostrar personas ordenadas por DNI (1-9) \n" + "7. Mostrar personas ordenadas por DNI (9-1)");
			opcion = entrada.nextInt();
			entrada.nextLine();

			switch (opcion) {
			case 0:
				mensaje = "Adios";
				break;
			case 1:
				mensaje = IntroducirPersona(ListaPersonasTS);
				ListaPersonasAL = new ArrayList<Persona>(ListaPersonasTS);
				break;
			case 2:
				mensaje = MostrarXNombreAZ(ListaPersonasAL);
				break;
			case 3:
				mensaje = MostrarXNombreZA(ListaPersonasAL);
				break;
			case 4:
				mensaje = MostrarXApellidosAZ(ListaPersonasAL);
				break;
			case 5:
				mensaje = MostrarXApellidosZA(ListaPersonasAL);
				break;
			case 6:
				mensaje = MostrarXDNIasc(ListaPersonasTS);
				break;
			case 7:
				mensaje = MostrarXDNIdesc(ListaPersonasTS);
				break;
			default:
				mensaje = "Esta opcion no esta disponible";
			}
			System.out.println(mensaje);
		} while (opcion != 0);

		// Escritura de TreeSet a archivo CSV
		outputFilePath = ".\\src\\N301\\ListaPersonas.csv";
		mensaje = gestorE.TreeSetToCSV(outputFilePath, ListaPersonasTS);
		System.out.println(mensaje);
	}

	// Methods
	public static String IntroducirPersona(TreeSet<Persona> ListaPersonasTS) {
		String resultado = "", nombre = "", apellidos = "", dNI = "";

		System.out.println("Indique el nombre de la persona");
		nombre = entrada.nextLine();
		System.out.println("Indique los apellidos de la persona");
		apellidos = entrada.nextLine();
		System.out.println("Indique el DNI de la persona");
		dNI = entrada.nextLine();
		Persona persona = new Persona(nombre, apellidos, dNI);
		if (ListaPersonasTS.contains(persona)) {
			resultado = "No se puede introducir la persona. Este DNI ya figura en el listado de la aplicación.";
		} else {
			ListaPersonasTS.add(persona); // La TreeSet no anadira las personas con DNI iguales
			resultado = persona.toString() + " ha sido introducida en el listado de la aplicacion";
		}
		return resultado;
	}

	public static String MostrarXNombreAZ(ArrayList<Persona> ListaPersonasAL) {
		String resultado = "";
		Collections.sort(ListaPersonasAL, new ComparadorNombreAZ());
		for (Persona persona : ListaPersonasAL)
			resultado += persona.toString() + "\n";
		return resultado;
	}

	public static String MostrarXNombreZA(ArrayList<Persona> ListaPersonasAL) {
		String resultado = "";
		Collections.sort(ListaPersonasAL, new ComparadorNombreZA());
		for (Persona persona : ListaPersonasAL)
			resultado += persona.toString() + "\n";
		return resultado;
	}

	public static String MostrarXApellidosAZ(ArrayList<Persona> ListaPersonasAL) {
		String resultado = "";
		Collections.sort(ListaPersonasAL, new ComparadorApellidosAZ());
		for (Persona persona : ListaPersonasAL)
			resultado += persona.toString() + "\n";
		return resultado;
	}

	public static String MostrarXApellidosZA(ArrayList<Persona> ListaPersonasAL) {
		String resultado = "";
		Collections.sort(ListaPersonasAL, new ComparadorApellidosZA());
		for (Persona persona : ListaPersonasAL)
			resultado += persona.toString() + "\n";
		return resultado;
	}

	public static String MostrarXDNIasc(TreeSet<Persona> ListaPersonas) {
		String resultado = "";
		for (Persona persona : ListaPersonas)
			resultado += persona.toString() + "\n";
		return resultado;
	}

	public static String MostrarXDNIdesc(TreeSet<Persona> ListaPersonas) {
		String resultado = "";
		Iterator<Persona> itdesc = ListaPersonas.descendingIterator();
		while (itdesc.hasNext()) {
			resultado += itdesc.next().toString() + "\n";
		}
		return resultado;
	}
}
