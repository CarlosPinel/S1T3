package N103;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class JuegoPaisCapital {

	static Scanner entrada = new Scanner(System.in);

	// Attributes
	private HashMap<String, String> paisCapitalMap;

	// Constructor
	public JuegoPaisCapital(HashMap<String, String> paisCapitalMap) {
		this.paisCapitalMap = paisCapitalMap;
	}

	// getters/setters
	public HashMap<String, String> getPaisCapitalMap() {
		return paisCapitalMap;
	}

	public void setPaisCapitalMap(HashMap<String, String> paisCapitalMap) {
		this.paisCapitalMap = paisCapitalMap;
	}

	// Metodos generales

	public HashMap<String, Integer> jugar(HashMap<String, String> paisCapitalMap) {

		HashMap<String, Integer> usuarioPuntuacion = new HashMap<String, Integer>();
		String nombreUser = "";
		String paisAleatorio = "", capital = "";
		int opcion = 0;
		int puntos = 0;

		do {
			System.out.println("\nQuiere jugar al juego Pais-Capital? \nPulse 1 para jugar, o pulse 0 para salir");
			opcion = entrada.nextInt();
			entrada.nextLine();
			if (opcion != 0) {
				System.out.println("Introduzca su nombre");
				nombreUser = entrada.nextLine();
				puntos = 0;
				for (int i = 0; i < 5; i++) {
					paisAleatorio = randomKey(paisCapitalMap);
					System.out.println("Introduce la capital de " + paisAleatorio);
					capital = entrada.nextLine();
					if (capital.equalsIgnoreCase(paisCapitalMap.get(paisAleatorio))) {
						puntos += 1;
						System.out.println("Muy bien, has ganado un punto. \n" + "Tu puntuacion es " + puntos);
						paisCapitalMap.remove(paisAleatorio);
					} else {
						System.out.println("Error esa no es la capital. Tu puntuacion es " + puntos);
					}
				}
				System.out.println(nombreUser + " tu puntuacion total es " + puntos);
				
				usuarioPuntuacion.put(nombreUser, puntos);
			} else {
				System.out.println("Adios");
			}
		} while (opcion != 0);
		return usuarioPuntuacion;
	}

	// Metodo random

	public String randomKey(HashMap<String, String> paisCapitalMap) {
		Random generator = new Random();
		Object[] keys = paisCapitalMap.keySet().toArray();
		String randomKey = (String) keys[generator.nextInt(keys.length)];
		return randomKey;
	}

}
