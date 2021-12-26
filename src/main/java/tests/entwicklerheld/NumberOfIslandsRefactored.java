package tests.entwicklerheld;

import java.util.Iterator;

class NumberOfIslandsRefactored {
    public static class Map implements Iterable<MapPart> {
        private final MapPart[][] mapParts;

        public Map(char[][] grid) {
            if (grid == null) {
                mapParts = new MapPart[0][0];
            } else {
                mapParts = new MapPart[grid.length][];
                for (int i = 0; i < grid.length; i++) {
                    if (grid[i] == null) {
                        mapParts[i] = new MapPart[0];
                    } else {
                        mapParts[i] = new MapPart[grid[i].length];
                    }
                    for (int j = 0; j < grid[i].length; j++) {
                        mapParts[i][j] = new MapPart(i,j,grid[i][j]);
                    }
                }
            }
        }

        public MapPart getTopMapPart(MapPart referenceMapPart) {
            int row = referenceMapPart.row-1;
            if (row >= 0) {
                return mapParts[row][referenceMapPart.column];
            }
            return new MapPart(row, referenceMapPart.column, '0');
        }

        public MapPart getBottomMapPart(MapPart referenceMapPart) {
            int row = referenceMapPart.row+1;
            if (row < mapParts.length) {
                return mapParts[row][referenceMapPart.column];
            }
            return new MapPart(row, referenceMapPart.column, '0');
        }

        public MapPart getLeftMapPart(MapPart referenceMapPart) {
            int column = referenceMapPart.column-1;
            if (column >= 0) {
                return mapParts[referenceMapPart.row][column];
            }
            return new MapPart(referenceMapPart.row, column, '0');
        }

        public MapPart getRightMapPart(MapPart referenceMapPart) {
            int column = referenceMapPart.column+1;
            if (column < mapParts[referenceMapPart.row].length) {
                return mapParts[referenceMapPart.row][column];
            }
            return new MapPart(referenceMapPart.row, column, '0');
        }

        public Iterator<MapPart> iterator() {
            return new Iterator<MapPart>() {

                private int currentRow = 0;
                private int currentColumn = 0;

                public boolean hasNext() {
                    return !(currentRow >= mapParts.length || currentColumn >= mapParts[currentRow].length);
                }

                public MapPart next() {
                    if ((currentRow >=  mapParts.length) || (currentColumn >= mapParts[0].length)) return null;
                    MapPart mapPart = mapParts[currentRow][currentColumn];
                    if (currentColumn == mapParts[currentRow].length - 1) {
                        currentColumn = 0;
                        currentRow++;
                    }  else {
                        currentColumn++;
                    }

                    return mapPart;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public MapPart[][] getMapParts() {
            return mapParts;
        }
    }


    public int numIslands(char[][] grid) {
        Map map = new Map(grid);
        int islandCount = 0;

        for (MapPart mapPart : map) {
            if (mapPart.isWater() || mapPart.wasChecked) {
                continue;
            }

            islandCount += 1;
            mapPart.wasChecked = true;

            this.checkSurroundings(map, mapPart);
        }
        return islandCount;
    }

    private void checkSurroundings(Map map, MapPart part) {
        MapPart topMapPart = map.getTopMapPart(part);
        if (topMapPart.isLand() && !topMapPart.wasChecked) {
            topMapPart.wasChecked = true;
            checkSurroundings(map, topMapPart);
        }

        MapPart bottomPart = map.getBottomMapPart(part);
        if (bottomPart.isLand() && !bottomPart.wasChecked) {
            bottomPart.wasChecked = true;
            checkSurroundings(map, bottomPart);
        }

        MapPart rightPart = map.getRightMapPart(part);
        if (rightPart.isLand() && !rightPart.wasChecked) {
            rightPart.wasChecked = true;
            checkSurroundings(map, rightPart);
        }

        MapPart leftPart = map.getLeftMapPart(part);
        if (leftPart.isLand() && !leftPart.wasChecked) {
            leftPart.wasChecked = true;
            checkSurroundings(map, leftPart);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'0', '0', '0', '0'}, {'0', '0', '0', '0'}, {'0', '0', '0', '0'}};
        NumberOfIslandsRefactored app = new NumberOfIslandsRefactored();
//        System.out.println(app.numIslands(grid));
        System.out.println(app.numIslands(new char[][]{{'1','1','1','1'}, {'1','1','1','1'}, {'1','1','1','1'}}));

//        System.out.println(app.numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1',
//        '1'}}));  //3
//        System.out.println(app.numIslands(new char[][]{{'1','1','1'}, {'0','1','0'}, {'1','1','1'}})); //1

    }
}