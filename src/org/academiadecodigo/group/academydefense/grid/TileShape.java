package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class TileShape extends Tile {

    private Color color;
    private Rectangle rectangle;
    private Direction currentDirection;

    public TileShape(int col, int row, int cellSize, Color color) {
        super(col, row, cellSize);

        this.color = color;
        this.rectangle = new Rectangle(col, row, cellSize, cellSize);
    }

    @Override
    public void draw() {
        rectangle.setColor(color);
        rectangle.fill();
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
                currentDirection = Direction.RIGHT;
                break;
            case LEFT:
                rectangle.translate(-speed, 0);
                currentDirection = Direction.LEFT;
                break;
            case UP:
                rectangle.translate(0, -speed);
                currentDirection = Direction.UP;
                break;
            case DOWN:
                rectangle.translate(0, speed);
                currentDirection = Direction.DOWN;
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

    public int getX(){
        return rectangle.getX();
    }

    public int getY(){
        return rectangle.getY();
    }

    public void show(){
        rectangle.fill();
    }

    public void hide(){
        rectangle.delete();
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
}
