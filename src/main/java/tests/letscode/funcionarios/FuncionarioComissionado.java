package tests.letscode.funcionarios;

public class FuncionarioComissionado extends Object{

    private String nome;
    private int matricula;
    private double vendas;
    private double comissao;


    public double calcularSalario(){
        return vendas * comissao;
    }

//    public FuncionarioComissionado(){
//
//    }

    public FuncionarioComissionado(final String nome, final int matricula, final double vendas, final double comissao) {
        this(nome, matricula); //chamar o construtor que recebe nome e matricula, so chamado dentro de construtor
        this.vendas = vendas;
        this.comissao = comissao;
    }

    public FuncionarioComissionado(final String nome, final int matricula) {
        super();
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(final double vendas) {
        this.vendas = vendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(final double comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return "FuncionarioComissionado{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", vendas=" + vendas +
                ", comissao=" + comissao +
                '}';
    }


}
