package tests.bauhaus;

public class Q1 {
    public static void solution(int N) {
       for(int i=1; i<=N-1; i++){
           System.out.println("L");
       }
        for(int i=1; i<=N; i++){
            System.out.print("L");
        }
    }

    public static void main(String[] args) {
        solution(4);
    }
}
