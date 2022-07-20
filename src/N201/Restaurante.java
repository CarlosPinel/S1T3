package N201;

import java.util.Objects;

/**
 * Crea una classe anomenada Restaurant amb dos atributs: nom(String) i
 * puntuació(int). Implementa els mètodes necessaris perquè no es puguin
 * introduir objectes Restaurant amb el mateix nom i la mateixa puntuació en un
 * HashSet creat en el main() de l’aplicació.
 * 
 * Important
 * 
 * Pot haver-hi restaurants amb el mateix nom amb diferent puntuació, però no
 * pot haver-hi restaurants amb el mateix nom i la mateixa puntuació.
 *
 */

public class Restaurante {

	//Attributes
	private String nombre;
	private int puntuacion;
	
	//Constructor
	public Restaurante(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}
	
	//getters/setters	
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
	
	
	
	
	//General Methods
	public String toString() {
		String mensaje = "Restuarante: " + this.getNombre() + ". Puntuacion: " + this.getPuntuacion();
		return mensaje;
	}

	//hashCode
	public int hashCode() {
		return Objects.hash(nombre, puntuacion);
	}

	//Equals propio
	
	public boolean equals(Object obj) {
		boolean igual = false;
		if( obj instanceof Restaurante) {
			Restaurante otro = (Restaurante) obj;
			if(this.nombre.equalsIgnoreCase(otro.getNombre()) && this.puntuacion == otro.getPuntuacion()) {
				igual = true;
			} else {
				igual = false;
			}
		} else {
			igual = false;
		}
		return igual;
	}
	
	
	
}
