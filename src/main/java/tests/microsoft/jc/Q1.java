package tests.microsoft.jc;

public class Q1 {
    public static int solution(int[] blocks)
    {
        int front = 0;
        int back = 0;
        int bestSize = 1;
        int currentSize = 1;
        boolean middleBlock = false;


        while (front < blocks.length - 1)
        {
            if (middleBlock)
            {
                if (blocks[front] <= blocks[front + 1])
                {
                    front++;
                    currentSize++;
                }
                else
                {
                    back++;
                    middleBlock = false;
                    front = back;
                    currentSize = 1;
                }

            }
            else
            {
                if (blocks[front] >= blocks[front + 1])
                {
                    front++;
                    currentSize++;
                }
                else
                    middleBlock = true;
            }

            if (currentSize > bestSize)
                bestSize = currentSize;
        }


        return bestSize;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,6,8,5})); //3
        System.out.println(solution(new int[] {1,5,5,2,6})); //4
        System.out.println(solution(new int[] {1,1})); //2
    }
}
