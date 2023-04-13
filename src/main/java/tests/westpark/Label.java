package tests.westpark;


public class Label implements Drawable {
    private Point[] boundingBox;
    private String text;

    private static final int FONT_SIZE = 14; // as px
    private static final float CHAR_WIDTH = 8.4f;
    private static final String FONT_FAMILY = "Monospace";

    public Label(Point position, String text) {
        this.text = text;
        this.boundingBox = this.calculateBoundingBox(position);
    }

    private Point[] calculateBoundingBox(Point position) {
        Point[] borderBox = new Point[4];
        // top left
        borderBox[0] = position;
        // bottom left
        borderBox[1] = new Point(position.x(), position.y() + this.getLabelHeight());
        // bottom right
        borderBox[2] = new Point(position.x() + this.getLabelWidth(), position.y() + this.getLabelHeight());
        // top right
        borderBox[3] = new Point(position.x() + this.getLabelWidth(), position.y());

        return borderBox;
    }

    public int getLabelHeight() {
        return FONT_SIZE;
    }

    public int getLabelWidth() {
        return (int) (this.text.length() * CHAR_WIDTH);
    }

    public static int getFontSize() {
        return FONT_SIZE;
    }

    public static String getFontFamily() {
        return FONT_FAMILY;
    }

    public Point getPositionOfTextInBox() {
        // Top left corner of the box minus the font size
        int x = this.boundingBox[0].x();
        int y = this.boundingBox[0].y();

        return new Point(x, y + FONT_SIZE - 2);

    }

    public Point getTopLeftCornerOfLabelBox() {
        return this.boundingBox[0];
    }

    public Point getBottomLeftCornerOfLabelBox() {
        return this.boundingBox[1];
    }

    public Point getBottomRightCornerOfLabelBox() {
        return this.boundingBox[2];
    }

    public Point getTopRightCornerOfLabelBox() {
        return this.boundingBox[3];
    }

    public Point getCenterOfLabelBox() {
        int x = (this.boundingBox[0].x() + this.boundingBox[2].x()) / 2;
        int y = (this.boundingBox[0].y() + this.boundingBox[2].y()) / 2;
        return new Point(x, y);
    }

    public Point[] getBoundingBox() {
        return this.boundingBox;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return "Label with text: " + this.text + " and border box: " + this.boundingBox[0] + ", " + this.boundingBox[1] + ", " + this.boundingBox[2] + ", " + this.boundingBox[3] + ".";
    }

    public Point getTopLeft() {
        return this.boundingBox[0];
    }

    public Point getBottomLeft() {
        return this.boundingBox[1];
    }

    public Point getBottomRight() {
        return this.boundingBox[2];
    }

    public Point getTopRight() {
        return this.boundingBox[3];
    }

    public Point getCenter() {
        return new Point((this.boundingBox[0].x() + this.boundingBox[2].x()) / 2, (this.boundingBox[0].y() + this.boundingBox[2].y()) / 2);
    }

}
