package org.academiadecodigo.group.academydefense.grid;

public abstract class Tile {

    private int col;
    private int row;
    private int cellSize;

    public Tile(int col, int row, int cellSize) {
        this.col = col;
        this.row = row;
        this.cellSize = cellSize;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col += col;
    }

    public int getCellSize() {
        return cellSize;
    }

    public abstract void draw();
}
