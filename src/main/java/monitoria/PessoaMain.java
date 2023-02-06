package monitoria;

import java.util.*;

public class PessoaMain {

    private static List<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {


        Pessoa p1 = new Pessoa("Jose", 10);
        Pessoa p2 = new Pessoa("Eduardo", 10);
        Pessoa p3 = new Pessoa("Jaine", 10);

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);


        System.out.println(pessoas);


    }
}
