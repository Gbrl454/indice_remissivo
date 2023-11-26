package br.gbrl.moldes;

import java.util.ArrayList;

public class TabelaHashEF {
    private final ArrayList[] tabela;

    public TabelaHashEF() {
        tabela = new ArrayList[26];
    }

    public void add(String element) {
        int posicao = element.toUpperCase().charAt(0) - 65;
        if (tabela[posicao] == null) tabela[posicao] = new ArrayList<String>();
        tabela[posicao].add(element);
    }

    public void show(){
        for (int i = 0; i < tabela.length; i++){
            System.out.println(tabela[i]);
        }
    }
}
