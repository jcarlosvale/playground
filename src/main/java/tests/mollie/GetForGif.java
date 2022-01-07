package tests.mollie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class GetForGif {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename = "c:\\temp\\input000.txt";
        //filename = scan.nextLine();

        List<String> linesFromFile = extractLinesFrom(filename);
        Set<String> uniqueGifFileNames =  parseLinesFromFile(linesFromFile);
        String outputFileName = "gifs_"+filename;
        
        //saveToFile(outputFileName, uniqueGifFileNames);
    }

    private static void saveToFile(String outputFileName, Set<String> uniqueGifFileNames) {
        try {
            List<String> lines = new ArrayList<>(uniqueGifFileNames);
            Path file = Paths.get(outputFileName);
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> parseLinesFromFile(List<String> linesFromFile) {
        Set<String> gifNamesSet = new HashSet<>();
        for(String line: linesFromFile) {
            //split request and code
            String[] contents = line.split("\"");
            if (contents.length >= 3) {
                String request = contents[1];
                //verify is GET and contains GIF
                if (request.startsWith("GET ") && request.toUpperCase(Locale.ROOT).contains(".GIF ")) {
                    //verify response code
                    String responseCodeFields = contents[2];
                    if (responseCodeFields.trim().startsWith("200 ")) {
                        for(String path : request.split("/")) {
                            if (path.toUpperCase(Locale.ROOT).contains(".GIF ")) {
                                int lastGifPosition = path.toUpperCase(Locale.ROOT).lastIndexOf(".GIF ") + 5;
                                String gifName = path.substring(0, lastGifPosition).trim();
                                gifNamesSet.add(gifName);
                            }
                        }
                    }
                }
            }
        }
        return gifNamesSet;
    }

    private static List<String> extractLinesFrom(String filename) {
        List<String> linesFromFile = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNextLine()) {
                linesFromFile.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }
}
