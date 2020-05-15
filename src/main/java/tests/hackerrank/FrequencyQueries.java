package tests.hackerrank;

import tests.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given  queries. Each query is of the form two integers described below:
 * -  : Insert x in your data structure.
 * -  : Delete one occurence of y from your data structure, if present.
 * -  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
 *
 * The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data
 * element. For example, you are given array . The results of each operation are:
 *
 * Operation   Array   Output
 * (1,1)       [1]
 * (2,2)       [1]
 * (3,2)                   0
 * (1,1)       [1,1]
 * (1,1)       [1,1,1]
 * (2,1)       [1,1]
 * (3,2)                   1
 * Return an array with the output: .
 *
 * Function Description
 *
 * Complete the freqQuery function in the editor below. It must return an array of integers where each element is a
 * if there is at least one element value with the queried number of occurrences in the current array, or 0 if there
 * is not.
 *
 * freqQuery has the following parameter(s):
 *
 * queries: a 2-d array of integers
 * Input Format
 *
 * The first line contains of an integer , the number of queries.
 * Each of the next  lines contains two integers denoting the 2-d array .
 *
 * Constraints
 *
 * All
 * Output Format
 *
 * Return an integer array consisting of all the outputs of queries of type .
 *
 * Sample Input 0
 *
 * 8
 * 1 5
 * 1 6
 * 3 2
 * 1 10
 * 1 10
 * 1 6
 * 2 5
 * 3 2
 * Sample Output 0
 *
 * 0
 * 1
 * Explanation 0
 *
 * For the first query of type , there is no integer whose frequency is  (). So answer is .
 * For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .
 *
 * Sample Input 1
 *
 * 4
 * 3 4
 * 2 1003
 * 1 16
 * 3 1
 * Sample Output 1
 *
 * 0
 * 1
 * Explanation 1
 *
 * For the first query of type , there is no integer of frequency . The answer is . For the second query of type ,
 * there is one integer,  of frequency  so the answer is .
 *
 * Sample Input 2
 *
 * 10
 * 1 3
 * 2 3
 * 3 2
 * 1 4
 * 1 5
 * 1 5
 * 1 4
 * 3 2
 * 2 4
 * 3 2
 * Sample Output 2
 *
 * 0
 * 1
 * 1
 * Explanation 2
 *
 * When the first output query is run, the array is empty. We insert two 's and two 's before the second output
 * query,  so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the
 * instances of  satisfy the query.
 */
public class FrequencyQueries {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(List<Integer> query : queries) {
            int op = query.get(0);
            int value = query.get(1);
            switch (op) {
                case 1:  //add
                    int oldFrequency = countMap.getOrDefault(value, 0);
                    int newFrequency = oldFrequency + 1;
                    countMap.put(value, newFrequency);
                    frequencyMap.put(newFrequency, frequencyMap.getOrDefault(newFrequency, 0) + 1);
                    if(frequencyMap.getOrDefault(oldFrequency, 1) == 1) {
                        frequencyMap.remove(oldFrequency);
                    } else {
                        frequencyMap.put(oldFrequency, frequencyMap.get(oldFrequency) - 1);
                    }
                    break;
                case 2: //remove
                    oldFrequency = countMap.getOrDefault(value, 0);
                    newFrequency = oldFrequency - 1;
                    if(newFrequency <= 0) {
                        countMap.remove(value);
                        if (frequencyMap.getOrDefault(oldFrequency, 1) == 1) {
                            frequencyMap.remove(oldFrequency);
                        } else {
                            frequencyMap.put(oldFrequency, frequencyMap.get(oldFrequency) - 1);
                        }
                    } else {
                        countMap.put(value, newFrequency);
                        if (frequencyMap.getOrDefault(oldFrequency, 1) == 1) {
                            frequencyMap.remove(oldFrequency);
                        } else {
                            frequencyMap.put(oldFrequency, frequencyMap.get(oldFrequency) - 1);
                        }
                        frequencyMap.put(newFrequency, frequencyMap.getOrDefault(newFrequency, 0) + 1);
                    }
                    break;
                case 3: //query
                    if (frequencyMap.containsKey(value)) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> lines = Util.readFile("inputFrequencyQueries-1.txt");
        int size = Integer.parseInt(lines.get(0));
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            String line = lines.get(i);
            String[] values = line.split(" ");
            List<Integer> query = new ArrayList<>();
            query.add(Integer.parseInt(values[0]));
            query.add(Integer.parseInt(values[1]));
            queries.add(query);
        }

        lines = Util.readFile("resultFrequencyQueries-1.txt");
        List<Integer> result = new ArrayList<>();
        for (String line: lines) {
            result.add(Integer.parseInt(line));
        }
        if (size == queries.size()) {
            List<Integer> calculated = freqQuery(queries);
            for (int i = 0; i < calculated.size(); i++) {
                if (!calculated.get(i).equals(result.get(i))) {
                    System.out.println("line " + i + " : " + calculated.get(i) + " , " + result.get(i));
                }
            }
        }
    }
}
