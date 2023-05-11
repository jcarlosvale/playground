package monitoria.exercicioLinkedList;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static final int NUMERO_DE_VENDAS = 1000;

    public static void main(String[] args) {
        LinkedList<Cliente> clientes = new LinkedList<>();
        clientes.add(new Cliente("João", "111.111.111-11", "1111 2222 3333 4444"));
        clientes.add(new Cliente("Maria", "222.222.222-22", "4444 3333 2222 1111"));
        clientes.add(new Cliente("Pedro", "333.333.333-33", "1234 5678 9012 3456"));
        clientes.add(new Cliente("Ana", "444.444.444-44", "9876 5432 1098 7654"));
        clientes.add(new Cliente("Carlos", "555.555.555-55", "6789 0123 4567 8901"));


        LinkedList<Produto> produtos = new LinkedList<>();
        produtos.add(new Produto("Caneta", 1, 1.50));
        produtos.add(new Produto("Caderno", 2, 10.00));
        produtos.add(new Produto("Lápis", 3, 0.50));
        produtos.add(new Produto("Borracha", 4, 0.75));
        produtos.add(new Produto("Mochila", 5, 50.00));
        produtos.add(new Produto("Régua", 6, 1.00));
        produtos.add(new Produto("Tesoura", 7, 3.50));
        produtos.add(new Produto("Apontador", 8, 0.75));
        produtos.add(new Produto("Papel", 9, 5.00));
        produtos.add(new Produto("Lapiseira", 10, 2.50));


        LinkedList<Venda> vendas = new LinkedList<>();
        //preenchendo vendas
        for (int i = 1; i <= NUMERO_DE_VENDAS; i++) {
            int indiceCliente = numeroRandomico(clientes.size());
            int indiceProduto = numeroRandomico(produtos.size());
            
            Cliente cliente = clientes.get(indiceCliente);
            Produto produto = produtos.get(indiceProduto);
            int quantidade = numeroRandomico(101);
            double valorTotal = quantidade * produto.valor();
            
            vendas.add(new Venda(cliente, produto, quantidade, valorTotal));
        }

        // listar as vendas
        for (Venda venda: vendas) {
            System.out.println(venda);
        }


        calcularMaiorVenda(vendas);
        calcularMenorCompra(vendas);
    }

    private static void calcularMenorCompra(LinkedList<Venda> vendas) {
        Venda candidato = vendas.get(0);

        for(int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            if (venda.getValorTotal() <  candidato.getValorTotal()) {
                candidato = venda;
            }
        }

        System.out.println("Menor venda: "
                + candidato.getCliente().getNome() + " - " + candidato.getValorTotal());
    }

    private static void calcularMaiorVenda(LinkedList<Venda> vendas) {
        Venda candidato = vendas.get(0);

        for (Venda venda: vendas) {
            if (venda.getValorTotal() >  candidato.getValorTotal()) {
                candidato = venda;
            }
        }

        System.out.println("Maior venda: "
                + candidato.getCliente().getNome() + " - " + candidato.getValorTotal());
    }

    private static int numeroRandomico(int size) {
        var random = new Random();
        return random.nextInt(size);
    }
}
