package tests.hackerrank.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If
 * the amount spent by a client on a particular day is greater than or equal to  the client's median spending for a
 * trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the
 * client any notifications until they have at least that trailing number of prior days' transaction data.
 *
 * Given the number of trailing days  and a client's total daily expenditures for a period of  days, find and print
 * the number of times the client will receive a notification over all  days.
 *
 * For example,  and . On the first three days, they just collect spending data. At day , we have trailing
 * expenditures of . The median is  and the day's expenditure is . Because , there will be a notice. The next day,
 * our trailing expenditures are  and the expenditures are . This is less than  so no notice will be sent. Over the
 * period, there was one notice sent.
 *
 * Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If
 * there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then
 * defined to be the average of the two middle values. (Wikipedia)
 *
 * Function Description
 *
 * Complete the function activityNotifications in the editor below. It must return an integer representing the number
 * of client notifications.
 *
 * activityNotifications has the following parameter(s):
 *
 * expenditure: an array of integers representing daily expenditures
 * d: an integer, the lookback days for median spending
 * Input Format
 *
 * The first line contains two space-separated integers  and , the number of days of transaction data, and the number
 * of trailing days' data used to calculate median spending.
 * The second line contains  space-separated non-negative integers where each integer  denotes .
 *
 * Constraints
 *
 * Output Format
 *
 * Print an integer denoting the total number of times the client receives a notification over a period of  days.
 *
 * Sample Input 0
 *
 * 9 5
 * 2 3 4 2 3 6 8 4 5
 * Sample Output 0
 *
 * 2
 * Explanation 0
 *
 * We must determine the total number of  the client receives over a period of  days. For the first five days, the
 * customer receives no notifications because the bank has insufficient transaction data: .
 *
 * On the sixth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which
 * triggers a notification because : .
 *
 * On the seventh day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars,
 * which triggers a notification because : .
 *
 * On the eighth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which
 * does not trigger a notification because : .
 *
 * On the ninth day, the bank has  days of prior transaction data, , and a transaction median of  dollars. The client
 * spends  dollars, which does not trigger a notification because : .
 *
 * Sample Input 1
 *
 * 5 4
 * 1 2 3 4 4
 * Sample Output 1
 *
 * 0
 * There are  days of data required so the first day a notice might go out is day . Our trailing expenditures are
 * with a median of  The client spends  which is less than  so no notification is sent.
 */
public class FraudulentActivityNotifications {
    public static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        //if d == 1
        if (d == 1) {
            for (int i = 1; i < expenditure.length; i++) {
                if (expenditure[i-1] * 2 >= expenditure[i]) {
                    count++;
                }
            }
            return count;
        }
        //if d == 2
        if (d == 2) {
            for (int i = 2; i < expenditure.length; i++) {
                double median = (expenditure[i-2] + expenditure[i-1]) / 2.0;
                if (median * 2 >= expenditure[i]) {
                    count++;
                }
            }
            return count;
        }
        //count numbers - size d
        TreeMap<Integer, Integer> mapIndexes = new TreeMap<>();
        for (int i = 0; i < d; i++) {
            mapIndexes.put(expenditure[i], mapIndexes.getOrDefault(expenditure[i],0) + 1);
        }
        //action
        for (int i = d; i < expenditure.length; i++) {
            double median = findMedian(mapIndexes, d);
            if (2 * median <= expenditure[i]) {
                count++;
            }
            //add remove indexes
            int counter = mapIndexes.get(expenditure[i-d]);
            counter--;
            if (counter <= 0) mapIndexes.remove(expenditure[i-d]);
            else mapIndexes.put(expenditure[i-d], counter);

            mapIndexes.put(expenditure[i], mapIndexes.getOrDefault(expenditure[i], 0) + 1);
        }
        return count;
    }

    private static double findMedian(TreeMap<Integer, Integer> mapIndexes, int size) {
        int counter1;
        int counter2;
        boolean find1 = false;
        boolean find2 = false;
        if (size % 2 != 0) {
            counter1 = size/2 + 1;
            counter2 = counter1;
        } else {
            counter1 = size/2;
            counter2 = counter1 + 1;
        }
        int median = 0;
        for(Map.Entry<Integer,Integer> entry : mapIndexes.entrySet()) {
            counter1 -= entry.getValue();
            counter2 -= entry.getValue();
            if (!find1 && counter1 <= 0) {
                median += entry.getKey();
                find1 = true;
            }
            if (!find2 && counter2 <= 0) {
                median += entry.getKey();
                find2 = true;
            }
            if (find1 && find2) break;
        }
        return median/2.0;
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));  //2
        System.out.println(activityNotifications(new int[] {10, 20, 30, 40, 50}, 3));  //1
    }
}
