package br.gbrl;

import br.gbrl.arvore.Arvore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabelaHash {
    private final Arvore[] tabela;

    public TabelaHash(String[] palavrasChave) {
        tabela = new Arvore[26];
        for (String pC : palavrasChave) add(pC, 0, false);
    }

    private int h(String element) {
        return element.toUpperCase().charAt(0) - 65;
    }

    private void add(String element, int linha, boolean contem) {
        if (contem && (!contains(element))) return;

        int posicao = h(element);
        if (tabela[posicao] == null) tabela[posicao] = new Arvore();
        tabela[posicao].add(element, linha);
    }

    public void add(String[] elements, int linha) {
        for (String element : elements) add(element.toLowerCase(), linha, true);
    }

    private boolean contains(String element) {
        Arvore arvore = tabela[h(element)];
        return arvore != null && arvore.contains(element);
    }

    public void show() {
        String str = "";
        for (Arvore arvore : tabela)
            if (arvore != null) str += arvore.show();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("indice.txt"))) {
            writer.write(str.substring(0, str.length() - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
