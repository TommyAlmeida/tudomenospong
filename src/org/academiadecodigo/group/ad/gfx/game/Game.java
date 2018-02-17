package org.academiadecodigo.group.ad.gfx.game;

import org.academiadecodigo.group.ad.gfx.enemies.Enemy;
import org.academiadecodigo.group.ad.gfx.enemies.EnemyFactory;
import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.grid.GridFactory;
import org.academiadecodigo.group.ad.gfx.grid.GridType;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Game {

    private Enemy[] enemies;

    private Grid grid;

    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);

    }

    public void init(){
        grid.init();

        int enemiesCount = 10;
        enemies = new Enemy[enemiesCount];
        for (int i = 0; i < enemiesCount; i++) {
            enemies[i] = EnemyFactory.makeEnemy();
            enemies[i].setGrid(grid);
        }

    }

    public void start(){

        while(true){
            moveAllEnemies();
        }

    }


    public void moveAllEnemies(){
        for (Enemy e: enemies) {
            e.move();
        }
    }


}
