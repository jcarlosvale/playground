package tests.letscode.simulacao;

public class Funcionario extends Object{

    private String nome;
    private int matricula;

    public Funcionario() {

    }

    public Funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double calcularSalario() {
        return 0;
    }
}
