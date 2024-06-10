package estrutura;

import java.util.ArrayList;
import java.util.List;

public class PilhaToFila {
	public static <T> Fila<T> transformar(Pilha<T> pilha) {
		List<T> dados = new ArrayList<T>();
		
		for (T dado : pilha) {
			dados.add(dado);
		}
		
		Fila<T> fila = new Fila<T>();
		
		for (T dado : dados.reversed()) {
			fila.push(dado);
		}
		
		return fila;
	}
}
