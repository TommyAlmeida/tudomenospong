
package org.academiadecodigo.group.academydefense.grid.path;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.grid.Direction;
import org.academiadecodigo.group.academydefense.grid.GridUtils;
import org.academiadecodigo.group.academydefense.grid.TilePictured;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by codecadet on 19/02/2018.
 */

public class Path {

    private Picture picture;
    private Direction currentDirection;
    private TilePictured tilePictured;
    private Enemy enemy;



    private int startingX = GridUtils.columnToX(10);
    private int startingY = GridUtils.rowToY(10);
    private int firstTurnX = GridUtils.columnToX(14);
    private int firstTurnY = GridUtils.rowToY(10);
    private int secondTurnX = GridUtils.columnToX(14);
    private int secondTurnY = GridUtils.rowToY(6);

    public int getStartingX(){
        return startingX;
    }
    public int getStartingY(){
        return startingY;
    }


    public void changeDirection(Direction direction, int speed){
        switch(direction) {
            case RIGHT:
                tilePictured.moveRight(speed);
                break;
            case UP:
                tilePictured.moveUp(speed);
                break;


        }
    }

    public void changeDir() {
        if (enemy.getSprite().getX() == startingX && enemy.getSprite().getY() == startingY){
            enemy.getSprite().moveRight(enemy.getSpeed());
            System.out.println("starting point, moving right");
        } else if (enemy.getSprite().getX() == firstTurnX && enemy.getSprite().getY() == firstTurnY) {
            enemy.getSprite().moveUp(enemy.getSpeed());
            System.out.println("first turn, moving up");
        } else if (enemy.getSprite().getX() == secondTurnX && enemy.getSprite().getY() == secondTurnY) {
            enemy.getSprite().moveRight(enemy.getSpeed());
            System.out.println("second turn, moving right");
        } else {
            System.out.println("deu merda!");
            return;
        }
    }



}
