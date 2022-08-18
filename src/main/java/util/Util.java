package util;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void main(String[] args) {
        var campos = getCampos();

        for(Campo campo : campos) {
            System.out.println(generateAttribute(campo));
            System.out.println();
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
