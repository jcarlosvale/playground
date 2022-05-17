package tests.glovo;

//Kadane Algorithm
//Sub set array
public class Q3 {

    //4 2 -3 1 6
    // 5x5
    //[2,3] ==> 2 3
    //[0,4] ==> 0, 1 2 3 4
    //1st approach method sum(array, int start, int end) ==> return sums, if 0 ==> true
    //2nd approach [0,4] ==> [0,3] + [4,4]

    public static boolean solution(int[] array) {
        //boolean find = false;
        //int [][] matrix = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int value = sum(array,i,j);
                //System.out.println(value + " " +  i + " " + j);
                if(value== 0) {
                    return true;
                }
            }
        }
        return false;

    }

    private static int sum(int[] array, int i, int j) {
        int result = 0;

        if(j < i) return -1;

        for (int k = i; k <= j; k++) {
            result += array[k];
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {4,2,-3,1,6})); //true
        System.out.println(solution(new int[] {4,2,0,1,6})); //true
        System.out.println(solution(new int[] {-3,2,3,1,6})); //false
        int a =1, b=2, c=3;
        System.out.println(a==1 && b>1 || c !=0);
    }
}
