package tests.zalando;

public class Q12 {
    public static int solution(String S, int[] C) {

        if(C.length == 1) return 0;

        int totalSum = 0;
        int totalEnd = 0;
        
        //total
        for (int i : C) {
            totalSum += i;
        }

        //diff
        int higher = Integer.MIN_VALUE;

        for (int i = 1; i < S.length(); i++) {
            char prev = S.charAt(i-1);
            char curr = S.charAt(i);

            if(curr == prev) {
                higher = Math.max(higher, Math.max(C[i], C[i-1]));
            } else {
                if (higher != Integer.MIN_VALUE) {
                    totalEnd += higher;
                } else {
                    totalEnd += C[i-1];
                }
                higher = C[i];
            }
        }

        if (higher != Integer.MIN_VALUE) {
            totalEnd += higher;
        }


        return totalSum - totalEnd;
        
    }
    
    public static void main(String[] args) {
        System.out.println(solution("abccbd", new int[]{0,1,2,3,4,5})); //2
        System.out.println(solution("aabbcc", new int[]{1,2,1,2,1,2})); //3
        System.out.println(solution("aaaa", new int[]{3,4,5,6})); //12
        System.out.println(solution("ababa", new int[]{10,5,10,5,10})); //0
    }
}
