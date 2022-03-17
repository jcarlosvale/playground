package tests.facebook.interviewbits;

public class AddBinary {

    public static String addBinary(String A, String B) {
        StringBuilder ans = new StringBuilder();
        int size = Math.max(A.length(), B.length());
        boolean acc = false;
        for(int i = 0; i < size; i++) {
            boolean value1 = i < A.length() && A.charAt(A.length() - 1 - i) == '1';
            boolean value2 = i < B.length() && B.charAt(B.length() - 1 - i) == '1';
            boolean sum = (value1 ^ value2) ^ acc;
            acc = (value1 && value2)  || (!sum && acc);
            if (sum) ans.append('1');
            else ans.append('0');
        }
        if (acc) ans.append('1');
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));
    }

}
