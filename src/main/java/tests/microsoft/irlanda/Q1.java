package tests.microsoft.irlanda;

public class Q1 {
    public static String solution(int[] T) {
        int size_of_period = T.length / 4;
        //winter
        int winter_max_amplitude = getMaxAmp(T, 0, size_of_period - 1);
        //spring
        int spring_max_amplitude = getMaxAmp(T, size_of_period, (2*size_of_period) - 1);
        //summer
        int summer_max_amplitude = getMaxAmp(T, (2*size_of_period), (3*size_of_period) - 1);
        //autumn
        int autumn_max_amplitude = getMaxAmp(T, (3*size_of_period), (4*size_of_period) - 1);

        int max = Math.max(winter_max_amplitude, Math.max(spring_max_amplitude, Math.max(summer_max_amplitude, autumn_max_amplitude)));

        if(max == winter_max_amplitude) return "WINTER";
        if(max == spring_max_amplitude) return "SPRING";
        if(max == summer_max_amplitude) return "SUMMER";
        return "AUTUMN";
    }

    private static int getMaxAmp(int[] T, int start, int end) {
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end-1; i++) {
            max = Math.max(max, Math.abs(T[i+1] - T[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {-3,-14, -5, 7, 8, 42, 8, 3})); //SUMMER
    }
}
