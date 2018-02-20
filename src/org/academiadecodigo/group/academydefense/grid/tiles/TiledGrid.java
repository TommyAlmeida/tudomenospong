package org.academiadecodigo.group.academydefense.grid.tiles;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Has the responsability of drawing our game board
 */
public class TiledGrid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 64;

    private final int WIDTH = 25;
    private final int HEIGHT = 11;

    private TileShape tiles[][] = new TileShape[WIDTH][HEIGHT];

    /**
     * Draw our tiles into a grid shape
     */
    public void draw() {
        for (int row = 0; row < tiles.length; row++) {
            for (int column = 0; column < tiles[row].length; column++) {
                int x = (row * CELL_SIZE) + PADDING;
                int y = (column * CELL_SIZE) + PADDING;

                tiles[row][column] = new TileShape(x, y, CELL_SIZE, Color.GREEN);
                tiles[row][column].draw();
            }
        }
    }
}
