package br.gbrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeitorArquivo {
    public static ArrayList<String[]> readOneFile(String caminhoArquivo) {
        ArrayList<String[]> texto = new ArrayList<>();
        try {
            Path path = Paths.get(caminhoArquivo);

            if (Files.size(path) < 10500) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoArquivo));

                String linha;
                while ((linha = bufferedReader.readLine()) != null)
                    texto.add(linha.split(" "));
            } else
                for (String linha : Files.readAllLines(path))
                    texto.add(linha.split(" "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return texto;
    }
}
