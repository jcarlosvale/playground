package tests.letscode;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
