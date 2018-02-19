
package org.academiadecodigo.group.academydefense.grid.path;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.enemies.EnemyType;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
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
    private Tower tower = new Tower();
    //private Enemy enemy = new Enemy();



    private int startingX = GridUtils.columnToX(10)*64 + 10;
    private int startingY = GridUtils.rowToY(10)*64 + 10;
    private int firstTurnX = GridUtils.columnToX(14)*64 + 10;
    private int firstTurnY = GridUtils.rowToY(10)*64 + 10;
    private int secondTurnX = GridUtils.columnToX(14);
    private int secondTurnY = GridUtils.rowToY(6);
    public int definedMove;


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
       // enemy.getSprite().moveRight(enemy.getSpeed());
        //System.out.println("caralho!");
        if (tower.getEnemyPosX() == startingX && tower.getEnemyPosY() == startingY){
            definedMove = 1;
            System.out.println("starting point, moving right");
        } else if (tower.getEnemyPosX() == firstTurnX && tower.getEnemyPosY() == firstTurnY) {
            definedMove = 0;
            System.out.println("first turn, moving up");
        } else if (tower.getEnemyPosX() == secondTurnX && tower.getEnemyPosY() == secondTurnY) {
            definedMove = 1;
            System.out.println("second turn, moving right");
        } else {
            System.out.println("deu merda!");
            return;
        }
    }


}
