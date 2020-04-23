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

        BitSet acc = convert(m);
        TreeSet<Integer> setOfBits = new TreeSet<>();
        for (int i = acc.nextSetBit(0); i >= 0; i = acc.nextSetBit(i+1)) {
            setOfBits.add(i);
        }

        for(int i = m+1; i<=n; i++) {
            if (setOfBits.isEmpty()) return 0;
            acc = convert(i);
            List<Integer> bitsToRemove = new ArrayList<>();
            for(int pos : setOfBits) {
                if(!acc.get(pos)) {
                    bitsToRemove.add(pos);
                }
            }
            setOfBits.removeAll(bitsToRemove);
        }

        acc.clear();
        for(int i : setOfBits) {
            acc.set(i);
        }

        return (int)  convert(acc);
    }

    public static BitSet convert(long value) {
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

    public static long convert(BitSet bits) {
        long value = 0L;
        for (int i = 0; i < bits.length(); ++i) {
            value += bits.get(i) ? (1L << i) : 0L;
        }
        return value;
    }

    public static void main(String[] args) {
//        System.out.println(rangeBitwiseAnd(5,7)); //4
//        System.out.println(rangeBitwiseAnd(0,1)); //0
//        System.out.println(rangeBitwiseAnd(20000,2147483647)); //0
        System.out.println(rangeBitwiseAnd(600000000,2147483645)); //0

    }
}
