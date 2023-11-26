package br.gbrl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivoNIO2 {
    public static Long run() {
        Long init = System.nanoTime();
        // Substitua o caminho do arquivo pelo caminho real do seu arquivo
        String caminhoArquivo = "src/main/java/br/gbrl/arquivo.txt";

        // Criar um objeto Path usando o caminho do arquivo
        Path path = Paths.get(caminhoArquivo);

        try {
            // Ler todas as linhas do arquivo para uma lista de Strings
            List<String> linhas = Files.readAllLines(path);

            ArrayList<String[]> texto = new ArrayList<>();
            for (String linha : linhas) {
                texto.add(linha.split(" "));
            }
//            Main.read(texto);

        } catch (IOException e) {
            // Lidar com exceções de E/S, como FileNotFoundException
            e.printStackTrace();
        }
        Long end = System.nanoTime();
        System.out.println("NIO2 - " + (end - init));
        return end - init;
    }
}
