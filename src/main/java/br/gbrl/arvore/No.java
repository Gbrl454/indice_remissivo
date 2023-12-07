package br.gbrl.arvore;

public class No {
    No esquerda;
    No direita;
    int fatBal;
    String palavra;
    boolean overbalance;
    int ultLinha;
    String linhas;

    public No(String palavra,int linha) {
        this.palavra = palavra;
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
        return palavra
                + " " + linhas
                //+ " " + fatBal
                ;
    }

    public No reBalance() {
        fatBal = altura(esquerda) - altura(direita);
        return this;
    }

    private int altura(No no) {
        if (no == null) return 0;
        return Math.max(altura(no.esquerda), altura(no.direita)) + 1;
    }
}
