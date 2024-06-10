package estrutura;

import java.util.ArrayList;
import java.util.List;


public class TabelaEspalhamento<T> {
    private List<No<T>>[] tabela;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;
    private static final double FATOR_CARGA_MAXIMO = 0.75;

    public TabelaEspalhamento() {
        this.tamanho = CAPACIDADE_INICIAL;
        tabela = new ArrayList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ArrayList<No<T>>();
        }
    }

    private int hash(String chave) {
        return Math.abs(chave.hashCode() % tamanho);
    }

    public void set(String chave, T valor) {
        int indice = hash(chave);
        List<No<T>> lista = tabela[indice];
        for (No<T> node : lista) {
            if (node.chave.equals(chave)) {
                node.valor = valor;
                return;
            }
        }
        lista.add(new No<T>(chave, valor));
        
        if ((double) size() / tamanho > FATOR_CARGA_MAXIMO) {
            redimensionar();
        }
    }
    
    public boolean has(String chave) {
    	return get(chave) != null;
    }

    public T get(String chave) {
        int indice = hash(chave);
        List<No<T>> lista = tabela[indice];
        for (No<T> node : lista) {
            if (node.chave.equals(chave)) {
                return node.valor;
            }
        }
        return null;
    }

    public void remove(String chave) {
        int indice = hash(chave);
        List<No<T>> lista = tabela[indice];
        for (No<T> node : lista) {
            if (node.chave.equals(chave)) {
                lista.remove(node);
                return;
            }
        }
    }

    private void redimensionar() {
        int novoTamanho = tamanho * 2;
        List<No<T>>[] novaTabela = new ArrayList[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new ArrayList<No<T>>();
        }
        for (List<No<T>> lista : tabela) {
            for (No<T> node : lista) {
                int novoIndice = Math.abs(node.chave.hashCode() % novoTamanho);
                novaTabela[novoIndice].add(node);
            }
        }
        tabela = novaTabela;
        tamanho = novoTamanho;
    }

    public int size() {
        int total = 0;
        for (List<No<T>> lista : tabela) {
            total += lista.size();
        }
        return total;
    }
    
    private class No<T> {
        String chave;
        T valor;

        public No(String chave, T valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
}
