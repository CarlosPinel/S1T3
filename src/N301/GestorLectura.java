package N301;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class GestorLectura {

	// Attributes

	// Constructor

	public GestorLectura() {
	};

	// Metodos generales
	// Metodo LECTURA de archivo csv y escritura en TreeSet<Persona>

	public TreeSet<Persona> fileToTreeSet(String inputFilePath)
			throws IOException, FileNotFoundException {

		TreeSet<Persona> ListaPersonasDNIasc = new TreeSet<Persona>();
		try {
			FileReader reader = new FileReader(inputFilePath);
			BufferedReader bufferR = new BufferedReader(reader);
			String line = "";
			while (line != null) {
				try {
					line = bufferR.readLine();
					if (line != null) {
						String[] partes = line.split(";");
						String nombre = partes[0].trim();
						String apellidos = partes[1].trim();
						String dNI = partes[2].trim();
						Persona persona = new Persona(nombre, apellidos, dNI);
						ListaPersonasDNIasc.add(persona);
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
		return ListaPersonasDNIasc;
	}
}
