package tests.facebook.interviewbits;

import java.util.List;
import java.util.TreeSet;

public class LIS {
    public int lis(final List<Integer> A) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Integer i : A) {
            Integer ceil = treeSet.ceiling(i);
            if (ceil != null) {
                treeSet.remove(ceil);
            }
            treeSet.add(i);
        }
        return treeSet.size();
    }
}
