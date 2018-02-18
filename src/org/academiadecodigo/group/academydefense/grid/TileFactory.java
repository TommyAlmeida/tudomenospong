package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class TileFactory {

    public static Tile make(int col, int row, Color color){
        return new Tile(col, row, TiledGrid.CELL_SIZE, color);
    }

}
