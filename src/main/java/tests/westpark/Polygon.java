package tests.westpark;


public class Polygon implements Drawable {
    private final Point[] vertices;
    private Label label;

    public Polygon(Point[] vertices) {
        this.vertices = vertices;
    }

    public Polygon(Point[] vertices, String labelText) {
        this.label = new Label(new Point(5, 0), labelText);
        this.vertices = vertices;
    }

    /**
     * Returns the top left corner of the label box
     *
     * @return the top left corner of the label box
     */

    public Point[] getVertices() {
        return vertices;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String toString() {
        StringBuilder verticesString = new StringBuilder();
        for (Point point : this.vertices) {
            if (point == null) {
                continue;
            }
            if (point.equals(this.vertices[this.vertices.length - 1])) {
                verticesString.append(point);
                continue;
            }
            verticesString.append(point).append(", ");
        }
        return "Polygon with vertices: " + verticesString;
    }

    int getHeight() {
        int height = 0;
        for (Point point : this.vertices) {
            if (point.y() > height) {
                height = point.y();
            }
        }
        return height;
    }

    int getWidth() {
        int width = 0;
        for (Point point : this.vertices) {
            if (point.x() > width) {
                width = point.x();
            }
        }
        return width;
    }

    public Point getCenter() {
        int x = 0;
        int y = 0;
        for (Point point : this.vertices) {
            x += point.x();
            y += point.y();
        }
        return new Point(x / this.vertices.length, y / this.vertices.length);
    }
}
