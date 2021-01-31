package tests.salv;

public class Q1 {
    public static boolean solution (int [] level) {
        if (level.length == 1) return level[0] > 0;
        int maxJump = level[0];
        for (int i = 1; i < level.length; i++) {
            maxJump = Math.max(maxJump-1, level[i]);
        }
        return (maxJump > 0);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,0,3,1,0}));
        System.out.println(solution(new int[] {1,2,0}));
        System.out.println(solution(new int[] {2,0,0}));
    }
}
