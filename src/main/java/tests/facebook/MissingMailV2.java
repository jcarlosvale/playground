package tests.facebook;

class MissingMailV2 {

    public static double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        double[][] probabilitiesMatrix = new double[N+1][N+1];

        //probabilities matrix
        for (int i = 0; i < N; i++) {
            int day = i +1;
            int value = V[i];
            for (int j = 0; j < N+1; j++) {
                //column zero
                if (j == 0) {
                    probabilitiesMatrix[day][j] = value - C;
                } else {
                    //diagonal
                    if (j == day) {
                        probabilitiesMatrix[day][j] = value;
                    }
                    //higher than diagonal
                    else if (j > day) {
                        probabilitiesMatrix[day][j] = probabilitiesMatrix[day][j-1] * (1- S);
                    //less than diagonal
                    } else {
                        probabilitiesMatrix[day][j] = probabilitiesMatrix[day][j-1] + probabilitiesMatrix[day - j][day];
                    }
                }
            }
        }

        //cost matrix
        double[][] costMatrix = new double[N+1][N+1];
        //last line
        for(int i = 0; i < N; i++) {
            costMatrix[N][i] = probabilitiesMatrix[N][i];
        }
        //verify negative sequence
        boolean negativeSequence = false;
        if (costMatrix[N][0] < 0) {
            negativeSequence = true;
            costMatrix[N][0] = 0;
        }
        //building from last line to first one
        for (int i = N-1; i > 0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                costMatrix[i][j] = Math.max(costMatrix[i+1][j+1], costMatrix[i+1][0] + probabilitiesMatrix[i][j]);
            }
            if(costMatrix[i][0] < 0 && negativeSequence) {
                costMatrix[i][0] = 0;
            } else {
                negativeSequence = false;
            }
            
        }

        return costMatrix[1][0];
    }

    public static void main(String[] args) {
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 5, 0.0)); //25.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 5, 1.0)); //9.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 3, 0.5)); //17.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 3, 0.15)); //20.10
        System.out.println(getMaxExpectedProfit(1, new int[]{10}, 11, 0.15)); //0
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,0}, 4, 0.5)); //13
        System.out.println(getMaxExpectedProfit(3, new int[]{10,0,2}, 6, 0.05)); //5.x
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 8, 1.0)); //2

    }

}