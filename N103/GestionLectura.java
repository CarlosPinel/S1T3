package N103;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class GestionLectura {

	// Attributes

	// Constructor

	public GestionLectura() {
	};

	// Metodos generales

	// ***************** LECTURA ***********************
	// Metodo LECTURA de archivo txt y escritura en HashMap<String, String>:
	// fileToHashMap<String,String>

	public HashMap<String, String> fileToHashMapStrStr(String inputFilePath) throws IOException, FileNotFoundException {

		HashMap<String, String> paisCapitalMap = new HashMap<String, String>();
		try {
			FileReader reader = new FileReader(inputFilePath);
			BufferedReader bufferR = new BufferedReader(reader);
			String line = "";
			while (line != null) {
				try {
					line = bufferR.readLine();
					if (line != null) {
						String[] partes = line.split(" ");
						String pais = partes[0].trim();
						String capital = partes[1].trim();
						paisCapitalMap.put(pais, capital);
					}
				} catch (IOException e) {
					System.out.println("Error al leer la linea");
				}
			}
			reader.close();
			bufferR.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		return paisCapitalMap;
	}

	// Metodo LECTURA de archivo csv y escritura en HashMap<String, Integer>:
	// fileToHashMap<String,String>

	public HashMap<String, Integer> fileToHashMapStrInt(String inputFilePath)
			throws IOException, FileNotFoundException {

		HashMap<String, Integer> usuariosPuntuaciones = new HashMap<String, Integer>();
		try {
			FileReader reader = new FileReader(inputFilePath);
			BufferedReader bufferR = new BufferedReader(reader);
			String line = "";
			while (line != null) {
				try {
					line = bufferR.readLine();
					if (line != null) {
						String[] partes = line.split(";");
						String usuario = partes[0].trim();
						String puntos = partes[1].trim();
						int puntuacion = Integer.parseInt(puntos);
						usuariosPuntuaciones.put(usuario, puntuacion);
					}
				} catch (IOException e) {
					System.out.println("Error al leer la linea");
				}
			}
			reader.close();
			bufferR.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		return usuariosPuntuaciones;
	}
}
