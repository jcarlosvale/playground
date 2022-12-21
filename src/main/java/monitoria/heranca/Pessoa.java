package monitoria.heranca;

import java.time.LocalDate;

/**
 * Classe: atributos ou metodos
 * Atributos: caracteristicas
 * Metodos: acoes da classe
 */
//escopo de variavel ??
//modificadores de acesso: PUBLIC, PROTECTED, <DEFAULT>, PRIVATE
public class Pessoa {

    //atributos, this
    private String nome;
    private String cpf;

    private int idade;

    private LocalDate dataNascimento;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    //metodo: funcao (tem retorno), procedimento (nao tem retorno)
    //assinatura de metodo: tipo_retorno nome_metodo(_parametros_)
    public void seApresente() {
        System.out.println("Meu nome eh " + this.nome);
        System.out.println("Tenho " + this.idade + " anos");
    }
}
