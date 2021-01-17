package tests.hackerrank.java.problems;

import java.time.LocalDate;

/*
https://www.hackerrank.com/challenges/java-date-and-time/problem
 */
public class FindDay {
    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().name();
    }

}
