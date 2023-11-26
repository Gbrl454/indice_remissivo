package br.gbrl;

public class SeparadorPalavras {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();
        String texto = "Good programming is not learned from generalities, but by seeing how significant programs can be made clean, easy to read, easy to maintain and modify, human-engineered, efficient, and reliable, by the application of common sense and by the use of good programming practices.";

        texto = texto.replaceAll("[^a-zA-Z ]", "");

        String[] palavrasArray = texto.split("\\s+");

        for (String palavra : palavrasArray)
            if (!palavra.isEmpty())
                tabelaHash.add(palavra);

        tabelaHash.show();
    }
}
