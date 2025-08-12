package ada;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, new ArrayList<>(), result);
        return result;
    }

    public static void backtracking(int n, int k, List<Integer> partial, List<List<Integer>> result) {
        if (partial.size() == k) {
            result.add(new ArrayList<>(partial));
            return;
        }

        for(int num = 1; num <= n; num++) {
            if (!partial.isEmpty()) {
                if (num <= partial.get(partial.size()-1)) continue;
                partial.add(num);
                backtracking(n, k, partial, result);
                partial.remove(partial.size() - 1);
            } else {
                partial.add(num);
                backtracking(n, k, partial, result);
                partial.remove(partial.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
      //  System.out.println(combine(4, 2));
        System.out.println(combine(3, 3));
    }
}
