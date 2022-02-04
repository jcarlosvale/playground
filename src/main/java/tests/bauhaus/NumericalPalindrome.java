package tests.bauhaus;

public class NumericalPalindrome {
    public static String solution(String S) {
        int[] counterDigits = new int[10];
        if (S.length() == 1) return S;
        StringBuilder result = new StringBuilder();
        //counter
        for(char c: S.toCharArray()) {
            int digit = c - '0';
            counterDigits[digit]++;
        }
        //setup
        int maxDigit = -1;
        for (int i = 9; i >= 0; i--) {
            if (counterDigits[i] > 0 && counterDigits[i] >= 2 && i > 0) {
                int qty = counterDigits[i] / 2;
                while(qty > 0) {
                    result.append(i);
                    qty--;
                }
                counterDigits[i] = counterDigits[i] % 2;
            }
            if (counterDigits[i] > 0) {
                maxDigit = Math.max(maxDigit, i);
            }
        }
        //only single digits
        if (result.length() == 0){
            return String.valueOf(maxDigit);
        }
        else {
            String postFix = result.reverse().toString();
            if (maxDigit >= 0) {
                result.append(maxDigit);
            }
           result.append(postFix);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(solution("7")); //7
        System.out.println(solution("44")); //44
        System.out.println(solution("83238")); //83238
        System.out.println(solution("0990")); //909
        System.out.println(solution("010")); //1
        System.out.println(solution("39878")); //898
        System.out.println(solution("54321")); //5
    }
}
