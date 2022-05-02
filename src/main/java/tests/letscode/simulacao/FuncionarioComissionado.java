package tests.letscode.simulacao;

public class FuncionarioComissionado extends Funcionario{

    private double comissao;
    private double valorVendas;


    public double calcularSalario() {
        return comissao * valorVendas;
    }


    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }
}
