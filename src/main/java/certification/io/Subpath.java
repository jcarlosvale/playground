package certification.io;

import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class Subpath {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var p = Paths.get("/user/data/planilha.txt");
        System.out.println("Path: " + p);
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(" Elemento " + i + " eh: " + p.getName(i));
        }
        System.out.println();
        System.out.println("subpath(0,3): " + p.subpath(0, 3));
        System.out.println("subpath(1,2): " + p.subpath(1, 2));
        System.out.println("subpath(1,3): " + p.subpath(1, 3));
    }
}
