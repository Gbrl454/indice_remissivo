package br.gbrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraArquivoIO {
    public static Long run() {
        Long init = System.nanoTime();
        // Substitua o caminho do arquivo pelo caminho real do seu arquivo
        String caminhoArquivo = "src/main/java/br/gbrl/arquivo.txt";

        try (FileReader fileReader = new FileReader(caminhoArquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // Ler cada linha do arquivo
            String linha;
            ArrayList<String[]> texto = new ArrayList<>();
            while ((linha = bufferedReader.readLine()) != null) {
                texto.add(linha.split(" "));
            }

//            Main.read(texto);
        } catch (IOException e) {
            // Lidar com exceções de E/S, como FileNotFoundException
            e.printStackTrace();
        }
        Long end = System.nanoTime();
        System.out.println("IO - " + (end - init));
        return end - init;
    }
}
