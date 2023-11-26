package br.gbrl;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    public static long run() {
        long init = System.nanoTime();

        try (FileWriter writer = new FileWriter("MyFileWriter.txt")) {
            writer.write("1 - Seu conteúdo aqui.\n");
            writer.write("2 - Seu conteúdo aqui.\n");
            writer.write("3 - Seu conteúdo aqui.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        return end - init;
    }

}
