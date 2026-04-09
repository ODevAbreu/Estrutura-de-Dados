package Arvores;

public class ArvoreBinariaDeBusca {


    private class No {
        int valor;
        No esquerda;
        No direita;

        public No(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private No raiz;

    // Construtor
    public void ArvoreBinariaBusca() {
        this.raiz = null;
    }


    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {

        // Se estiver vazio, cria novo nó
        if (atual == null) {
            return new No(valor);
        }

        // Vai para esquerda
        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        }
        // Vai para direita
        else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        }

        // Retorna o nó atual
        return atual;
    }


    public static void main(String[] args) {

        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);

        System.out.println(arvore.raiz.valor);
    }
}