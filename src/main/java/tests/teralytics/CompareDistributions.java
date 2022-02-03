package tests.teralytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareDistributions {
    /**
     * 1 - Read files
     * 2 - Get Input
     * 3 - Evaluate the simple distribution (proportionalities)
     * 4 - Comparison and give analysis
     */


    public static Map<String, Double> analysisDistributions(final String inputFileCensusPath, final String inputFileTelcoPath) throws IOException {
        List<String> censusFileLines = readFile(inputFileCensusPath);
        List<String> telcoFileLines = readFile(inputFileTelcoPath);

        Map<String, Long> censusMap = extractMapFrom(censusFileLines);
        Map<String, Long> telcoMap = extractMapFrom(telcoFileLines);

        Map<String, Double> censusProportionMap = extractProportion(censusMap);
        Map<String, Double> telcoProportionMap = extractProportion(telcoMap);

        return evaluate(censusProportionMap, telcoProportionMap);
    }

    private static Map<String, Double> evaluate(Map<String, Double> censusProportionMap, Map<String, Double> telcoProportionMap) {
        Map<String, Double> correctionMap = new HashMap<>();

        for(Map.Entry<String, Double> censusEntry: censusProportionMap.entrySet()) {
            double correctionFactor = 1.0;
            if (telcoProportionMap.containsKey(censusEntry.getKey())) {
                correctionFactor  = censusEntry.getValue() / telcoProportionMap.get(censusEntry.getKey());
            } else { //TODO: analysis in the end
                correctionFactor  = censusEntry.getValue();
            }
            correctionMap.put(censusEntry.getKey(), correctionFactor);
        }

        return correctionMap;
    }

    //TODO: improve code syntax
    private static Map<String, Double> extractProportion(Map<String, Long> censusMap) {
        double total = 0D;
        Map<String, Double> proportionMap = new HashMap<>(); //TODO: maybe typo
        for(long value : censusMap.values()) {
            total += value;
        }
        for(Map.Entry<String, Long> entry: censusMap.entrySet()) {
            proportionMap.put(entry.getKey(), entry.getValue() / total);
        }
        return proportionMap;
    }

    private static Map<String, Long> extractMapFrom(List<String> fileLines) {
        Map<String, Long> fileMap = new HashMap<>();

        for (int i = 1; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            String [] fields = line.split(",");
            fileMap.put(fields[0], Long.parseLong(fields[1]));
        }

        return fileMap;
    }

    private static List<String> readFile(final String inputFilePath) throws IOException {
        Path path = Paths.get(inputFilePath);
        return Files.readAllLines(path);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(analysisDistributions("C:\\Pessoal\\Projects\\Teralytics\\Germany-census-age.csv",
                "C:\\Pessoal\\Projects\\Teralytics\\Germany-telco-age.csv") );
    }

}
