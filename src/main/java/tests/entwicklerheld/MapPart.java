package tests.entwicklerheld;

public class MapPart {
    public final int row;
    public final int column;
    public final char value;

    public boolean wasChecked = false;

    public MapPart(int row, int column, char value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public boolean isWater() {
        return this.value == '0';
    }

    public boolean isLand() {
        return this.value == '1';
    }
}