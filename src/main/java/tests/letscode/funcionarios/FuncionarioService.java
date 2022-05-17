package tests.letscode.funcionarios;

public class FuncionarioService {


     public static void main(String[] args) {

        FuncionarioComissionado x = new FuncionarioComissionado("Joao", 1, 1000.0, 0.1);

        System.out.println(x.calcularSalario());

    }
}
