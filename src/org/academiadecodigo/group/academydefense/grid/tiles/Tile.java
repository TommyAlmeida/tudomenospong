package org.academiadecodigo.group.academydefense.grid.tiles;

import org.academiadecodigo.group.academydefense.grid.Direction;
import org.academiadecodigo.simplegraphics.graphics.Movable;

/**
 * Tile in-game means the shape/position displayed on the screen
 * So each tile is a cell of our grid
 */
public abstract class Tile {

    private int col;
    private int row;
    private int cellSize;

    private Movable movable;
    private Direction currentDirection;

    public Tile(int col, int row, int cellSize) {
        this.col = col;
        this.row = row;
        this.cellSize = cellSize;
    }

    /**
     * A utility to makeTilePictured the move code easier to read / write
     * @param direction
     * @param speed
     */
    private void move(Direction direction, int speed){
        switch (direction){
            case RIGHT:
                movable.translate(speed, 0);
                break;
            case LEFT:
                movable.translate(-speed, 0);
                break;
            case UP:
                movable.translate(0, -speed);
                break;
            case DOWN:
                movable.translate(0, speed);
                break;
        }
    }

    /**
     * Make the tile move in the right direction
     * @param speed tile moving speed
     */
    public void moveRight(int speed){
        move(Direction.RIGHT, speed);
    }

    /**
     * Make the tile move in the left direction
     * @param speed tile moving speed
     */
    public void moveLeft(int speed){
        move(Direction.LEFT, speed);
    }

    /**
     * Make the tile move in the up direction
     * @param speed tile moving speed
     */
    public void moveUp(int speed){
        move(Direction.UP, speed);
    }

    /**
     * Make the tile move in the down direction
     * @param speed tile moving speed
     */
    public void moveDown(int speed){
        move(Direction.DOWN, speed);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    void setMovable(Movable movable) {
        this.movable = movable;
    }

    public abstract void draw();
}
