package tests.letscode.simulacao;

public class FuncionarioAssalariado extends FuncionarioComissionado{

    private double salarioBase;

    public double calcularSalario() {
        //this , super
        return super.calcularSalario() + salarioBase;
    }
}
