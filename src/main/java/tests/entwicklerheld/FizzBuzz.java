package tests.entwicklerheld;

public class FizzBuzz {
    public static String fizzbuzz(int n) {
        boolean divBy3 = n % 3 == 0;
        boolean divBy5 = n % 5 == 0;
        boolean divBy15 = n % 15 == 0;

        if(divBy15) return "fizzbuzz";
        if(divBy3) return "fizz";
        if(divBy5) return "buzz";

        return n+"";

    }
}
