package monitoria;

import java.util.Scanner;

public class Dicas {

    public static void main(String[] args) {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);

        String nome = "", cargo = "";
        double salario = 0;
        int qtdFilhos = 0, qtdHorasExtras = 0;

        while (!sair) {
            System.out.println("1 - Dados do Empregado");
            System.out.println("2 - Calcular Salário");
            System.out.println("3 - Exibir Dados");
            System.out.println("4 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Nome: ");
                    nome = scanner.next();
                    System.out.println("Cargo: ");
                    cargo = scanner.next();
                    System.out.println("Salario: ");
                    salario = scanner.nextDouble();
                    System.out.println("Qtd Filhos: ");
                    qtdFilhos = scanner.nextInt();
                    System.out.println("Qtd Hora Extra: ");
                    qtdHorasExtras = scanner.nextInt();
                    break;
                case 2:
                    salario = salario + qtdFilhos * 250 + qtdHorasExtras * 100;
                    break;
                case 3:
                    System.out.println("Nome: " + nome);
                    System.out.println("Cargo: " + cargo);
                    System.out.println("Salario: " + salario);
                    break;
            }
            sair = (opcao == 4);
        }
    }
}
