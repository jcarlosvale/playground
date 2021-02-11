package tests.booking;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static List<String> solution(char[] set, int k) {
        List<String> alfabet = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (char c : set) {
            alfabet.add(""+c);
            result.add("" +c);
        }
        for (int i = 2; i <= k; i++) {
            List<String> temp = new ArrayList<>();
            for (String line : result) {
                for (String alfa : alfabet) {
                    temp.add(line+alfa);
                }
            }
            result.clear();
            result.addAll(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new char[]{'a', 'b', 'c'}, 3));
    }
}
