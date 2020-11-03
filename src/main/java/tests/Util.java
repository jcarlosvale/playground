package tests;

import tests.leetcode.challenge30days.FirstUnique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumSet;
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

    enum Color {
        GREEN, RED, BLUE;
    }
    public static void main(String[] args) {
        System.out.println("test");
        EnumSet<Color> carrierSet = EnumSet.noneOf(Color.class);
        carrierSet.add(Color.GREEN);
        carrierSet.add(Color.RED);
        carrierSet.add(Color.GREEN);
        System.out.println(carrierSet.size());
    }
}
