package tests.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseANDNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        if (m == n) return n;
        BitSet max = convert(n);
        BitSet min = convert(m);

        int higherMostLeft = max.nextSetBit(max.length()-1);
        int lowerMostLeft = min.nextSetBit(min.length()-1);


        max.and(min);

        TreeSet<Integer> setOfBits = new TreeSet<>();
        for (int i = max.nextSetBit(0); i >= 0; i = max.nextSetBit(i+1)) {
            setOfBits.add(i);
        }
        List<Integer> bitsToRemove = new ArrayList<>();
        for(int pos : setOfBits) {

            for(int i = lowerMostLeft; i<=higherMostLeft; i++) {
                BitSet temp = convert((int) Math.pow(2,i+1)-1);
                temp.clear(pos);
                int number = convert(temp);
                if(number >= m && number<=n) {
                    bitsToRemove.add(pos);
                    break;
                }
            }
        }
        setOfBits.removeAll(bitsToRemove);
        BitSet acc = new BitSet();
        for(int i : setOfBits) {
            acc.set(i);
        }
        return convert(acc);
    }

    public static BitSet convert(int value) {
        BitSet bits = new BitSet();
        int index = 0;
        while (value != 0L) {
            if (value % 2L != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }

    public static int convert(BitSet bits) {
        int value = 0;
        for (int i = 0; i < bits.length(); ++i) {
            value += bits.get(i) ? (1L << i) : 0L;
        }
        return value;
    }

    public static void main(String[] args) {
//        System.out.println(rangeBitwiseAnd(5,7)); //4
//        System.out.println(rangeBitwiseAnd(6,7)); //6
//        System.out.println(rangeBitwiseAnd(0,1)); //0
//        System.out.println(rangeBitwiseAnd(0,1)); //0
//        System.out.println(rangeBitwiseAnd(1,4)); //0
//        System.out.println(rangeBitwiseAnd(20000,2147483647)); //0
//        System.out.println(rangeBitwiseAnd(600000000,2147483645)); //0
//        System.out.println(rangeBitwiseAnd(1,3)); //0
//        System.out.println(rangeBitwiseAnd(3,3)); //3
//        System.out.println(rangeBitwiseAnd(1,5)); //0
        System.out.println(rangeBitwiseAnd(3,5)); //0

    }
}
