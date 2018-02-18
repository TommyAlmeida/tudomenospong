package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tile {

    private int col;
    private int row;
    private int cellSize;

    protected Color color;
    private Rectangle rectangle;

    public Tile(int col, int row, int cellSize, Color color) {
        this.col = col;
        this.row = row;
        this.color = color;
        this.cellSize = cellSize;
        this.rectangle = new Rectangle(col, row, cellSize, cellSize);
    }

    public void draw() {
        rectangle.setColor(color);
        rectangle.draw();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        rectangle.setColor(color);
    }

    private void move(Direction direction, int speed){
        switch (direction){
            case RIGHT:
                rectangle.translate(speed, 0);
                break;
            case LEFT:
                rectangle.translate(-speed, 0);
                break;
            case UP:
                rectangle.translate(0, -speed);
                break;
            case DOWN:
                rectangle.translate(0, speed);
                break;
        }
    }

    public void moveRight(int speed){
        move(Direction.RIGHT, speed);
    }

    public void moveLeft(int speed){
        move(Direction.LEFT, speed);
    }

    public void moveUp(int speed){
        move(Direction.UP, speed);
    }

    public void moveDown(int speed){
        move(Direction.DOWN, speed);
    }

    public void setCol(int col) {
        this.col += col;
    }

    public void show(){
        rectangle.fill();
    }

    public void hide(){
        rectangle.delete();
    }

    public int getCellSize() {
        return cellSize;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "col=" + col +
                ", row=" + row +
                ", color=" + color +
                ", rectangle=" + rectangle +
                '}';
    }
}
