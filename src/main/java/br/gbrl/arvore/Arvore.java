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
        if (raiz == null) raiz = new No(palavra, linha);
        else raiz = add(palavra, linha, raiz);
    }

    private No add(String palavra, int linha, No no) {
        if (palavra.compareTo((no.palavra)) < 0) {
            if (no.esquerda == null) {
                no.esquerda = new No(palavra, linha);
                no.fatBal++;
            } else {
                no.esquerda = add(palavra, linha, no.esquerda);
                if (no.overbalance) no.reBalance();
            }
        } else if (palavra.compareTo(no.palavra) > 0) {
            if (no.direita == null) {
                no.direita = new No(palavra, linha);
                no.fatBal--;
            } else {
                no.direita = add(palavra, linha, no.direita);
                if (no.overbalance) no.reBalance();
            }
        } else {
            no.setLinha(linha);
        }
        no = balancear(no);
        no.overbalance = (no.fatBal != 0);
        return no;
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

    private No balancear(No no) {
        if (no.fatBal == 2) {
            if (no.esquerda.fatBal <= 0) {
                no.esquerda = res(no.esquerda);
            }
            return rds(no);
        } else if (no.fatBal == -2) {
            if (no.direita.fatBal > 0) {
                no.direita = rds(no.direita);
            }
            return res(no);
        }

        //  RED = RDS + RES
        //  RDD = RES + RDS
        return no.reBalance();
    }

    private No rds(No no) {
        No esquerda = no.esquerda;

        no.esquerda = esquerda.direita;
        esquerda.direita = no;

        no.reBalance();
        esquerda.reBalance();

        return esquerda;
    }

    private No res(No raiz) {
        No direita = raiz.direita;

        raiz.direita = direita.esquerda;
        direita.esquerda = raiz;

        raiz.reBalance();
        direita.reBalance();

        return direita;
    }

    public boolean contains(String palavra) {
        return raiz != null && contains(palavra, raiz);
    }

    private boolean contains(String palavra, No raiz) {
        if (Objects.equals(palavra, raiz.palavra)) return true;

        if (palavra.compareTo(raiz.palavra) < 0) return raiz.esquerda != null && contains(palavra, raiz.esquerda);

        if (palavra.compareTo(raiz.palavra) > 0) return raiz.direita != null && contains(palavra, raiz.direita);

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

    private String see(No raiz) {
        if (raiz == null) return null;
        return "(" + see(raiz.esquerda) + " <- Raiz(" + raiz.palavra + raiz.fatBal + ") -> " + see(raiz.direita) + ")";
    }

    public String see() {
        String str =see(raiz);
        System.out.println(str);
        return str;
    }
}
