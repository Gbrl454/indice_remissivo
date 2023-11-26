package br.gbrl;

import br.gbrl.arvore.Arvore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class TabelaHash {
    private final Arvore[] tabela;
    private final String[] palavrasChave;

    public TabelaHash(String[] palavrasChave) {
        tabela = new Arvore[26];
        this.palavrasChave = palavrasChave;
    }

    private void add(String element, int linha) {
        // Caso a palavra não exista no vetor 'palavrasChave' não continua
        if (!contains(element)) return;

        int posicao = element.toUpperCase().charAt(0) - 65;
        if (tabela[posicao] == null) tabela[posicao] = new Arvore();
        tabela[posicao].add(element, linha);
    }

    public void add(String[] elements, int linha) {
        for (String element : elements) add(element, linha);
    }

    private boolean contains(String element) {
        for (String pC : palavrasChave)
            if (Objects.equals(pC, element)) return true;
        return false;
    }

    public void show() {
        String str = "";
        for (Arvore arvore : tabela)
            if (arvore != null)
                str += arvore.show();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("indice.txt"))) {
            writer.write(str.substring(0, str.length() - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
