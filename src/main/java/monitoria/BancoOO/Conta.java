package monitoria.BancoOO;

import java.util.Objects;

public class Conta {
    private final String numeroConta;
    private final TipoDeConta tipoDeConta;

    public Conta(Pessoa titular, String numeroConta, TipoDeConta tipoDeConta) {
        this.numeroConta = numeroConta;
        this.tipoDeConta = tipoDeConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(numeroConta, conta.numeroConta) && tipoDeConta == conta.tipoDeConta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroConta, tipoDeConta);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", tipoDeConta=" + tipoDeConta +
                '}';
    }
}
