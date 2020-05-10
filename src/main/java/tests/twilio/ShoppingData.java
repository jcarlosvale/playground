package tests.twilio;

import java.io.*;
import java.util.*;

public class ShoppingData {
    public static void generateFiles(String input_file_name) {
        List<List<String>> records = new ArrayList<>();
        //read file
        try (BufferedReader br = new BufferedReader(new FileReader(input_file_name))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e) {
           return;
        }
        Map<String, Integer> mapFile1 = new HashMap<>();
        for (List<String> line: records) {
            String product = line.get(2);
            int qty = Integer.parseInt(line.get(3));
            mapFile1.putIfAbsent(product, mapFile1.getOrDefault(product,0) + qty);
        }
        //file 1
        String filename1 = "0_" + input_file_name;
        File csvOutputFile = new File(filename1);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            for(String product : mapFile1.keySet()) {
                pw.println(product + "," +String.format("%.2f",(mapFile1.get(product) / (double) mapFile1.size())));
            }
        } catch (FileNotFoundException e) {
            return;
        }

        //file 2
        String filename2 = "1_" + input_file_name;
        File csvOutputFile2 = new File(filename2);
        try (PrintWriter pw = new PrintWriter(csvOutputFile2)) {
            for(String product : mapFile1.keySet()) {
                pw.println(product + "," +String.format("%.2f",(mapFile1.get(product) / (double) mapFile1.size())));
            }
        } catch (FileNotFoundException e) {
            return;
        }
    }
}
