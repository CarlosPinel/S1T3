package N103;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Donat el fitxer countrties.txt (revisa l'apartat recursos) que cont�
 * pa�sos i capitals. El programa ha de llegir el fitxer i guardar les dades
 * en un HashMap<String, String>. El programa demana el nom de
 * l�usuari/�ria, i despr�s ha de mostrar un pa�s de forma aleat�ria,
 * guardat en el HashMap. Es tracta de qu� l�usuari/�ria ha d�escriure
 * el nom de la capital del pa�s en q�esti�. Si l�encerta se li suma un
 * punt. Aquesta acci� es repeteix 10 vegades. Un cop demanades les capitals
 * de 10 pa�sos de forma aleat�ria, llavors s�ha de guardar en un fitxer
 * anomenat classificacio.txt, el nom de l�usuari/�ria i la seva
 * puntuaci�.
 *
 */

public class Main {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Data

		HashMap<String, String> paisCapitalMap = new HashMap<String, String>();
		HashMap<String, Integer> usuarioPuntuacion = new HashMap<String, Integer>();
		HashMap<String, Integer> usuariosPuntuaciones = new HashMap<String, Integer>();
		HashMap<String, Integer> usuariosPuntuacionesOrdenado = new HashMap<String, Integer>();
		String inputFilePath = "", outputFilePath = "";
		GestionLectura gestorL = new GestionLectura();
		GestionEscritura gestorE = new GestionEscritura();
		OrdenarMap ordenadorM = new OrdenarMap();
		JuegoPaisCapital juego = new JuegoPaisCapital(paisCapitalMap);
		String mensaje = "";
		
		// Logic
		
		inputFilePath = ".\\src\\N103\\countries.txt";
		//**** CONVERTIR TXT A HASHMAP ****
		paisCapitalMap = gestorL.fileToHashMapStrStr(inputFilePath);
		System.out.println(paisCapitalMap.toString());

		// **** APP JUGAR A ADIVINAR CAPITALES (Creacion de HashMap individual)****
		usuarioPuntuacion = juego.jugar(paisCapitalMap);
		
		// **** CONVERTIR HASHMAP A CSV (SIN SOBREESCRIBIR) **** 
		outputFilePath = ".\\src\\N103\\clasificacion.csv";
		mensaje = gestorE.MapStrIntToFile (outputFilePath, usuarioPuntuacion);
		System.out.println(mensaje);
		System.out.println(usuarioPuntuacion.toString());
		
		
		// **** ORDENAR POR PUNTUACION ****
		inputFilePath = ".\\src\\N103\\clasificacion.csv";
		//convertir a HashMap (se perderan nombres repetidos)
		usuariosPuntuaciones = gestorL.fileToHashMapStrInt(inputFilePath);
		System.out.println(usuariosPuntuaciones.toString());
		// ordenar por valor
		usuariosPuntuacionesOrdenado = ordenadorM.ordenarValor(usuariosPuntuaciones);
		System.out.println(usuariosPuntuacionesOrdenado.toString());
		// convertir a CSV
		outputFilePath = ".\\src\\N103\\clasificacionOrd.csv";
		mensaje = gestorE.MapStrIntToFileSob(outputFilePath, usuariosPuntuacionesOrdenado);
		System.out.println(mensaje);
	}
}

	