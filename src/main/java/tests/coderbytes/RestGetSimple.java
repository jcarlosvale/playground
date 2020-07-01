package tests.coderbytes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class RestGetSimple {

    public static void createFile() {
        try {
            String str = "some content";
            BufferedWriter writer = new BufferedWriter(new FileWriter("newfile.txt"));
            writer.write(str);
            writer.close();
        } catch (Exception e) {
        }
    }

    public static List<String> getFileList() {
        return
                Stream.of(new File(".")
                        .listFiles())
                        .filter(file-> !file.isDirectory())
                        .map(file -> file.getName())
                        .collect(Collectors.toList());
    }

    public static void main (String[] args) {
        createFile();
        List<String> fileList = getFileList();
        Collections.sort(fileList);
        String result = fileList.toString();
        result = result.replace("[", "");
        result = result.replace("]", "");
        System.out.println(result);
    }
}
