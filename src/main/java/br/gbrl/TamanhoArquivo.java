package br.gbrl;

import java.io.IOException;
import java.nio.file.*;

public class TamanhoArquivo {

    public static void main(String[] args) {
        // Substitua o caminho do arquivo pelo caminho real do seu arquivo
        String caminhoArquivo = "src/main/java/br/gbrl/arquivo.txt";

        // Criar um objeto Path usando o caminho do arquivo
        Path path = Paths.get(caminhoArquivo);

            // Obter o tamanho do arquivo em bytes
        long tamanhoArquivo = 0;
        try {
            tamanhoArquivo = Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Exibir o tamanho do arquivo
            System.out.println("Tamanho do arquivo: " + tamanhoArquivo + " bytes");
    }
}

