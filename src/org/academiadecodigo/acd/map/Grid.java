package org.academiadecodigo.acd.map;

import org.academiadecodigo.acd.game.GameConsts;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int PADDING = 10;
    private int cellSize;
    private int gridWidth;

    private int cols, rows;
    private Rectangle grid;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        System.out.println(getCellSize());
        this.gridWidth = GameConsts.WINDOW_WIDTH;
        this.cellSize = gridWidth / cols;
        this.grid = new Rectangle(PADDING, PADDING, rows * getCellSize(), cols * getCellSize());

        grid.setColor(Color.BLUE);
        grid.draw();
    }

    // Creates a new multi-dimensional array with x rows and y columns
    private int gridArray[][] = new int[cols][rows];


    public int getWidth() {
        return grid.getWidth();
    }

    // Getter for the CellSize
    public int getCellSize() {
        return cellSize;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getX() {
        return grid.getX();
    }

    public int getY() {
        return grid.getY();
    }

    public int getRowToY(int row) {
        return row * cellSize + PADDING;
    }

    public int getColumnToX(int column) {
        return column * cellSize + PADDING;
    }
}