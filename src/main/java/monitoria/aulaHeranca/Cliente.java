package monitoria.aulaHeranca;


/**
 * Modificadores de acesso:
 * - public: visivel em todo o universo
 * - protected: pacote + via heranca (tornando privado)
 * - "pacote": visivel dentro do mesmo pacote
 * - private: visivel dentro da propria classe
 */



public class Cliente {

    private String nome;

    private int numeroConta;

    protected double saldo;

    public Cliente(final String nome, final int numeroConta) {
        this.nome = nome;
        this.numeroConta = numeroConta;
    }

    public boolean depositar(final double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }

        return false;
    }

    public boolean sacar(final double valor) {
        if ((valor > 0) && (valor <= this.saldo)) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }


    public String getNome() {
        return nome;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
}
