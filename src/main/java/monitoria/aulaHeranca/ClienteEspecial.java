package monitoria.aulaHeranca;

public class ClienteEspecial extends Cliente{

    private double saldoInvestimento;

    public ClienteEspecial(final String nome, final int conta) {
        super(nome, conta);
    }

    public boolean depositar(final double valor) {
        if (valor > 0) {
            this.saldo = valor * 1.0025;
            return true;
        }
        return false;
    }

    public boolean investir(final double valor) {
        if (valor > 0) {
            this.saldoInvestimento += valor * 1.1;
            return true;
        }
        return false;
    }

    public double getSaldoInvestimento() {
        return saldoInvestimento;
    }
}
