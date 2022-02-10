package tests.facebook.preparation;

/**
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
 * Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?".
 * Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A),
 * and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0).
 * Note that the non-alphanumeric characters remain unchanged.
 * Given a string and a rotation factor, return an encrypted string.
 * Signature
 * string rotationalCipher(string input, int rotationFactor)
 * Input
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 * Output
 * Return the result of rotating input a number of times equal to rotationFactor.
 * Example 1
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 * Example 2
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class RotationalCipher {
    public static String rotationalCipher(String input, int rotationFactor) {
        final int MIN_UPPERCASE = 'A';
        final int MAX_UPPERCASE = 'Z';

        final int MIN_LOWERCASE = 'a';
        final int MAX_LOWERCASE = 'z';

        final int MIN_NUMBER = '0';
        final int MAX_NUMBER = '9';

        StringBuilder result = new StringBuilder();

        for(char c: input.toCharArray()) {
            if (c >= MIN_UPPERCASE && c <= MAX_UPPERCASE) {
                result.append(rotate(c, rotationFactor, MIN_UPPERCASE, MAX_UPPERCASE));
            } else {
                if (c >= MIN_LOWERCASE && c <= MAX_LOWERCASE) {
                    result.append(rotate(c, rotationFactor, MIN_LOWERCASE, MAX_LOWERCASE));
                } else {
                    if (c >= MIN_NUMBER && c <= MAX_NUMBER) {
                        result.append(rotate(c, rotationFactor, MIN_NUMBER, MAX_NUMBER));
                    } else {
                        result.append(c);
                    }
                }
            }
        }
        
        return result.toString();
    }

    private static char rotate(char c, int rotationFactor, int min_value, int max_value) {
        int length = max_value - min_value + 1;
        int rotation = ((c + rotationFactor - min_value) % length);
        return (char) (min_value + rotation);
    }

    public static void main(String[] args) {
        System.out.println(rotationalCipher("Zebra-493?", 3)); //Cheud-726?
        System.out.println(rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39).equals("nopqrstuvwxyzABCDEFGHIJKLM9012345678"));
    }
}
