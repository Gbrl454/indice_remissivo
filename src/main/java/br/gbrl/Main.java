package br.gbrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;

public class Main {
    public static void main(String[] args) {
        long init = System.nanoTime();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Arquivo de palavras chaves...");
//        String pathPalavrasChave = sc.next();
//        System.out.println("Arquivo de texto...");
//        String pathTexto = sc.next();

        String pathPalavrasChave = "palavras-chave.txt";
        String pathTexto = "texto.txt";

        TabelaHash tabela = new TabelaHash(getPalavrasChave(pathPalavrasChave));

        Path path = Paths.get(pathTexto);

        int i = 1;
        try {
            for (String linha : Files.readAllLines(path)) {
                String[] palavrasArray = clearText(linha).split("\\s+");
                if (palavrasArray.length > 0) tabela.add(palavrasArray, i++);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tabela.show();
        System.out.println("Tempo de execução -> " + (System.nanoTime() - init) + " ns");
    }

    private static String clearText(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").replaceAll("[,.]", "");
    }

    private static String[] getPalavrasChave(String pathPalavrasChave) {
        String texto = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathPalavrasChave))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) texto += clearText(linha) + " ";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return texto.split(" ");
    }
}
