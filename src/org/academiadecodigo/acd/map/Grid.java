package org.academiadecodigo.acd.map;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int PADDING = 10;
    private int cellSize;
    private int gridWidth = getWidth();

    private int cols, rows;
    private Rectangle grid;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.grid = new Rectangle(PADDING, PADDING, rows * getCellSize(), cols * getCellSize());
        grid.draw();
    }

    // Creates a new multi-dimensional array with x rows and y columns
    private int gridArray[][] = new int[32][32];


    public int getWidth() {
        return grid.getWidth();
    }

    // Getter for the CellSize
    public int getCellSize() {
        return cellSize;
    }

    //CellSize is variable and depends on the size chosen for the canvas
    public void setCellSize(int cols, int gridWidth) {
        this.cellSize = gridWidth / cols;
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


//TODO: copy from car crash
}