package monitoria.heranca;

/*
ENCAPSULAMENTO
 */
public class Principal {

    public static void main(String[] args) {

        Pessoa pessoa; //variável de referência ou instância

        pessoa = new Pessoa(); //inicializando um objeto, construtor

        //pessoa.nome = "Jose";
        pessoa.setIdade(10);

        pessoa.seApresente();

       // System.out.println("Idade: " + pessoa.getIdade());
    }
}
