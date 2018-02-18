package org.academiadecodigo.group.academydefense.grid;

public class GridUtils {

    public static int rowToY(int row) {
        return TiledGrid.CELL_SIZE * row + TiledGrid.PADDING;
    }

    public static int columnToX(int column) {
        return TiledGrid.CELL_SIZE * column + TiledGrid.PADDING;
    }
}