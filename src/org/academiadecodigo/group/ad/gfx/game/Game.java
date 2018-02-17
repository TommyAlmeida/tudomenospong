package org.academiadecodigo.group.ad.gfx.game;

import org.academiadecodigo.group.ad.gfx.enemies.Enemy;
import org.academiadecodigo.group.ad.gfx.enemies.EnemyFactory;
import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.grid.GridFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Game {

    private Grid grid;
    private List<Enemy> enemies;

    public Game(int cols, int rows) {
        this.enemies = new ArrayList<>();
        grid = GridFactory.makeGrid(cols, rows);
    }

    public void init(){
        grid.init();

        enemies.add(EnemyFactory.makeEnemy());

        for(Enemy enemy : enemies){
            enemy.setGrid(grid);
        }
    }

    public void start(){
        //Move
    }


    public void moveAllEnemies(){
        for (Enemy e: enemies) {
            e.move();
        }
    }


}
