package certification.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LerArquivoComoStream {

    public static void main(String[] args) {
        String nomeArquivo =  "alunos.txt";
        try {
            Stream<String> stream = Files.lines(Paths.get(nomeArquivo));
            List<String> dados = stream.collect(Collectors.toList());
            dados.forEach(System.out::println);
            stream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
