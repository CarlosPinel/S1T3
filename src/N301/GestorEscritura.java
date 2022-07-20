package N301;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class GestorEscritura {

	// Attributes

	// Constructor

	public GestorEscritura() {
	};

	// Metodos generales
	// Metodo de archivo lectura de TreeSet y ESCRITURA en csv (sobreescribiendo)

	public String TreeSetToCSV(String outputFilePath, TreeSet<Persona> ListaPersonasDNIasc)
			throws IOException, FileNotFoundException {

		String mensaje = "";

		try {
			File file = new File(outputFilePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			BufferedWriter bufferW = new BufferedWriter(writer);
			for (Persona persona : ListaPersonasDNIasc) {
				try {
					bufferW.write(persona.getNombre() + ";" + persona.getApellidos() + ";" + persona.getDNI() + "\n");
				} catch (IOException e) {
					System.out.println("Error al escribir la linea");
				}
				mensaje = "Lista de personas guardada en archivo CSV " + file.getName();
			}
			bufferW.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mensaje;
	}
}
