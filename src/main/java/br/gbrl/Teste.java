package br.gbrl;

import br.gbrl.arvore.Arvore;

public class Teste {
    static Arvore arvore = new Arvore();

    public static void main(String[] args) {
       add("32");
       add("31");
       add("35");
       add("33");
       add("36");
       add("38");
    }

    public static void add(String element) {
        arvore.add(element, 0);
        System.out.println("Show:\n" + arvore.show());
        System.out.println("Raiz -> " + arvore.raiz);
        System.out.println("-----------------------------------------------------------");
    }
}
