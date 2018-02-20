package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.group.academydefense.grid.tiles.TiledGrid;

public class GridUtils {

    public static int rowToY(int row) {
        return TiledGrid.CELL_SIZE * row + TiledGrid.PADDING;
    }

    public static int columnToX(int column) {
        return TiledGrid.CELL_SIZE * column + TiledGrid.PADDING;
    }
}
