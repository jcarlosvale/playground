package tests.westpark;

import java.util.ArrayList;
import java.util.List;

// Singleton PolygonProvider which holds a list of polygons

public class PolygonProvider {
    private static PolygonProvider instance = null;
    private List<Polygon> polygons = new ArrayList<>();

    private PolygonProvider() {
    }

    public static PolygonProvider getInstance() {
        if (instance == null) {
            instance = new PolygonProvider();
        }
        return instance;
    }

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }

    public void clear() {
        polygons.clear();
    }

    public List<Label> getLabels() {
        List<Label> labels = new ArrayList<>();
        for (Polygon polygon : polygons) {
            if (polygon.getLabel() != null) {
                labels.add(polygon.getLabel());
            }
        }
        return labels;
    }
}