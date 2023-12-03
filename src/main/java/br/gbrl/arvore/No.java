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
        return palavra
                //+ " " + linhas
                 + " " + fatBal
                ;
    }

    public void reBalance(){
        fatBal=getBalance(this);
    }

    private int height(No no) {
        if (no == null)
            return 0;
        return Math.max(height(no.esquerda), height(no.direita)) + 1;
    }

    private int getBalance(No no ) {
        if (no == null)
            return 0;
        return height(no.esquerda) - height(no.direita);
    }
}
