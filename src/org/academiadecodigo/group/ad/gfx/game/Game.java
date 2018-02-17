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
    private int delay;

    public Game(int cols, int rows, int delay) {
        this.enemies = new ArrayList<>();
        grid = GridFactory.makeGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {
        grid.init();


        enemies.add(EnemyFactory.makeEnemy(grid));


        for (Enemy enemy : enemies) {
            enemy = EnemyFactory.makeEnemy(grid);
            enemy.setGrid(grid);
        }
    }

    public void start() throws InterruptedException {

        while (true) {
            Thread.sleep(delay);

            moveAllEnemies();

        }
        //Move
    }


    public void moveAllEnemies() {
        for (Enemy e : enemies) {
            e.move();
        }
    }


}
