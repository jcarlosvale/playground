package tests.bolt;

public class ReverseWords {

    public static char[] reverseWords(char [] input) {
        if (null == input) return input;
        if (input.length <= 1) return input;
        int startWord = -1;
        int endWord;
        char tempChar;
        //iterate and reverse words
        for(int i = 0; i < input.length; i++) {
            if ((input[i] == ' ') || (i == input.length - 1)){
                if(startWord >= 0) {
                    if (i<input.length - 1) {
                        endWord = i-1;
                    } else {
                        endWord = i;
                    }
                    //reverse word
                    while(endWord > startWord) {
                        //swap characters
                        tempChar = input[endWord];
                        input[endWord] = input [startWord];
                        input[startWord] = tempChar;
                        endWord--;
                        startWord++;
                    }
                    startWord = -1;
                }
            } else {
                if (startWord < 0) {
                    startWord = i;
                }
            }
        }
        return input;
    }
}
