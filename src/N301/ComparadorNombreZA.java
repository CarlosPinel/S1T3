package N301;

import java.util.Comparator;

public class ComparadorNombreZA implements Comparator<Persona> {


	public int compare(Persona p1, Persona p2) {
		
		int resultado;
		int compReverse = p1.getNombre().compareTo(p2.getNombre());
		if (compReverse < 0) {
			resultado = 1;
		} else if (compReverse > 0) {
			resultado = -1;
		} else {
			resultado = 0;
		}
		return resultado;
	}
}
