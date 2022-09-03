package util;

import lombok.ToString;

import java.util.*;

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

    public static void main(String[] args) {
//        var campos = getCampos();
//
//        for(Campo campo : campos) {
//            System.out.println(generateAttribute(campo));
//            System.out.println();
//        }

        //BUILDER
        var entityFields = getEntityFields().split("\n");
        System.out.println(Arrays.toString(entityFields));
        //generateBuilder(entityFields, "entity");
        generateBuilder(entityFields, "request");

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

}
