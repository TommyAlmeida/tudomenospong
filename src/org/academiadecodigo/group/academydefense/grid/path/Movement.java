package org.academiadecodigo.group.academydefense.grid.path;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.grid.Direction;

/**
 * Created by codecadet on 19/02/2018.
 */
public class Movement {

    private Path path = new Path();
private Enemy enemy = new Enemy();
    private int currentMove;

    public void setEnemyMove() {
        if (path.definedMove == 0){
            enemy.move(Direction.UP);
        } else if (path.definedMove == 1){
            enemy.move(Direction.RIGHT);
        } else if (path.definedMove == 2){
            enemy.move(Direction.DOWN);
        } else {
           enemy.move(Direction.LEFT);
        }
    }

    public int getEnemyMove(){
        return currentMove;
    }

}
