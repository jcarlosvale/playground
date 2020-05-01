package tests.leetcode.challenge30days;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
 * of your product fails the quality check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 * following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl {
    private final int fail;

    public VersionControl(int fail) {
        this.fail = fail;
    }
    public boolean isBadVersion(int n) {
        if (n >= fail) {
            return true;
        }
        return false;
    }
}
public class FirstBadVersion  extends VersionControl {
    FirstBadVersion(int fail) {
        super(fail);
    }
    public int firstBadVersion(int n) {
        return binarySearch(1,n);
    }

    private int binarySearch(int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        int n = start + (end-start) / 2;
        if (isBadVersion(n)) {
            return Math.min(n, binarySearch(start, n-1));
        } else {
            return binarySearch(n+1, end);
        }
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion(4);
        System.out.println(firstBadVersion.firstBadVersion(5));

        firstBadVersion = new FirstBadVersion(1);
        System.out.println(firstBadVersion.firstBadVersion(1));

        firstBadVersion = new FirstBadVersion(1702766719);
        System.out.println(firstBadVersion.firstBadVersion(2126753390));

    }
}
