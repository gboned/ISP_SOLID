package org.formacion.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProcesadorTexto {


	private List<String> texto = new ArrayList<>();
	// Descomponer la funcionalidad de la clase en dos interfaces
	// una básica (con nueva() y texto()) y otra compleja con
	// funcionalidad para la corrección
	public void nueva (String palabra) {
		texto.add(palabra);
	}
	
	public String texto () {
		return texto.stream().collect(Collectors.joining(" "));
	}
	// Usuarios que no necesiten la funcionalidad de corregir 
	// textos no tengan dependencia con el tipo Idioma
	public boolean correcto (Idioma idioma) {
		for (String palabra: texto) {
			if (! idioma.diccionario.contains(palabra.toLowerCase())) {
				return false;
			}
		}
		return true;
	}
}
