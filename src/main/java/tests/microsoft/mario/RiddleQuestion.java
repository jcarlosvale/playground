package tests.microsoft.mario;

public class RiddleQuestion {

    public static String solution(String riddle) {
        char [] chars = riddle.toCharArray();
        if(riddle.length() == 1) {
            if(riddle.charAt(0) == '?') {
                return "a";
            } else {
                return riddle;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            boolean containA = false;
            boolean containB = false;
            boolean containC = false;

            if(chars[i] == '?') {
                if (i-1 >= 0) {
                    if(chars[i-1] == 'a') containA = true;
                    if(chars[i-1] == 'b') containB = true;
                    if(chars[i-1] == 'c') containC = true;
                }
                if (i+1 < chars.length) {
                    if(chars[i+1] == 'a') containA = true;
                    if(chars[i+1] == 'b') containB = true;
                    if(chars[i+1] == 'c') containC = true;
                }
                if(!containA){
                    chars[i] = 'a';
                    continue;
                }
                if(!containB){
                    chars[i] = 'b';
                    continue;
                }
                chars[i] = 'c';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(solution("ab?ac?"));
        System.out.println(solution("rd?e?wg??"));
        System.out.println(solution("????????"));
    }
}
