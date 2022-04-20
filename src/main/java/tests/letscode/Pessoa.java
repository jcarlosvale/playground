package tests.letscode;

public class Pessoa {

    //ENCAPSULAMENTO
    private String nome;
    private int idade;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, int idade) {
        this.idade = idade;
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

//    public void setNome(String nome) {
//        this.nome = nome;
//    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        }
    }

    public String qualSeuNome(){
        return this.nome;
    }

    public int qualSuaIdade(){
        return this.idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

//    public boolean equals(Object object) {
//        Pessoa pessoa = (Pessoa) object;
//        return this.nome.equals(pessoa.nome) && (this.idade == pessoa.idade);
//    }


}
