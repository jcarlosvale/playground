package certification;

import java.util.ArrayList;
import java.util.List;

public class FindSquares {



    public static void findSquares(String[][] positions) {
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                for (int k = 1; k < positions.length; k++) {
                    evaluate(positions,i,j,k);
                }
            }
        }

    }

    //is it quadratic?
    private static void evaluate(String[][] positions, int i, int j, int size) {
        int maxRight = positions[0].length;
        int maxBelow = positions.length;
        if ((j+size < maxRight) && (i+size < maxBelow)) {
            System.out.println(positions[i][j]+positions[i][j+size]+positions[i+size][j]+positions[i+size][j+size]);
        }
    }

    public static void main(String[] args) {
        SomeClassWithEnum.SomeEnum x = SomeClassWithEnum.SomeEnum.VALUE1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0,0);
        list.add(2,0);
        System.out.println(list);
    }
}
