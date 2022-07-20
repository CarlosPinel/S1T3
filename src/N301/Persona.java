package N301;

import java.lang.Comparable;


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
 */

public class Persona implements Comparable<Persona>{

	// Attributes
	String nombre;
	String apellidos;
	String dNI;

	// constructor
	public Persona(String nombre, String apellidos, String dNI) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dNI = dNI;
	}

	// setters/getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellido(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return dNI;
	}

	public void setDNI(String dNI) {
		this.dNI = dNI;
	}

	// General Methods
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ", DNI: " + this.dNI;
	}

	// Metodo comparacion propio
	
		public int compareTo(Persona p) {
			return this.getDNI().compareTo(p.getDNI());
		}
}
