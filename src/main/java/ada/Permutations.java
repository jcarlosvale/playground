package ada;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), result);
        return result;
    }

    public static void backtracking(int[] nums, List<Integer> partial, List<List<Integer>> result) {
        if (partial.size() == nums.length) {
            result.add(new ArrayList<>(partial));
            return;
        }

        for(int num: nums) {
            if (!partial.contains(num)) {
                partial.add(num);
                backtracking(nums, partial, result);
                partial.remove(partial.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}
