package tests.hackerrank.certification.intermediate;

import java.util.ArrayList;
import java.util.List;

public class OfficeRenovation {
    public static List<Long> getMaxArea(int w, int h, List<Boolean> boundaryType, List<Integer> boundaryDist) {
        List<Long> maximumArea = new ArrayList<>();
        long currentW = w;
        long currentH = h;
        long maxArea = w * h;
        for (int i = 0; i < boundaryType.size(); i++) {
            int dist = boundaryDist.get(i);
            if (boundaryType.get(i)) { //vertical
                for (int d = dist; d > 0 ; d--) {
                    if ((currentW - d) * currentH > maxArea - (currentH * (currentW - d))) {  //satisfies
                        currentW = currentW - d;
                        break;
                    }
                }
                maximumArea.add(currentH * currentW);
            } else {  //horizontal
                for (int d = dist; d > 0 ; d--) {
                    if ((currentH - d) * currentW > maxArea - ((currentH - d) * currentW)) {  //satisfies
                        currentH = currentH - d;
                        break;
                    }
                }
                maximumArea.add(currentH * currentW);
            }
        }
        return maximumArea;
    }

    public static void main(String[] args) {
        List<Boolean> boundaryType = new ArrayList<>();
        boundaryType.add(true);
        boundaryType.add(true);
        List<Integer> boundaryDist = new ArrayList<>();
        boundaryDist.add(1);
        boundaryDist.add(3);
        int w = 4;
        int h = 3;
        System.out.println(getMaxArea(w, h, boundaryType, boundaryDist));


        w=2;
        h=2;

        boundaryType.clear();
        boundaryType.add(false);
        boundaryType.add(true);

        boundaryDist.clear();
        boundaryDist.add(1);
        boundaryDist.add(1);

        System.out.println(getMaxArea(w, h, boundaryType, boundaryDist));  //2, 1


    }
}
