package org.academiadecodigo.group.academydefense.grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class TilePictured extends Tile{

    private Picture picture;
    private Direction currentDirection;

    public TilePictured(int col, int row, String path) {
        super(col, row, 64);
        this.picture = new Picture(col, row, path);
    }

    private void move(Direction direction, int speed){
        switch (direction){
            case RIGHT:
                picture.translate(speed, 0);
                currentDirection = Direction.RIGHT;
                break;
            case LEFT:
                picture.translate(-speed, 0);
                currentDirection = Direction.LEFT;
                break;
            case UP:
                picture.translate(0, -speed);
                currentDirection = Direction.UP;
                break;
            case DOWN:
                picture.translate(0, speed);
                currentDirection = Direction.DOWN;
                break;
        }
    }

    public void hide(){
        picture.delete();
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
        return picture.getX();
    }

    public int getY(){
        return picture.getY();
    }

    public Picture getPicture() {
        return picture;
    }

    @Override
    public void draw() {
        picture.draw();
    }
}
