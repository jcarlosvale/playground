package tests.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

public class SherlockStringCase {
    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        char [] array = s.toCharArray();
        Map<Character, Integer> countCharMap = new HashMap<>();

        //counter
        for(char c: array) {
            countCharMap.put(c, countCharMap.getOrDefault(c, 0) + 1);
        }
        //counter numbers
        int value1 = 0;
        int counter1 = 0;

        int value2 = 0;
        int counter2 = 0;
        for(Map.Entry<Character, Integer> entry : countCharMap.entrySet()) {
            //value 1
            if (value1 == 0) {
                value1 = entry.getValue();
                counter1++;
            } else {
                if (value1 == entry.getValue()) {
                    counter1++;
                } else {
                    //value 2
                    if (value2 == 0) {
                        value2 = entry.getValue();
                        counter2++;
                    } else {
                        if (value2 == entry.getValue()) {
                            counter2++;
                        } else {
                            return "NO";
                        }
                    }
                }
            }
        }

        if ((value1 == 0) || (value2 == 0)) return "YES";
        if (value1 == 1 && counter1 == 1)  return "YES";
        if (value2 == 1 && counter2 == 1)  return "YES";
        if (Math.abs(value1 - value2) > 1) {
            return "NO";
        } else {
            if ((counter1 > 1) && (counter2 > 1)) return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
//        System.out.println(isValid("abc")); //y
//        System.out.println(isValid("abcc")); //y
//        System.out.println(isValid("aabbc")); //y
//        System.out.println(isValid("abccc")); //n
        //YES
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
    }

}
