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
/**
 public class SimpleGfxGrid implements Grid {

 public static final int PADDING = 10;
 private int cols;
 private int rows;
 private Rectangle canvas;

 public SimpleGfxGrid(int cols, int rows){
 this.cols = cols;
 this.rows = rows;

 }

@Override
public void init() {
    canvas = new Rectangle(PADDING,PADDING,cols * getCellSize(),rows * getCellSize());
    canvas.draw();
    canvas.setColor(Color.BLACK);
}


    @Override
    public int getCols() {
        return cols;
    }


    @Override
    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return canvas.getWidth();
    }

    public int getHeight() {
        return canvas.getHeight();
    }

    public int getX() {
        return canvas.getX();
    }

    public int getY() {
        return canvas.getY();
    }

    public int getCellSize() {
        return 20;
    }

    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col, row, this);
    }

    public int rowToY(int row) {
        return getCellSize() * row + PADDING;
    }

    public int columnToX(int column) {
        return getCellSize() * column + PADDING;
    }

    */