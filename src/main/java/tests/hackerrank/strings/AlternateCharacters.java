package tests.hackerrank.strings;

public class AlternateCharacters {
    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        int count = 0;
        char [] array = s.toCharArray();
        int i = 0;
        while (i < array.length) {
            char c = array[i];
            int tempCounter = counter(c, array, i+1);
            if (tempCounter > 0) {
                count += tempCounter;
                i += tempCounter;
            } else {
                i++;
            }
        }
        return count;
    }

    private static int counter(char c, char[] array, int pos) {
        int counter = 0;
        for (int i = pos; i < array.length; i++) {
            if (c == array[i]){
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAAA")); //3
        System.out.println(alternatingCharacters("BBBBB")); //4
        System.out.println(alternatingCharacters("ABABABAB")); //0
        System.out.println(alternatingCharacters("AAABBB")); //4

    }
}

