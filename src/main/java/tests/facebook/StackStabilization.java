package tests.facebook;

class StackStabilization {

    public static int getMinimumDeflatedDiscCount(int N, int[] R) {
        int min = 0;
        for(int i = N-2; i >= 0; i--) {
            if (R[i] >= R[i+1]) {
                R[i] = R[i+1] - 1;
                if (R[i] <= 0){
                    min = -1;
                    break;
                }
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumDeflatedDiscCount(5, new int[]{2,5,3,6,5})); // 3
        System.out.println(getMinimumDeflatedDiscCount(3, new int[]{100,100,100})); // 2
        System.out.println(getMinimumDeflatedDiscCount(4, new int[]{6,5,4,3})); // -1
    }

}