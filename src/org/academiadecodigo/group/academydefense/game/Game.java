package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.player.Player;
import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.entities.towers.BulletFactory;
import org.academiadecodigo.group.academydefense.entities.towers.BulletType;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.enemies.EnemyFactory;
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
    private Player player;
    private List<Enemy> enemies;

    public Game(int cols, int rows) {
        this.enemies = new ArrayList<>();
        grid = GridFactory.makeGrid(cols, rows);
    }

    public void init(){
        grid.init();
        player = new Player(grid);
    }

    public void start() throws InterruptedException {
        Bullet b = BulletFactory.make(BulletType.NORMAL);

        while(enemies.size() != -1){ //Move
            b.move();
            Thread.sleep(20);
        }
    }

    public void moveAllEnemies(){
        for (Enemy e: enemies) {
            e.move();
        }
    }

}
