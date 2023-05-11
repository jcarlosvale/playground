package monitoria.exercicioLinkedList;

public class Cliente {

    private String nome;
    private String cpf;
    private String numeroDoCartao;

    public Cliente(String nome, String cpf, String numeroDoCartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", numeroDoCartao='" + numeroDoCartao + '\'' +
                '}';
    }
}
