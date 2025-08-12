package ada;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(new ArrayList<>(), 0, nums, result);
        return result;
    }

    private static void backtracking(List<Integer> partial, int index, int [] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(partial));
        } else {
            backtracking(partial, index + 1, nums, result);
            partial.add(nums[index]);
            backtracking(partial, index + 1, nums, result);
            partial.remove(partial.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
