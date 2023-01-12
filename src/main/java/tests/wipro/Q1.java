package tests.wipro;

import java.math.BigInteger;

interface Sale {
    double getPrice();
    default String getSymbol() {
        return "$";
    }

    public static void print(String str) {
        System.out.println("Int " + str);
    }
}

class Mobile implements Sale {

    @Override
    public double getPrice() {
        return 35;
    }

    @Override
    public String getSymbol() {
        return "eur";
    }

    public void print(String str) {
        System.out.println("Class " + str);
    }

}

interface Op {
    int operate(int x, int y);
}
public class Q1 {

    public static int solution(int A, int B) {
        // Implement your solution here
        BigInteger integer = BigInteger.valueOf(A).multiply(BigInteger.valueOf(B));
        String binaryRepresentation = integer.toString(2);
        int result = 0;
        for(char c : binaryRepresentation.toCharArray()) {
            if (c == '1') result++;
        }
        return result;
    }

    public static void main(String[] args) {

        int x = 10;
        int y = 20;
    }
}
