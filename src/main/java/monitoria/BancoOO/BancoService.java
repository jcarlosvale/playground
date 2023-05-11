package monitoria.BancoOO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BancoService {

    Set<Cliente> clientesDoBanco = new HashSet<>();

    Map<Pessoa, Cliente> mapaPessoasCadastradas = new HashMap<>();

    private String gerarNumeroConta() {
        return Integer.toString(clientesDoBanco.size() + 1);
    }

    public Cliente abrirContaPF(final String nome, final String cpf) {

        final Pessoa pessoa = new PessoaFisica(nome, cpf);

        if(!mapaPessoasCadastradas.containsKey(pessoa)) {
            final String numeroConta = gerarNumeroConta();
            final Conta corrente = new Conta(pessoa, numeroConta,TipoDeConta.CORRENTE);
            final Conta poupanca = new Conta(pessoa, numeroConta,TipoDeConta.POUPANCA);
            final Conta investimento = new Conta(pessoa, numeroConta,TipoDeConta.INVESTIMENTO);
            final Cliente cliente = new Cliente(pessoa, List.of(corrente, poupanca, investimento));
            mapaPessoasCadastradas.put(pessoa, cliente);
            return cliente;
        } else {
            return mapaPessoasCadastradas.get(pessoa);
        }
    }

    public Conta abrirContaPJ(final String razaoSocial, final String cnpj) {

    }



}
