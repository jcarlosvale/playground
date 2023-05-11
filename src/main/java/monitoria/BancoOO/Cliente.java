package monitoria.BancoOO;

import java.util.List;
import java.util.Objects;

public class Cliente {

    private final Pessoa pessoa;
    private final List<Conta> contas;

    public Cliente(Pessoa pessoa, List<Conta> contas) {
        this.pessoa = pessoa;
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "pessoa=" + pessoa +
                ", contas=" + contas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(pessoa, cliente.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pessoa);
    }
}
