package tests.letscode.simulacao;

public class FuncionarioServico {

    public static void main(String[] args) {
        Professor professor = new Professor();

        professor.setNome("Pedro");

        System.out.println(professor.getNome());
        System.out.println(professor.calcularSalario());

    }
}
