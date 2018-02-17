package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.towers.Bullet;
import org.academiadecodigo.group.academydefense.towers.BulletFactory;
import org.academiadecodigo.group.academydefense.towers.BulletType;
import org.academiadecodigo.group.academydefense.towers.Tower;
import org.academiadecodigo.group.academydefense.enemies.Enemy;
import org.academiadecodigo.group.academydefense.enemies.EnemyFactory;
import org.academiadecodigo.group.academydefense.grid.Grid;
import org.academiadecodigo.group.academydefense.grid.GridFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
@SuppressWarnings("ALL")
public class Game {

    private Grid grid;

    private Tower tower;
    private List<Enemy> enemies;

    public Game(int cols, int rows) {
        this.enemies = new ArrayList<>();
        grid = GridFactory.makeGrid(cols, rows);
    }

    public void init(){
        grid.init();

        tower = new Tower(grid,1, 120);

        enemies.add(EnemyFactory.makeEnemy());

        for(Enemy enemy : enemies){
            enemy.setGrid(grid);
        }
    }

    public void start() throws InterruptedException {
        Bullet b = BulletFactory.make(BulletType.NORMAL);

        while(enemies.size() != -1){ //Move
            b.move();
            Thread.sleep(200);
        }
    }

    public void moveAllEnemies(){
        for (Enemy e: enemies) {
            e.move();
        }
    }

}
