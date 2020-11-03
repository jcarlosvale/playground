package tests.aubay;

public class Test {
    public static int some(int [] ts) {
        if (ts == null || ts.length == 0) return 0;
        int closest = 0;
        int maxDif = Integer.MAX_VALUE;
        for(int t: ts) {
            if(Math.abs(0 - t) <= maxDif) {
                maxDif = Math.abs(0 - t);
                if (t + closest == 0) {
                    closest = Math.abs(t);
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println("foo".equals(null));    }
}
