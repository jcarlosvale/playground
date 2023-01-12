package monitoria;

public class PessoaMain {

    public static void main(String[] args) {
        var pessoa = new Pessoa();

        //pessoa.setIdade(10);

        System.out.println(pessoa.getIdade());

        pessoa.imprimeIdade();
    }
}
