package monitoria;

import org.apache.commons.lang3.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileManipulation {


    public static void main(String[] args) throws IOException {
        var pathTest = Paths.get("c:/temp/testTransactions00_00_10.txt");
////        System.out.println(Files.readAllLines(pathTest));
//
//        var path = Paths.get("c:/temp/transactions00_00_10.txt");
////        System.out.println(Files.readAllLines(path));
//
//        Set<String> setTest = new HashSet<>(Files.readAllLines(pathTest));
//        setTest.removeAll(new HashSet<>(Files.readAllLines(path)));
//        System.out.println(setTest.size());
//        System.out.println(setTest);
//
//        Set<String> setProd = new HashSet<>(Files.readAllLines(path));
//        setProd.removeAll(new HashSet<>(Files.readAllLines(pathTest)));
//        System.out.println(setProd.size());
//        System.out.println(setProd);
        diffAgrupado();
    }

    public static void diffAgrupado() throws IOException {
        var fileProd = Paths.get("c:/temp/transactionsGrouped.txt");
        var fileTest = Paths.get("c:/temp/testTransactionsGrouped.txt");

        var listProd =
                Files
                        .lines(fileProd)
                        .filter(s -> s.contains("pg-web-data"))
                        .map(s -> StringUtils.substringBetween(s, "id:", "}"))
                        .map(String::trim)
                        .collect(Collectors.toList());

        var listTest =
                Files
                        .lines(fileTest)
                        .filter(s -> s.contains("pg-web-data"))
                        .map(s -> StringUtils.substringBetween(s, "id:", "}"))
                        .map(String::trim)
                        .collect(Collectors.toList());


        var cpProd = new ArrayList<>(listProd);
        var cpTest = new ArrayList<>(listTest);
        cpProd.removeAll(cpTest);
        System.out.println("PROD DIFF: " + cpProd);

        cpProd = new ArrayList<>(listProd);
        cpTest = new ArrayList<>(listTest);
        cpTest.removeAll(cpProd);
        System.out.println("TEST DIFF: " + cpTest);
    }


}
