package br.gbrl.arvore;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void add(String palavra, int linha) {
        if (raiz == null) raiz = new No(palavra, linha);
        else add(palavra, linha, raiz);
    }

    private void add(String palavra, int linha, No raiz) {
        if (palavra.compareTo(raiz.palavra) < 0) {
            if (raiz.esquerda == null) raiz.esquerda = new No(palavra, linha);
            else add(palavra, linha, raiz.esquerda);
        }

        if (palavra.compareTo(raiz.palavra) == 0) {
            raiz.setLinha(linha);
        }

        if (palavra.compareTo(raiz.palavra) > 0) {
            if (raiz.direita == null) raiz.direita = new No(palavra, linha);
            else add(palavra, linha, raiz.direita);
        }
    }

    //  Se Fb = 2
    //      Se Esquerdo.Fb > 0
    //          RDS
    //      Se não
    //          RDD
    //  Se Fb = -2
    //      Se Direito.Fb <= 0
    //          RES
    //      Se não
    //          RED

    //  RED = RDS + RES
    //  RDD = RES + RDS

    private String min(No raiz) {
        return (raiz.esquerda == null) ? raiz.palavra : min(raiz.esquerda);
    }

    private String max(No raiz) {
        return (raiz.direita == null) ? raiz.palavra : max(raiz.direita);
    }

    public String show() {
        return show(raiz);
    }

    private String show(No raiz) {
        String str = "";
        if (raiz.esquerda != null) str += show(raiz.esquerda);
        str += raiz + "\n";
        if (raiz.direita != null) str += show(raiz.direita);
        return str;
    }
}
