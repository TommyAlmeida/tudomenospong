package org.academiadecodigo.group.ad.gfx.game;

import org.academiadecodigo.group.ad.gfx.enemies.Enemy;
import org.academiadecodigo.group.ad.gfx.enemies.EnemyFactory;
import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.grid.GridFactory;
import org.academiadecodigo.group.ad.gfx.map.levels.FirstMap;
import org.academiadecodigo.group.ad.gfx.towers.Bullet;
import org.academiadecodigo.group.ad.gfx.towers.BulletFactory;
import org.academiadecodigo.group.ad.gfx.towers.BulletType;
import org.academiadecodigo.group.ad.gfx.towers.Tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Game {

    private Grid grid;

    private Tower tower;
    private List<Enemy> enemies;
    private FirstMap firstMap;

    public Game(int cols, int rows) {
        this.enemies = new ArrayList<>();
        grid = GridFactory.makeGrid(cols, rows);
    }

    public void init(){
        grid.init();

        tower = new Tower(grid,1, 120);

        firstMap = new FirstMap();

        enemies.add(EnemyFactory.makeEnemy(grid));

        Enemy enemyyes = EnemyFactory.makeEnemy(grid);

        for(Enemy enemy : enemies){
            enemy.setGrid(grid);
        }
    }

    public void start() throws InterruptedException {
        Bullet b = BulletFactory.make(BulletType.NORMAL);

        while(enemies.size() != -1){ //Move
            b.move();
            Thread.sleep(20);
            moveAllEnemies();
        }
        while(true) {
            moveAllEnemies();
        }
    }

    public void moveAllEnemies(){
        for (Enemy e: enemies) {
            System.out.println("zzzz");
            e.move();
        }
    }

}
