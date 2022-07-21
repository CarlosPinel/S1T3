package N103;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class OrdenarMap {

	// Attributes

	// Constructor

	public OrdenarMap() {
	};

	// Metodos generales

	// ************** ORDENACION ****************

	public LinkedHashMap<String, Integer> ordenarValor(HashMap<String, Integer> usuariosPuntuacion) {

		LinkedHashMap<String, Integer> usuariosPuntuacionOrdenado = new LinkedHashMap<String, Integer>();
		int PuntMax = 10;
		do {
			for (String clave : usuariosPuntuacion.keySet()) {
				int valor = usuariosPuntuacion.get(clave);
				if (valor == PuntMax) {
					usuariosPuntuacionOrdenado.put(clave, valor);
				}
			}
			PuntMax--;
		} while (usuariosPuntuacion.size() != usuariosPuntuacionOrdenado.size());
		return usuariosPuntuacionOrdenado;
	}
}
