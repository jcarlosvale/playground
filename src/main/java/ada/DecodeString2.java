package ada;

import java.util.LinkedList;

public class DecodeString2 {
    public static String decodeString(String s) {
        LinkedList<Integer> countStack = new LinkedList<>();
        LinkedList<String> stringStack = new LinkedList<>();
        String curr = "";
        int count = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(curr);
                count = 0;
                curr = "";
            } else if (c == ']') {
                StringBuilder builder = new StringBuilder(stringStack.pop());
                int counter = countStack.pop();
                for(int i = 1; i <= counter; i++ ) {
                    builder.append(curr);
                }
                curr = builder.toString();
            } else {
                curr += c;
            }
        }
        return curr;
    }
}
