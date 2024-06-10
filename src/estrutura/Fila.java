package estrutura;

import java.util.Iterator;

public class Fila<T> implements Iterable<T> {
    private No<T> frente;
    private No<T> fim;
    private int tamanho;

    public Fila() {
        this.frente = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public void push(T e) {
        No<T> no = new No<T>();
        no.dado = e;
        
        if (isEmpty()) {
            frente = no;
        } else {
            fim.proximo = no;
        }
        
        fim = no;
        tamanho++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        T dado = frente.dado;
        frente = frente.proximo;
        if (frente == null) {
            fim = null;
        }
        tamanho--;
        return dado;
    }

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			private No<T> no = frente;

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



