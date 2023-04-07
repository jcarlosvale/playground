package monitoria;

import java.util.Scanner;

public class CalculoDeVolume {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite opcao: ");
        System.out.println("A-Paralelepípedo");
        System.out.println("B-Cilindro");
        System.out.println("C-Esfera");
        System.out.print("Opcao: ");
        char opcao = scanner.nextLine().toUpperCase().charAt(0);

        String palavra =
                switch (opcao) {
                    case 'A' -> "ABACATE";
                    case 'C' -> "CASA";
                    default -> "ERROU";
                };

        System.out.println(palavra);
    }

}
