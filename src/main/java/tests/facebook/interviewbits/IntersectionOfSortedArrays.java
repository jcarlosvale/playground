package tests.facebook.interviewbits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int sizeA = A.size();
        int sizeB = B.size();
        ArrayList<Integer> ans = new ArrayList<>();

        List<Integer> higher;
        List<Integer> lower;
        if (sizeB > sizeA) {
            lower = A;
            higher = B;
        } else {
            lower = B;
            higher = A;
        }
        //corner case not intersect
        if (lower.get(0) > higher.get(higher.size()-1) || lower.get(lower.size() - 1) < higher.get(0)) return ans;

        //positioning pointers
        int indexLower = 0, indexHigher = 0;
        if(lower.get(0).equals(higher.get(0))) {
            ans.add(lower.get(0));
            indexHigher++;
            indexLower++;
        } else {
            if (lower.get(0) > higher.get(0)) {
                indexHigher = Collections.binarySearch(higher, lower.get(0));
                if (indexHigher < 0) {
                    indexHigher = -(indexHigher + 1);
                } else {
                    indexLower++;
                    indexHigher++;
                    ans.add(lower.get(0));
                }
            } else {
                indexLower = Collections.binarySearch(lower, higher.get(0));
                if (indexLower < 0) {
                    indexLower = -(indexLower + 1);
                } else {
                    indexLower++;
                    indexHigher++;
                    ans.add(higher.get(0));
                }
            }
        }

        //navigate both
        boolean searching = indexLower < lower.size() && indexHigher < higher.size();
        while(searching) {
            if(lower.get(indexLower).equals(higher.get(indexHigher))) {
                ans.add(lower.get(indexLower));
                indexHigher++;
                indexLower++;
            } else {
                if (lower.get(indexLower) < higher.get(indexHigher)) {
                    indexLower++;
                } else {
                    indexHigher++;
                }
            }
            searching = indexLower < lower.size() && indexHigher < higher.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(7, 10, 10, 16, 17, 18, 20, 21));
        ArrayList<Integer> B = new ArrayList<>(List.of(3, 5, 7, 9, 19, 21));
        System.out.println(intersect(A, B)); //7, 21
    }

}

