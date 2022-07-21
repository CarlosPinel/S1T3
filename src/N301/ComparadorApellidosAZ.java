package N301;

import java.util.Comparator;

public class ComparadorApellidosAZ implements Comparator<Persona> {

	public int compare(Persona p1, Persona p2) {
		return p1.getApellidos().compareTo(p2.getApellidos());
	}
}