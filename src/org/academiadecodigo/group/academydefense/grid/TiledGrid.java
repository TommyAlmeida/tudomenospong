package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.gfx.Tile;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class TiledGrid {

    public static final int PADDING = 0;
    private final int CELL_SIZE = 32;

    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    private Tile tiles[][] = new Tile[WIDTH][HEIGHT];

    public void draw() {
        for (int row = 0; row < tiles.length; row++) {
            for (int column = 0; column < tiles[row].length; column++) {
                int x = (row * CELL_SIZE) + PADDING;
                int y = (column * CELL_SIZE) + PADDING;

                tiles[row][column] = new Tile(x, y, CELL_SIZE, Color.GREEN);
                tiles[row][column].draw();
            }
        }
    }

    public Tile getTile(int x, int y) {
        int xS = conversionXY(x);
        int yS = conversionXY(y);

        return tiles[xS][yS];
    }

    public boolean hasTower(int x, int y){
        return tiles[x][y] != null;
    }

    public int conversionXY(int value) {
        return (value / CELL_SIZE) + PADDING;
    }

    public int rowToY(int row) {
        return CELL_SIZE * row + PADDING;
    }

    public int columnToX(int column) {
        return CELL_SIZE * column + PADDING;
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
