package br.gbrl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {
    public static long run() {
        long init = System.nanoTime();

        try (FileChannel channel = new FileOutputStream("NIO.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.wrap("1 - Seu conteúdo aqui.\n2 - Seu conteúdo aqui.\n3 - Seu conteúdo aqui.".getBytes());
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        return end - init;
    }

}
