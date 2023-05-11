package monitoria.aulaHeranca;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa() {

    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 1;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        }
    }

    public int getIdade() {
        return this.idade;
    }


    void seApresente() {
        System.out.println("Me chamo " + nome + " e tenho " + idade + " anos");
    }

    boolean ehAdulto() {
        return idade >= 18;
    }
}
