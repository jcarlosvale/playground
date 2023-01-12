package monitoria;

import java.io.IOException;

public class Pessoa {

    private int idade;

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
}


