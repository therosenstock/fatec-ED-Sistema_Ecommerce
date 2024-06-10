package estrutura;

import java.util.Iterator;

public class Pilha<T> implements Iterable<T> {

	No<T> topo;
	
	public Pilha() {
		topo = null;
	}
	
	public boolean isEmpty() {
		if (topo == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void push (T e) {
		No<T> elemento = new No<T>();
		elemento.dado = e;
		
		if (isEmpty()) {
			topo = elemento;
		} else {
			elemento.proximo = topo;
			topo = elemento;
		}
	}
	
	public T pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Pilha vazia");
		}
		
		T valor = topo.dado;
		topo = topo.proximo;
		
		return valor;
	}
	
	public T top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Pilha vazia");
		}
		return topo.dado;
	}

	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No<T> auxiliar = topo;
			cont = 1;
			
			while (auxiliar.proximo != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		
		return cont;
	}
	
	public void clear() {
		topo = null;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		No<T> auxiliar = topo;
		
		int cont = 0; 
		while (cont < size()) {
			sb.append("| " + auxiliar.dado + " |" + "\n" );
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			private No<T> no = topo;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return no != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				T valor = no.dado;
				no = no.proximo;
				return valor;
			}
		};
	}
	
	private class No<T> {
		public T dado;
		public No<T> proximo;	
	}
}
