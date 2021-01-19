package tests.microsoft.jc;

public class Q3 {
    public static int solution(int [] blocks) {
        int result = 2;
        if (blocks.length == 2) {
            return result;
        }
        int countPlus = 0;
        int countMinus = 0;

        for (int i = 0; i < blocks.length - 1 ; i++) {
            int current = blocks[i];
            int next = blocks[i+1];
            if (current == next) {
                countPlus++;
                countMinus++;
            } else {
                if (current < next) {
                    countPlus++;
                } else{
                    countMinus++;
                }
            }
        }
        result = Math.max(countPlus, countMinus);
        return result+1;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,6,8,5})); //3
        System.out.println(solution(new int[] {1,5,5,2,6})); //4
        System.out.println(solution(new int[] {1,1})); //2
    }
}
