package tests.letscode;

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





    }

}
