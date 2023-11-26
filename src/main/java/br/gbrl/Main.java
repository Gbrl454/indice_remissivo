package br.gbrl;

public class Main {
    private static final int[] occ = new int[]{0, 0, 0, 0};

    public static void main(String[] args) {
        int x=5;
        for (int i = 0; i < x; i++) {
            long m1 = MyFileWriter.run();
            long m2 = EscritorArquivo.run();
            long m3 = FileOutputStreamBufferedOutputStreamOutputStreamWriter.run();
            long m4 = NIO.run();

            System.out.println("m1 - " + m1);
            System.out.println("m2 - " + m2);
            System.out.println("m3 - " + m3);
            System.out.println("m4 - " + m4);
            System.out.println();
            ocorrencia(menor(new long[]{m1, m2, m3, m4}));
        }
        System.out.println("m1 - "+(((double) occ[0]/x)*100)+"%");
        System.out.println("m2 - "+(((double) occ[1]/x)*100)+"%");
        System.out.println("m3 - "+(((double) occ[2]/x)*100)+"%");
        System.out.println("m4 - "+(((double) occ[3]/x)*100)+"%");
    }

    private static void ocorrencia(int i) {
        occ[i-1]++;
    }

    private static int menor(long[] vetor) {
        long menorValor = vetor[0];
        int m = 1;
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < menorValor) {
                menorValor = vetor[i];
                m = i + 1;
            }
        }
        return m;
    }
}
