package N202;

import java.util.Objects;
import java.lang.Comparable;

/**
 * Utilitzant la classe del programa anterior, crea la implementació necessària
 * perquè els objectes de la classe Restaurant estiguin ordenats per nom i per
 * puntuació en ordre ascendent.
 * 
 * Exemple:
 * 
 * nom: restaurant1, puntuació: 8
 * 
 * nom: restaurant1, puntuació: 7
 *
 */

public class Restaurante2 implements Comparable<Restaurante2> {

	// Attributes
	private String nombre;
	private int puntuacion;

	// Constructor
	public Restaurante2(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}

	// getters/setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	// General Methods
	public String toString() {
		String mensaje = "Restuarante: " + this.getNombre() + ". Puntuacion: " + this.getPuntuacion();
		return mensaje;
	}

	// hashCode
	public int hashCode() {
		return Objects.hash(nombre, puntuacion);
	}

	// Equals propio

	public boolean equals(Object obj) {
		boolean igual = false;
		if (obj instanceof Restaurante2) {
			Restaurante2 otro = (Restaurante2) obj;
			if (this.nombre.equalsIgnoreCase(otro.getNombre()) && this.puntuacion == otro.getPuntuacion()) {
				igual = true;
			} else {
				igual = false;
			}
		} else {
			igual = false;
		}
		return igual;
	}

	// Metodo comparacion propio
	
	public int compareTo(Restaurante2 r) {
		int comparacionNombre = this.getNombre().compareTo(r.getNombre());
		int comparacionPuntos = this.getPuntuacion() - r.getPuntuacion();
		if ( comparacionNombre != 0) {
			return comparacionNombre;
		} else {
			return comparacionPuntos;
		}
	}
}
