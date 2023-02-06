package monitoria;

import java.io.*;

public class Pessoa {

    private String nome;
    private int idade;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, int idade) {
        this.idade = idade;
        this.nome = nome;
    }

    void imprimeIdade() {
        System.out.println("Minha idade " + idade);
    }
    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) throws IOException{
        validate(idade);
        validateNotEqualZero(idade);
        this.idade = idade;
    }

    private void validateNotEqualZero(int idade) throws IOException{
        if (idade == 0) {
            throw new IOException("Idade igual a zero");
        }
    }

    private void validate(int idade) {
        if (idade < 0) {
            throw new RuntimeException("Idade invalida");
        }
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}


