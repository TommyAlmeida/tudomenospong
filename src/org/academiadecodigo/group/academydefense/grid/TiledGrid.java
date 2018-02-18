package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class TiledGrid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 32;

    private final int WIDTH = 50;
    private final int HEIGHT = 28;

    private TileShape tiles[][] = new TileShape[WIDTH][HEIGHT];

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

    public Tile getTile(int x, int y) {
        int xS = conversion(x);
        int yS = conversion(y);

        return tiles[xS][yS];
    }

    public int conversion(int value) {
        return (value - PADDING) / CELL_SIZE;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }
}
