package tests.letscode;

import java.util.stream.Stream;

public class ServicePessoa {

    public static void main(String[] args) {

        System.out.println("*****************************");

        Pessoa pessoa1 = new Pessoa("Jose", 15);
        Pessoa pessoa2 = new Pessoa("Maria", 25);
        Pessoa pessoa3 = new Pessoa("Maria", 25);

        System.out.println(pessoa1);
        System.out.println(pessoa2);
        System.out.println(pessoa3);

        System.out.println(pessoa1 == pessoa2); //false
        System.out.println(pessoa1.equals(pessoa2)); //false

        System.out.println(pessoa2 == pessoa3); //true? false? --> false
        System.out.println(pessoa2.equals(pessoa3)); //true --> false?

        System.out.println("*****************************");

        Stream.of("Joao", "Jose", "Maria", "Maria")
                .map(nome -> new Pessoa(nome, nome.length()))
                //.filter(pessoa -> pessoa.getIdade() > 18)
                .distinct()
                .forEach(pessoa -> System.out.println(pessoa));

        var person0 = new Pessoa("Jose", 15);
        var person1 = new Pessoa("Jose", 15);
        System.out.println(person0.equals(person1)); //true
    }
}
