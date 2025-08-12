package ada;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] ans = new int[nums.length];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        for(int i = 0; i < nums.length; i++){

            boolean found = false;
            int element = nums[i];
            stack.push(element);

            int n = nums.length - 1;
            int j = i;
            while(n > 0 && !found) {
                j = (j + 1) % nums.length;
                if (nums[j] <= element) {
                    stack.push(nums[j]);
                } else {
                    while(!stack.isEmpty() && nums[j] > stack.peek() ){
                        stack.pop();
                        ans[i] = nums[j];
                        found = true;
                    }
                }
                n--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        nextGreaterElements(new int[]{1, 2, 1});
    }
}
