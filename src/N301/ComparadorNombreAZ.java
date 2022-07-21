package N301;

import java.util.Comparator;

public class ComparadorNombreAZ implements Comparator<Persona> {


	public int compare(Persona p1, Persona p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}
}
