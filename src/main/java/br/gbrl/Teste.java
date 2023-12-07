package br.gbrl;

import br.gbrl.arvore.Arvore;

import java.util.Objects;

public class Teste {
    static Arvore avlTree = new Arvore();
    static double c=0;
    static double req=0;

    public static void main(String[] args) {
        long init = System.nanoTime();

        add("Manzanita");
        add("Plátano");
        add("Uva");
        add("Kiwi");
        add("Mango");
        add("Sandía");
        add("Fresa");
        add("Piña");
        add("Cereza");
        add("Papaya");
        add("Limón");
        add("Naranja");
        add("Melocotón");
        add("Granada");
        add("Frambuesa");
        add("Moras");
        add("Mandarina");
        add("Pomelo");
        add("Guayaba");
        add("Carambola");
        add("Maracuyá");
        add("Melón");
        add("Níspero");
        add("Higo");
        add("Pera");
        add("Ciruela");
        add("Grosella");
        add("Arándano");
        add("Lichi");
        add("Pitahaya");
        add("Acerola");
        add("Nashi");
        add("Mamey");
        add("Rambután");
        add("Tamarindo");

        System.out.println(System.nanoTime()-init);
        System.out.println(Objects.equals(avlTree.see(), "(((((null <- Raiz(Acerola0) -> null) <- Raiz(Arándano0) -> (null <- Raiz(Carambola0) -> null)) <- Raiz(Cereza0) -> ((null <- Raiz(Ciruela0) -> null) <- Raiz(Frambuesa1) -> null)) <- Raiz(Fresa-1) -> (((null <- Raiz(Granada-1) -> (null <- Raiz(Grosella0) -> null)) <- Raiz(Guayaba1) -> (null <- Raiz(Higo0) -> null)) <- Raiz(Kiwi0) -> ((null <- Raiz(Lichi0) -> null) <- Raiz(Limón-1) -> ((null <- Raiz(Mamey0) -> null) <- Raiz(Mandarina1) -> null)))) <- Raiz(Mango0) -> (((null <- Raiz(Manzanita-1) -> (null <- Raiz(Maracuyá0) -> null)) <- Raiz(Melocotón0) -> ((null <- Raiz(Melón0) -> null) <- Raiz(Moras1) -> null)) <- Raiz(Naranja-1) -> ((((null <- Raiz(Nashi0) -> null) <- Raiz(Níspero1) -> null) <- Raiz(Papaya0) -> ((null <- Raiz(Pera0) -> null) <- Raiz(Pitahaya0) -> (null <- Raiz(Piña0) -> null))) <- Raiz(Plátano0) -> ((null <- Raiz(Pomelo-1) -> (null <- Raiz(Rambután0) -> null)) <- Raiz(Sandía0) -> ((null <- Raiz(Tamarindo0) -> null) <- Raiz(Uva1) -> null)))))"));
        System.out.println(c+" | "+req+" | "+c/req);
    }

    public static void add(String data) {
        avlTree.add(data,0);
        req++;

    }
}
