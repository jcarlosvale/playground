package tests.facebook.interviewbits;

import java.util.List;

//https://www.youtube.com/watch?v=HRkqCQBYwB8
public class BestTimeToBuyAndSellStocksII {

    public static int maxProfit(final List<Integer> A) {
        int ans = 0;
        int i = 0;
        int low = 0;
        int high = 0;
        while (i < A.size() - 1) {

            while(i < A.size()-1 && A.get(i+1) <= A.get(i)) {
                i++;
            }
            low = A.get(i);

            while(i < A.size()-1 && A.get(i+1) >= A.get(i)) {
                i++;
            }
            high = A.get(i);

            ans += high - low;

        }

        return ans;
    }

}
