package br.gbrl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class LeituraArquivoNIO {

    public static Long run() {
        Long init = System.nanoTime();
        // Substitua o caminho do arquivo pelo caminho real do seu arquivo
        String caminhoArquivo = "src/main/java/br/gbrl/arquivo.txt";

        try (RandomAccessFile file = new RandomAccessFile(caminhoArquivo, "r");
             FileChannel channel = file.getChannel()) {

            // Tamanho do arquivo
            long fileSize = channel.size();

            // Criar um buffer do tamanho do arquivo
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);

            // Ler o conteúdo do arquivo para o buffer
            channel.read(buffer);

            // Converter o buffer para uma string
            buffer.flip(); // Prepare o buffer para leitura
            String conteudo = new String(buffer.array(), StandardCharsets.UTF_8);

            ArrayList<String[]> texto = new ArrayList<>();
            String[] txt = conteudo.split("\n");
            for (String s : txt) {
                texto.add(s.split(" "));
            }
//            Main.read(texto);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Long end = System.nanoTime();
        System.out.println("IO - " + (end - init));
        return end - init;
    }
}
