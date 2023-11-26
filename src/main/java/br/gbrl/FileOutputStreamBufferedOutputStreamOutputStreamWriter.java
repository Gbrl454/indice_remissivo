package br.gbrl;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamBufferedOutputStreamOutputStreamWriter {
    public static long run() {
        long init = System.nanoTime();

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("FileOutputStreamBufferedOutputStreamOutputStreamWriter.txt"));
             OutputStreamWriter osw = new OutputStreamWriter(bos, StandardCharsets.UTF_8)) {
            osw.write("1 - Seu conteúdo aqui.\n");
            osw.write("2 - Seu conteúdo aqui.\n");
            osw.write("3 - Seu conteúdo aqui.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        long end = System.nanoTime();
        return end - init;
    }

}
