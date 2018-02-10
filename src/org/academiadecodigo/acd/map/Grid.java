package org.academiadecodigo.acd.map;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int PADDING = 10;
    private int cellSize = 10;

    private int cols, rows;
    private Rectangle grid;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.grid = new Rectangle(PADDING, PADDING, 300, 300);
    }

    public int getCellsize(){
        return cellSize;
    }

    public int getRowToY(int row){
        return row * cellSize + PADDING;
    }

    public int getColumnToX(int column){
        return column * cellSize + PADDING;
    }

    //TODO: copy from car crash
}
