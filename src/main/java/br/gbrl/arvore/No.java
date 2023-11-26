package br.gbrl.arvore;

public class No {
    String palavra;
    No esquerda;
    No direita;
    int fatBal;
    private int ultLinha;
    private String linhas;

    public No(String palavra, int linha) {
        this.palavra = palavra;
        this.esquerda = null;
        this.direita = null;
        this.fatBal = 0;
        setLinha(linha);
    }

    public void setLinha(int linha) {
        if (linha != ultLinha) {
            if (linhas == null) linhas = String.valueOf(linha);
            else linhas += " " + linha;
            ultLinha = linha;
        }
    }

    @Override
    public String toString() {
        return palavra + " " + linhas;
    }
}
