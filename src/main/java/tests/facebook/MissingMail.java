package tests.facebook;

class MissingMail {

    public static double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        double expectedProfit = 0.0;
        int lastDayToCollect = -1;
        double[] collectedValues = new double[N];

        for(int i = N - 1; i >= 0; i--) {
            int currentValue = V[i];
            double currentDayProfit = currentValue - C;
            double nextCollectDayProfit = calculateProfit(currentValue, i, lastDayToCollect, S);

            if ((nextCollectDayProfit > currentDayProfit) && (nextCollectDayProfit + collectedValues[lastDayToCollect] > currentDayProfit)) {
                collectedValues[lastDayToCollect] += nextCollectDayProfit;
            } else {
                collectedValues[i] = currentDayProfit;
                lastDayToCollect = i;
            }
        }

        //sum up
        for(double profit : collectedValues) {
            if (profit > 0) expectedProfit += profit;
        }

        return expectedProfit;
    }

    private static double calculateProfit(int currentValue, int day, int lastDayToCollect, double probabilityToLost) {
        if (lastDayToCollect < 0) return -1001.0;
        return currentValue * Math.pow(1 - probabilityToLost, lastDayToCollect - day);
    }

    public static void main(String[] args) {
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 5, 0.0)); //25.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 5, 1.0)); //9.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 3, 0.5)); //17.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 3, 0.15)); //20.10

        System.out.println(getMaxExpectedProfit(1, new int[]{10}, 11, 0.15)); //0
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,0}, 4, 0.5)); //13


    }

}