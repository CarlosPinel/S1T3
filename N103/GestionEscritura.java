package N103;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GestionEscritura {

	// Attributes

	// Constructor

	public GestionEscritura() {
	};

	// Metodos generales

	// Metodo de archivo Map<String,Integer> y ESCRITURA en csv
	// (NO sobreescribir):
	// HashMapStrIntToFile

	public String MapStrIntToFile(String outputFilePath, Map<String, Integer> map)
			throws IOException, FileNotFoundException {

		String mensaje = "";

		try {
			File file = new File(outputFilePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter bufferW = new BufferedWriter(writer);
			for (Map.Entry<String, Integer> i : map.entrySet()) {
				try {
					bufferW.write(i.getKey() + ";" + i.getValue() + "\n");

				} catch (IOException e) {
					System.out.println("Error al escribir la linea");
				}
				mensaje = "tabla de usuario y puntuacion guardada en el archivo " + file.getName();
			}
			bufferW.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mensaje;
	}

	// Metodo de archivo Map<String,Integer> y ESCRITURA en csv
	// (SI sobreescribir):
	// HashMapStrIntToFile

	public String MapStrIntToFileSob(String outputFilePath, Map<String, Integer> map)
			throws IOException, FileNotFoundException {

		String mensaje = "";

		try {
			File file = new File(outputFilePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			BufferedWriter bufferW = new BufferedWriter(writer);
			for (Map.Entry<String, Integer> i : map.entrySet()) {
				try {
					bufferW.write(i.getKey() + ";" + i.getValue() + "\n");

				} catch (IOException e) {
					System.out.println("Error al escribir la linea");
				}
				mensaje = "tabla de usuario y puntuacion guardada en el archivo " + file.getName();
			}
			bufferW.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mensaje;
	}
}
