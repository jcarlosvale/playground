package tests.westpark;

import java.util.List;
import java.util.Objects;

public class MapService implements Drawable {
    static PolygonProvider polygonProvider = PolygonProvider.getInstance();


    public static Double calculatePolygonArea(final Point[] vertices) {
        // Scenario 1
        if (Objects.isNull(vertices)) return null;
        double sum = 0;
        double multiply = 0;
        for(int i = 0; i < vertices.length; i++) {
            if (i==0) {
                sum += vertices[vertices.length-1].x() * vertices[i].y();
                multiply += vertices[vertices.length-1].y() * vertices[i].x();
            } else {
                sum += vertices[i-1].x() * vertices[i].y();
                multiply += vertices[i-1].y() * vertices[i].x();
            }
        }
        double diff= Math.abs(sum - multiply);
        return diff / 2.0;

    }

    public static void calculateAndSetLabelsForPolygons(List<String> labelNames) {
        // Scenario 2
        int i = 0;
        for (Polygon polygon: polygonProvider.getPolygons()) {
            Label label = new Label(new Point(0, 0), labelNames.get(i));
            Point position = calculatePosition(polygon, label, 400, 300);
            polygon.setLabel(new Label(position, labelNames.get(i)));
            i++;
        }
    }

    private static Point calculatePosition(Polygon polygon, Label label, int maxHeight, int maxWidth) {
//        if (canInsertInside(polygon, label)) {
//            if (canBeCentered(polygon, label)) {
//
//            }
//        }
        return null;
    }

    private static boolean canInsertInside(Polygon polygon, Label label) {
        return polygon.getHeight() <= label.getLabelHeight() || polygon.getWidth() <= label.getLabelWidth();
    }

    public static void main(String[] args) {
        Point[] points = {new Point(50, 150),
                new Point(45, 250),
                new Point(120, 240),
                new Point(200, 250),
                new Point(200, 150),
                new Point(350, 170),
                new Point(370, 50),
                new Point(220, 50),
                new Point(220, 100),
                new Point(50, 100)};
        System.out.println(calculatePolygonArea(points));

        calculateAndSetLabelsForPolygons(List.of("Westpark München", "SWM Park", "Englischer Garten"));

    }
}