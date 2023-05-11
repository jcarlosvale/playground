package monitoria.teste;

import monitoria.aulaHeranca.Cliente;
import monitoria.aulaHeranca.ClienteComum;
import monitoria.aulaHeranca.ClienteEspecial;

public class PessoaTesteMain {

    public static void main(String[] args) {

        Cliente clienteJoao = new ClienteComum("Joao", 1);
        clienteJoao.depositar(10_000);

        Cliente clienteMaria = new ClienteEspecial("Maria", 2);
        clienteMaria.depositar(10_000);


        if (clienteMaria instanceof ClienteEspecial) {
            ClienteEspecial especial = (ClienteEspecial) clienteMaria;
            especial.investir(1000);
        }

        System.out.println(((ClienteEspecial)clienteMaria).getSaldoInvestimento());




//        System.out.println("Saldo Joao: " + clienteJoao.getSaldo());
//        System.out.println("Saldo Maria: " + clienteMaria.getSaldo());
    }
}
