package util;

import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    @ToString
    static class Campo {
        String nomeBanco;
        String type;
        boolean isNull;
    }

    static Map<String, String > mapReplace;

    static {
        mapReplace = new HashMap<>();
        mapReplace.put("des_", "descricao ");
        mapReplace.put("dat_", "data ");
        mapReplace.put("qtd_", "quantidade ");
        mapReplace.put("cod_", "codigo ");
        mapReplace.put("tip_", "tipo ");
        mapReplace.put("flg_", "flag ");
        mapReplace.put("num_", "numero ");
        mapReplace.put("prc_", "preco ");
    }

    static List<Campo> getCampos() {
        List<Campo> result = new ArrayList<>();
        String campos =
                        "    isn_fornecedor SERIAL PRIMARY KEY NOT NULL,\n" +
                        "    des_razao_social varchar(35) NULL,\n" +
                        "    des_nome_fantasia varchar(25) NULL,\n" +
                        "    num_cnpj_cpf varchar(14) NULL,\n" +
                        "    num_inscricao_estadual varchar(15) NULL,\n" +
                        "    num_rg varchar(15) NULL,\n" +
                        "    des_rua varchar(35) NULL,\n" +
                        "    des_numero_rua varchar(10) NULL,\n" +
                        "    des_complemento varchar(25) NULL,\n" +
                        "    des_bairro varchar(25) NULL,\n" +
                        "    des_cidade varchar(25) NULL,\n" +
                        "    des_uf varchar(2) NULL,\n" +
                        "    num_cep varchar(8) NULL,\n" +
                        "    num_fone varchar(20) NULL,\n" +
                        "    des_email varchar(45) NULL,\n" +
                        "    cod_ibge int NULL,\n" +
                        "    nom_contato varchar(25) NULL,\n" +
                        "    des_observacao varchar(500) NULL,\n" +
                        "    flg_bloqueado boolean NOT NULL";

        for(String linha : campos.split(",")) {
            String [] values = linha.trim().split(" ");

            Campo campo = new Campo();
            campo.nomeBanco = values[0].trim();
            campo.type = values[1].trim();
            campo.isNull = values.length == 3;

            result.add(campo);
        }

        return result;
    }

    static List<Campo> getCampos2() {
        List<Campo> result = new ArrayList<>();
        String campos =
                "    cod_produto int NOT NULL,\n" +
                "    des_produto varchar(40) NULL,\n" +
                "    des_resumida varchar(24) NULL,\n" +
                "    des_completa varchar(60) NULL,\n" +
                "    des_apresentacao varchar(25) NULL,\n" +
                "    des_concentracao varchar(25) NULL,\n" +
                "    dat_implantacao smalldatetime NULL,\n" +
                "    des_unidade_venda varchar(3) NULL,\n" +
                "    des_unidade_compra varchar(3) NULL,\n" +
                "    qtd_fracao_venda int NULL,\n" +
                "    cod_classificacao varchar(7) NULL,\n" +
                "    cod_fabricante int NOT NULL,\n" +
                "    cod_substacia_basica int NULL,\n" +
                "    cod_gupo_preco char(1) NOT NULL,\n" +
                "    cod_ean varchar(14) NULL,\n" +
                "    cod_produto_grade int NULL,\n" +
                "    tip_controle_preco varchar(1) NULL,\n" +
                "    tip_lista varchar(1) NULL,\n" +
                "    tip_controle_venda varchar(1) NULL,\n" +
                "    tip_receita varchar(2) NULL,\n" +
                "    tip_origem_mercadoria varchar(1) NULL,\n" +
                "    tip_produto varchar(2) NULL,\n" +
                "    flg_preco_tabelado bit NOT NULL,\n" +
                "    flg_imprime_etiqueta bit NOT NULL,\n" +
                "    qtd_embalagem_venda int NULL,\n" +
                "    num_registro_ms varchar(20) NULL,\n" +
                "    cod_ncm varchar(12) NULL,\n" +
                "    prc_referencia_farmacia_popular numeric(18, 4) NULL,\n" +
                "    flg_uso_continuo bit NULL,\n" +
                "    cod_cest varchar(7) NULL,\n" +
                "    tip_medicamento char(1) NULL,\n" +
                "    flg_controla_lote bit NOT NULL,\n" +
                "    flg_fora_linha bit NOT NULL";

        for(String linha : campos.split(",")) {
            String [] values = linha.trim().split(" ");

            Campo campo = new Campo();
            campo.nomeBanco = values[0].trim();
            campo.type = values[1].trim();
            campo.isNull = values.length == 3;

            result.add(campo);
        }

        return result;
    }

    static String getEntityFields() {
        return "    @Id\n" +
                "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
                "    @Column(name=\"isn_fornecedor\")\n" +
                "    @NotNull(message = \"O id fornecedor nao pode ser nulo\")\n" +
                "    private Integer id;\n" +
                "\n" +
                "    @Column(name=\"des_razao_social\")\n" +
                "    @Size(max=35, message = \"Tamanho maximo descricao razao social de 35 caracteres\")\n" +
                "    private String descricaoRazaoSocial;\n" +
                "\n" +
                "    @Column(name=\"des_nome_fantasia\")\n" +
                "    @Size(max=25, message = \"Tamanho maximo descricao nome fantasia de 25 caracteres\")\n" +
                "    private String descricaoNomeFantasia;\n" +
                "\n" +
                "    @Column(name=\"num_cnpj_cpf\")\n" +
                "    @Size(max=14, message = \"Tamanho maximo numero cnpj cpf de 14 caracteres\")\n" +
                "    private String numeroCnpjCpf;\n" +
                "\n" +
                "    @Column(name=\"num_inscricao_estadual\")\n" +
                "    @Size(max=15, message = \"Tamanho maximo numero inscricao estadual de 15 caracteres\")\n" +
                "    private String numeroInscricaoEstadual;\n" +
                "\n" +
                "    @Column(name=\"num_rg\")\n" +
                "    @Size(max=15, message = \"Tamanho maximo numero rg de 15 caracteres\")\n" +
                "    private String numeroRg;\n" +
                "\n" +
                "    @Column(name=\"des_rua\")\n" +
                "    @Size(max=35, message = \"Tamanho maximo descricao rua de 35 caracteres\")\n" +
                "    private String descricaoRua;\n" +
                "\n" +
                "    @Column(name=\"des_numero_rua\")\n" +
                "    @Size(max=10, message = \"Tamanho maximo descricao numero rua de 10 caracteres\")\n" +
                "    private String descricaoNumeroRua;\n" +
                "\n" +
                "    @Column(name=\"des_complemento\")\n" +
                "    @Size(max=25, message = \"Tamanho maximo descricao complemento de 25 caracteres\")\n" +
                "    private String descricaoComplemento;\n" +
                "\n" +
                "    @Column(name=\"des_bairro\")\n" +
                "    @Size(max=25, message = \"Tamanho maximo descricao bairro de 25 caracteres\")\n" +
                "    private String descricaoBairro;\n" +
                "\n" +
                "    @Column(name=\"des_cidade\")\n" +
                "    @Size(max=25, message = \"Tamanho maximo descricao cidade de 25 caracteres\")\n" +
                "    private String descricaoCidade;\n" +
                "\n" +
                "    @Column(name=\"des_uf\")\n" +
                "    @Size(max=2, message = \"Tamanho maximo descricao uf de 2 caracteres\")\n" +
                "    private String descricaoUf;\n" +
                "\n" +
                "    @Column(name=\"num_cep\")\n" +
                "    @Size(max=8, message = \"Tamanho maximo numero cep de 8 caracteres\")\n" +
                "    private String numeroCep;\n" +
                "\n" +
                "    @Column(name=\"num_fone\")\n" +
                "    @Size(max=20, message = \"Tamanho maximo numero fone de 20 caracteres\")\n" +
                "    private String numeroFone;\n" +
                "\n" +
                "    @Column(name=\"des_email\")\n" +
                "    @Size(max=45, message = \"Tamanho maximo descricao email de 45 caracteres\")\n" +
                "    private String descricaoEmail;\n" +
                "\n" +
                "    @Column(name=\"cod_ibge\")\n" +
                "    @Positive(message = \"O codigo ibge deve ser positivo\")\n" +
                "    private Integer codigoIbge;\n" +
                "\n" +
                "    @Column(name=\"nom_contato\")\n" +
                "    @Size(max=25, message = \"Tamanho maximo nom contato de 25 caracteres\")\n" +
                "    private String nomContato;\n" +
                "\n" +
                "    @Column(name=\"des_observacao\")\n" +
                "    @Size(max=500, message = \"Tamanho maximo descricao observacao de 500 caracteres\")\n" +
                "    private String descricaoObservacao;\n" +
                "\n" +
                "    @Column(name=\"flg_bloqueado\")\n" +
                "    @NotNull(message = \"O flag bloqueado nao pode ser nulo\")\n" +
                "    private Boolean flagBloqueado;";
    }

    static String getEntityFields2() {
        return
                        "    @Size(max=7, message = \"Tamanho maximo do codigo produto de 7 caracteres\")\n" +
                        "    @NotBlank(message=\"Codigo produto nao pode ser nulo ou vazio\")\n" +
                        "    @Column(name=\"cod_produto\", unique = true)\n" +
                        "    private Long codigoProduto;\n" +
                        "\n" +
                        "    @Column(name=\"des_produto\")\n" +
                        "    @Size(max=40, message = \"Tamanho maximo descricao produto de 40 caracteres\")\n" +
                        "    private String descricaoProduto;\n" +
                        "\n" +
                        "    @Column(name=\"des_resumida\")\n" +
                        "    @Size(max=24, message = \"Tamanho maximo descricao resumida de 24 caracteres\")\n" +
                        "    private String descricaoResumida;\n" +
                        "\n" +
                        "    @Column(name=\"des_completa\")\n" +
                        "    @Size(max=60, message = \"Tamanho maximo descricao completa de 60 caracteres\")\n" +
                        "    private String descricaoCompleta;\n" +
                        "\n" +
                        "    @Column(name=\"des_apresentacao\")\n" +
                        "    @Size(max=25, message = \"Tamanho maximo descricao apresentacao de 25 caracteres\")\n" +
                        "    private String descricaoApresentacao;\n" +
                        "\n" +
                        "    @Column(name=\"des_concentracao\")\n" +
                        "    @Size(max=25, message = \"Tamanho maximo descricao concentracao de 25 caracteres\")\n" +
                        "    private String descricaoConcentracao;\n" +
                        "\n" +
                        "    @Column(name=\"dat_implantacao\")\n" +
                        "    private LocalDateTime dataImplantacao;\n" +
                        "\n" +
                        "    @Column(name=\"des_unidade_venda\")\n" +
                        "    @Size(max=3, message = \"Tamanho maximo descricao unidade venda de 3 caracteres\")\n" +
                        "    private String descricaoUnidadeVenda;\n" +
                        "\n" +
                        "    @Column(name=\"des_unidade_compra\")\n" +
                        "    @Size(max=3, message = \"Tamanho maximo descricao unidade compra de 3 caracteres\")\n" +
                        "    private String descricaoUnidadeCompra;\n" +
                        "\n" +
                        "    @Column(name=\"qtd_fracao_venda\")\n" +
                        "    @Positive(message = \"O quantidade fracao venda deve ser positivo\")\n" +
                        "    private Integer quantidadeFracaoVenda;\n" +
                        "\n" +
                        "    @ManyToOne(fetch = FetchType.LAZY)\n" +
                        "    @JoinColumn(name=\"cod_classificacao\")\n" +
                        "    private ClassificacaoEntity classificacaoEntity;\n" +
                        "\n" +
                        "    @ManyToOne(fetch = FetchType.LAZY)\n" +
                        "    @JoinColumn(name=\"fabricante_id\")\n" +
                        "    private FabricanteEntity fabricanteEntity;\n" +
                        "\n" +
                        "    @JoinColumn(name=\"substancias_basicas_id\")\n" +
                        "    @ManyToOne(fetch = FetchType.LAZY)\n" +
                        "    private SubstanciasBasicasEntity substanciasBasicasEntity;\n" +
                        "\n" +
                        "    @Column(name=\"cod_grupo_preco\")\n" +
                        "    @Size(max=1, message = \"Tamanho maximo codigo grupo preco de 1 caracteres\")\n" +
                        "    @NotBlank(message = \"O codigo grupo preco nao pode ser nulo ou vazio\")\n" +
                        "    private String codigoGrupoPreco;\n" +
                        "\n" +
                        "    @JoinColumn(name=\"produto_ean_id\")\n" +
                        "    @OneToOne(fetch = FetchType.LAZY)\n" +
                        "    private ProdutoEANEntity produtoEANEntity;\n" +
                        "\n" +
                        "    @Column(name=\"cod_produto_grade\")\n" +
                        "    @Positive(message = \"O codigo produto grade deve ser positivo\")\n" +
                        "    private Integer codigoProdutoGrade;\n" +
                        "\n" +
                        "    @Column(name=\"tip_controle_preco\")\n" +
                        "    @Size(max=1, message = \"Tamanho maximo tipo controle preco de 1 caracteres\")\n" +
                        "    private String tipoControlePreco;\n" +
                        "\n" +
                        "    @Column(name=\"tip_lista\")\n" +
                        "    @Size(max=1, message = \"Tamanho maximo tipo lista de 1 caracteres\")\n" +
                        "    private String tipoLista;\n" +
                        "\n" +
                        "    @Column(name=\"tip_controle_venda\")\n" +
                        "    @Size(max=1, message = \"Tamanho maximo tipo controle venda de 1 caracteres\")\n" +
                        "    private String tipoControleVenda;\n" +
                        "\n" +
                        "    @Column(name=\"tip_receita\")\n" +
                        "    @Size(max=2, message = \"Tamanho maximo tipo receita de 2 caracteres\")\n" +
                        "    private String tipoReceita;\n" +
                        "\n" +
                        "    @Column(name=\"tip_origem_mercadoria\")\n" +
                        "    @Size(max=1, message = \"Tamanho maximo tipo origem mercadoria de 1 caracteres\")\n" +
                        "    private String tipoOrigemMercadoria;\n" +
                        "\n" +
                        "    @Column(name=\"tip_produto\")\n" +
                        "    @Size(max=2, message = \"Tamanho maximo tipo produto de 2 caracteres\")\n" +
                        "    private String tipoProduto;\n" +
                        "\n" +
                        "    @Column(name=\"flg_preco_tabelado\")\n" +
                        "    @NotNull(message = \"O flag preco tabelado nao pode ser nulo\")\n" +
                        "    private Boolean flagPrecoTabelado;\n" +
                        "\n" +
                        "    @Column(name=\"flg_imprime_etiqueta\")\n" +
                        "    @NotNull(message = \"O flag imprime etiqueta nao pode ser nulo\")\n" +
                        "    private Boolean flagImprimeEtiqueta;\n" +
                        "\n" +
                        "    @Column(name=\"qtd_embalagem_venda\")\n" +
                        "    @Positive(message = \"O quantidade embalagem venda deve ser positivo\")\n" +
                        "    private Integer quantidadeEmbalagemVenda;\n" +
                        "\n" +
                        "    @Column(name=\"num_registro_ms\")\n" +
                        "    @Size(max=20, message = \"Tamanho maximo numero registro ms de 20 caracteres\")\n" +
                        "    private String numeroRegistroMs;\n" +
                        "\n" +
                        "    @Column(name=\"cod_ncm\")\n" +
                        "    @Size(max=12, message = \"Tamanho maximo codigo ncm de 12 caracteres\")\n" +
                        "    private String codigoNcm;\n" +
                        "\n" +
                        "    @Column(name=\"prc_referencia_farmacia_popular\")\n" +
                        "    @NotNull(message = \"O preco referencia farmacia popular nao pode ser nulo\")\n" +
                        "    private BigDecimal precoReferenciaFarmaciaPopular;\n" +
                        "\n" +
                        "    @Column(name=\"flg_uso_continuo\")\n" +
                        "    private Boolean flagUsoContinuo;\n" +
                        "\n" +
                        "    @Column(name=\"cod_cest\")\n" +
                        "    @Size(max=7, message = \"Tamanho maximo codigo cest de 7 caracteres\")\n" +
                        "    private String codigoCest;\n" +
                        "\n" +
                        "    @Column(name=\"tip_medicamento\")\n" +
                        "    @Size(max=1, message = \"Tamanho maximo tipo medicamento de 1 caracteres\")\n" +
                        "    private String tipoMedicamento;\n" +
                        "\n" +
                        "    @Column(name=\"flg_controla_lote\")\n" +
                        "    @NotNull(message = \"O flag controla lote nao pode ser nulo\")\n" +
                        "    private Boolean flagControlaLote;\n" +
                        "\n" +
                        "    @Column(name=\"flg_fora_linha\")\n" +
                        "    @NotNull(message = \"O flag fora linha nao pode ser nulo\")\n" +
                        "    private Boolean flagForaLinha;";
    }

    private static void generateBuilder(String[] entityFields, String fromObject) {
        for(String str : entityFields) {
            if (str.trim().startsWith("@") || str.trim().length() < 5) continue;
            String result = ".";
            String [] fields = str.trim().split(" ");
            result += fields[2].replace(";","(");
            result += fromObject + ".get" + fields[2].substring(0,1).toUpperCase() + fields[2].replace(";", "())").substring(1);
            System.out.println(result);
        }

    }

    private static String generateAttribute(Campo campo) {
        String attribute = "";
        String nameWithoutUnderscore = replaceUnderscore(campo.nomeBanco);
        var type = replaceType(campo.type);
        attribute += "@Column(name=\"" + campo.nomeBanco + "\")\n";

        if ("String".equals(type)) {
            var size =
                    campo.type.substring(
                            campo.type.indexOf("(") + 1,
                            campo.type.indexOf(")"));
            attribute +=
                    "@Size(max="+size+
                    ", message = \"Tamanho maximo "+ nameWithoutUnderscore
                            + " de "+ size + " caracteres\")\n";
        }

        if("Integer".equals(type) || "Long".equals(type)) {
            attribute +=
                    "@Positive(message = \"O " + nameWithoutUnderscore + " deve ser positivo\")\n";
        }

        if (!campo.isNull) {
            if ("String".equals(type)) {
                attribute +=
                        "@NotBlank(message = \"O "+ nameWithoutUnderscore + " nao pode ser nulo ou vazio\")\n";
            } else {
                attribute +=
                        "@NotNull(message = \"O "+ nameWithoutUnderscore + " nao pode ser nulo\")\n";
            }
        }

        attribute += generateAttributeText(campo);

        return attribute;
    }

    private static String generateAttributeText(Campo campo) {
        var type = replaceType(campo.type);
        var name = attributeName(campo.nomeBanco);
        return "private " + type + " " + name + ";";
    }

    private static String attributeName(String nomeBanco) {
        String name = replaceUnderscore(nomeBanco);
        String [] campos = name.split(" ");
        name = campos[0];
        for(int i = 1; i < campos.length; i++) {
            name += campos[i].substring(0, 1).toUpperCase() + campos[i].substring(1);
        }
        return name;
    }

    private static String replaceType(String type) {
        switch (type) {
            case "int": return "Integer";
            case "boolean":
            case "bit":
                return "Boolean";
            case "smalldatetime": return "LocalDateTime";
        }

        if (type.contains("varchar")) return "String";
        if (type.contains("numeric")) return "BigDecimal";
        if (type.contains("char")) return "String";

        return null;
    }

    private static String replaceUnderscore(String nomeBanco) {
        for(var key: mapReplace.keySet()) {
            nomeBanco = nomeBanco.replace(key, mapReplace.get(key));
        }

        nomeBanco = nomeBanco.replace("_", " ");
        return nomeBanco;
    }

    public static void main(String[] args) {
        //ENTITY
//        var campos = getCampos();
//
//        for(Campo campo : campos) {
//            System.out.println(generateAttribute(campo));
//            System.out.println();
//        }

        //BUILDER
//        var entityFields = getEntityFields().split("\n");
//        generateBuilder(entityFields, "entity");
//        generateBuilder(entityFields, "request");

        //CONSTANTS
//        var entityFields = getEntityFields().split("\n");
//        generateConstants(entityFields);

        //ASSERT
//        var entityFields = getEntityFields().split("\n");
//        generateAssertFields(entityFields, "entity");

        //VALID FIELDS
//        generateValidFields();

        //INVALID FIELDS
//        String constants = getConstants();
//        generateInValidFields(constants);

        //SET FIELDS
        var entityFields = getEntityFields().split("\n");
        String constants = getConstants();
        generateSetFields(entityFields, constants, "request");
    }

    private static void generateSetFields(String[] entityFields, String constants, String entity) {
        List<String> constantes = getConstantesFromString(constants);
        List<String> fieldsList = getFieldsFromArray(entityFields);
        for (int i = 0; i < constantes.size(); i++) {
            String field = fieldsList.get(i);
            System.out.println(entity + ".set" + field + "(" + constantes.get(i) + ");");
        }
    }

    private static List<String> getFieldsFromArray(String[] entityFields) {
        List<String> fieldList = new ArrayList<>();
        for (String str : entityFields) {
            if (str.trim().startsWith("@") || str.trim().length() < 5) continue;
            String[] fields = str.trim().split(" ");
            fieldList.add(fields[2].substring(0,1).toUpperCase() + fields[2].substring(1).replace(";", ""));
        }
        return fieldList;
    }

    private static void generateInValidFields(String constants) {
        List<String> constantes = getConstantesFromString(constants);

        //System.out.println("arguments(" + String.join(", ", constantes) + "),");
        for (int i = 0; i < constantes.size(); i++) {
            var copyList = new ArrayList<>(constantes);
            copyList.set(i, constantes.get(i) + "+ \"1\"");
            System.out.println("arguments(" + String.join(", ", copyList) + ", \"\"),");
        }
    }

    private static List<String> getConstantesFromString(String constants) {
        List<String> lines = Arrays.stream(constants.split("\n"))
                .sequential()
                .collect(Collectors.toList());

        List<String> constantes = new ArrayList<>();
        for(String line : lines) {
            String preLine = line.split(" = ")[0];
            int qtd = preLine.split(" ").length;
            constantes.add(preLine.split(" ")[qtd-1]);
        }
        return constantes;
    }

    private static String getConstants() {
        return
                "    Integer ID = 1;\n" +
                "    String DESCRICAO_RAZAO_SOCIAL = \"X\".repeat(Math.max(0, 35));\n" +
                "    String DESCRICAO_NOME_FANTASIA = \"X\".repeat(Math.max(0, 25));\n" +
                "    String NUMERO_CNPJ_CPF = \"X\".repeat(Math.max(0, 14));\n" +
                "    String NUMERO_INSCRICAO_ESTADUAL = \"X\".repeat(Math.max(0, 15));\n" +
                "    String NUMERO_RG = \"X\".repeat(Math.max(0, 15));\n" +
                "    String DESCRICAO_RUA = \"X\".repeat(Math.max(0, 35));\n" +
                "    String DESCRICAO_NUMERO_RUA = \"X\".repeat(Math.max(0, 10));\n" +
                "    String DESCRICAO_COMPLEMENTO = \"X\".repeat(Math.max(0, 25));\n" +
                "    String DESCRICAO_BAIRRO = \"X\".repeat(Math.max(0, 25));\n" +
                "    String DESCRICAO_CIDADE = \"X\".repeat(Math.max(0, 25));\n" +
                "    String DESCRICAO_UF = \"X\".repeat(Math.max(0, 2));\n" +
                "    String NUMERO_CEP = \"X\".repeat(Math.max(0, 8));\n" +
                "    String NUMERO_FONE = \"X\".repeat(Math.max(0, 20));\n" +
                "    String DESCRICAO_EMAIL = \"X\".repeat(Math.max(0, 45));\n" +
                "    Integer CODIGO_IBGE = 2;\n" +
                "    String NOME_CONTATO = \"X\".repeat(Math.max(0, 25));\n" +
                "    String DESCRICAO_OBSERVACAO = \"X\".repeat(Math.max(0, 500));\n" +
                "    Boolean FLAG_BLOQUEADO = true;";
    }

    private static void generateValidFields(String constants) {
        List<String> constantes = getConstantesFromString(constants);

        System.out.println("arguments(" + String.join(", ", constantes) + "),");
        for (int i = 0; i < constantes.size(); i++) {
            constantes.set(i, null);
            System.out.println("arguments(" + String.join(", ", constantes) + "),");
        }
    }

    private static void generateAssertFields(String[] entityFields, String entity) {
        for (String str : entityFields) {
            if (str.trim().startsWith("@") || str.trim().length() < 5) continue;
            String[] fields = str.trim().split(" ");
            System.out.println("assertThat(" + entity + ".get" + fields[2].substring(0,1).toUpperCase() + fields[2].substring(1).replace(";", "") + "()).isEqualTo();" );
        }
    }

    private static void generateConstants(String[] entityFields) {
        for(String str : entityFields) {
            if (str.trim().startsWith("@") || str.trim().length() < 5) continue;
            String [] fields = str.trim().split(" ");
            System.out.println(fields[1] + " " + fields[2].toUpperCase().replace(";","") + " = " + "\"X\".repeat(Math.max(0, ));");
        }
    }

}
