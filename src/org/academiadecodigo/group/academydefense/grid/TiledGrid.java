package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.group.academydefense.gfx.Tile;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class TiledGrid {

    public static final int PADDING = 0;
    public final int CELL_SIZE = 32;

    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    public void draw() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                int x = (j * CELL_SIZE) + PADDING;
                int y = (i * CELL_SIZE) + PADDING;

                new Tile(x, y, CELL_SIZE, Color.GREEN).draw();
            }
        }
    }

    public Tile getTile(int x, int y) {
        int xS = conversionXY(x);
        int yS = conversionXY(y);

        return null;
    }

    public int conversionXY(int value) {
        return (value / CELL_SIZE);
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
