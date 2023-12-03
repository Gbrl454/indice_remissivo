package br.gbrl.arvore;

import java.util.Objects;

public class Arvore {
    public No raiz;

    public Arvore() {
        this.raiz = null;
    }

//    public void add(String palavra, int linha) {
//        if (raiz == null) raiz = new No(palavra, linha);
//        else raiz = add(palavra, linha, raiz);
//    }

//    private boolean add(String palavra, int linha, No raiz) {
//        if (palavra.compareTo(raiz.palavra) < 0) {
//            if (raiz.esquerda == null) raiz.esquerda = new No(palavra, linha);
//            else if (add(palavra, linha, raiz.esquerda)) {
//                raiz.fatBal++;
//                raiz = balanciamento(raiz);
//                return raiz.fatBal != 0;
//            }
//        }
//
//        if (palavra.compareTo(raiz.palavra) == 0) {
//            raiz.setLinha(linha);
//        }
//
//        if (palavra.compareTo(raiz.palavra) > 0) {
//            if (raiz.direita == null) raiz.direita = new No(palavra, linha);
//            else if (add(palavra, linha, raiz.direita)) {
//                raiz.fatBal--;
//                raiz = balanciamento(raiz);
//                return raiz.fatBal != 0;
//            }
//        }
//        return true;
//    }

    public void add(String palavra, int linha) {
        raiz = add(palavra, linha, raiz);
    }

    private No add(String palavra, int linha, No raiz) {
        if (raiz == null)
            return new No(palavra, linha);

        if (palavra.compareTo(raiz.palavra) < 0) {
            raiz.esquerda = add(palavra, linha, raiz.esquerda);
            raiz.fatBal++;
        } else if (palavra.compareTo(raiz.palavra) > 0) {
            raiz.direita = add(palavra, linha, raiz.direita);
            raiz.fatBal--;
        } else raiz.setLinha(linha);

        return balanciamento(raiz);
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

    private No balanciamento(No raiz) {
        if (raiz.fatBal == 2) {
            if (raiz.esquerda.fatBal > 0) {
                System.out.println("RDS");
                return RDS(raiz);
            } else {
                System.out.println("RDD");
                return RDD(raiz);
            }
        } else if (raiz.fatBal == -2) {
            if (raiz.direita.fatBal <= 0) {
                System.out.println("RES");
                return RES(raiz);
            } else {
                System.out.println("RED");
                return RED(raiz);
            }
        }
        return raiz;
    }

    private No RDS(No raiz) {
        No esquerda = raiz.esquerda;
        No direitaEsquerda = esquerda.direita;

        esquerda.direita = raiz;
        raiz.esquerda = direitaEsquerda;

        raiz.reBalance();
        esquerda.reBalance();

        return esquerda;
    }

    private No RES(No raiz) {
        No direita = raiz.direita;
        No esquerdaDireita = direita.esquerda;

        direita.esquerda = raiz;
        raiz.direita = esquerdaDireita;

        raiz.reBalance();
        direita.reBalance();

        return direita;
    }

    private No RDD(No raiz) {
        raiz.esquerda = RES(raiz.esquerda);
        return RDS(raiz);
    }

    private No RED(No raiz) {
        raiz.direita = RDS(raiz.direita);
        return RES(raiz);
    }

    //  RED = RDS + RES
    //  RDD = RES + RDS

//    private String min(No raiz) {
//        return (raiz.esquerda == null) ? raiz.palavra : min(raiz.esquerda);
//    }
//
//    private String max(No raiz) {
//        return (raiz.direita == null) ? raiz.palavra : max(raiz.direita);
//    }

    public boolean contains(String element) {
        return raiz != null && contains(element, raiz);
    }

    private boolean contains(String element, No raiz) {
        if (Objects.equals(element, raiz.palavra)) return true;

        if (element.compareTo(raiz.palavra) < 0) return raiz.esquerda != null && contains(element, raiz.esquerda);

        if (element.compareTo(raiz.palavra) > 0) return raiz.direita != null && contains(element, raiz.direita);

        return false;
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
