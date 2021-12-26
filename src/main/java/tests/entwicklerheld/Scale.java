package tests.entwicklerheld;

import java.util.ArrayList;
import java.util.List;

class Scale {
    static List<Integer> getMasses(Integer weight, List<Integer> allMasses) {
        boolean [][] subsetSumArray = subsetSum(weight, allMasses);
        if(subsetSumArray[subsetSumArray.length-1][subsetSumArray[0].length-1]) {
            return trace(subsetSumArray, allMasses);
        } else {
            return new ArrayList<>();
        }
    }

    private static List<Integer> trace(boolean[][] subsetSumArray, List<Integer> allMasses) {
        List<Integer> selectedMasses = new ArrayList<>();
        int i = subsetSumArray.length-1;
        int j = subsetSumArray[0].length - 1;
        while(i >= 0 && j > 0) {
            if ((i == 0) && subsetSumArray[i][j]) {
                selectedMasses.add(allMasses.get(i));
            }
            if ((i > 0) && (subsetSumArray[i][j] != subsetSumArray[i-1][j])) {
                selectedMasses.add(allMasses.get(i));
                j = j - allMasses.get(i);
            }
            i = i -1;
        }
        return selectedMasses;
    }

    private static boolean[][] subsetSum(Integer weight, List<Integer> allMasses) {
        boolean[][] memoization = new boolean[allMasses.size()][weight+1];
        //trivial case
        for(int i = 0; i < memoization.length; i++) {
            memoization[i][0] = true;
        }
        //first element
        if(allMasses.get(0) <= weight) {
            memoization[0][allMasses.get(0)] = true;
        }
        //other cases
        for (int i = 1; i < allMasses.size(); i++) {
            int mass = allMasses.get(i);
            if (mass > weight) {
                memoization[i] = memoization[i-1];
            } else {
                for (int j = 1; j <= weight; j++) {
                    if(mass > j) {
                        memoization[i][j] = memoization[i-1][j];
                    } else{
                        memoization[i][j] =  memoization[i-1][j] || memoization[i-1][j - mass];
                    }
                }
            }
        }
        return memoization;
    }

    public static void main(String[] args) {
        System.out.println(getMasses(11, List.of(2,3,7,8,10)));
        System.out.println(getMasses(145, List.of(16,32,64,128,1,2,4,8)));

    }
}