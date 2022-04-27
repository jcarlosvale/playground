#MONITORIA - ENCONTRO 02

##HERANCA
* Construtor padrão 
  * Assinatura sem parâmetros
* Uso do this
  * Acessar atributos. Ex: this.nome = "Joao"
  * Chamar construtor da classe: this(nome, idade)
* Implicitamente a primeira linha de codigo em um construtor: *super()*
* Cadeia de construtores: necessário executar a chamada de construtores até a classe _Object_
* Uso do **super**:
  * Semelhante ao _this_ mas aplicado à superclasse.

##EXEMPLO

###CLASSE FUNCIONARIO COMISSIONADO
### ATRIBUTOS
#### NOME (STRING)
#### MATRICULA (INT)
#### VALOR VENDAS (DOUBLE)
#### % COMISSAO (DOUBLE)

### METODOS
#### GET/SET
#### TO STRING
#### CALCULAR SALARIO: "VALOR_VENDAS * % COMISSAO"

##CLASSE FUNCIONARIO ASSALARIADO (HERDA FUNCIONARIO)
### ATRIBUTOS
#### SALARIO BASE (DOUBLE)

