package monitoria.exercicioLinkedList;

public class Venda {

    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Venda(Cliente cliente, Produto produto, int quantidade, double valorTotal) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cliente=" + cliente +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
