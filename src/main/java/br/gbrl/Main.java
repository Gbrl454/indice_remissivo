package br.gbrl;

public class Main {
    public static void main(String[] args) {
        Long init = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            LeitorArquivo.read("src/main/java/br/gbrl/arquivo.txt");
        }
        Long end = System.nanoTime();
        System.out.println((end - init) + " ns");
        System.out.println((((double) (end - init)) / 1000000) + " ms");
        System.out.println((((double) (end - init)) / 1000000000) + " s");
    }
//    public static void main(String[] args) {
//        ArrayList<ArrayList<Long>> valores = new ArrayList<>();
//        for (int i = 0; i < 3; i++) valores.add(new ArrayList<>());
//
//        int q = 1;
//        for (int i = 0; i < q; i++) {
//            System.out.println("--------------- Teste " + (i + 1) + " ---------------");
//            valores.get(0).add(LeituraArquivoIO.run());
//            valores.get(1).add(LeituraArquivoNIO.run());
//            valores.get(2).add(LeituraArquivoNIO2.run());
//            System.out.println();
//        }
//
//        System.out.println("---------------------------------------------");
//
//        Long io = 0L;
//        for (int i = 0; i < valores.get(0).size(); i++) io += valores.get(0).get(i);
//        System.out.println("Média IO   - " + io);
//
//        Long nio = 0L;
//        for (int i = 0; i < valores.get(1).size(); i++) nio += valores.get(1).get(i);
//        System.out.println("Média NIO  - " + nio);
//
//        Long nio2 = 0L;
//        for (int i = 0; i < valores.get(2).size(); i++) nio2 += valores.get(2).get(i);
//        System.out.println("Média NIO2 - " + nio2);
//    }
//
//
//    public static void read(ArrayList<String[]> texto) {
//        StringBuilder str = new StringBuilder();
//        for (String[] strings : texto) {
//            for (String string : strings) {
//                str.append(" - ").append(string);
//            }
//            str.append("\n");
//        }
//        System.out.println(str);
//    }
}