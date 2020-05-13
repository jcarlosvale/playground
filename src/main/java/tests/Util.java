package tests;

import tests.leetcode.challenge30days.FirstUnique;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        InputStream inputStream = FirstUnique.class.getClassLoader().getResourceAsStream(filename);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            String line = br.readLine();
            while(line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
