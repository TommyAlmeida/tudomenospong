package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.enemies.DiogoEnemy;
import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.player.Player;
import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private TiledGrid grid;
    private Tower tower;


    private List<Enemy> enemies;

    public Game() {
        grid = new TiledGrid();
        enemies = new ArrayList<>();
        player = new Player(grid);
        enemies.add(new DiogoEnemy());
    }

    public void setPositions(Enemy enemy) {
        tower.setTowerToEnemyCol(enemy);
        tower.setTowerToEnemyRow(enemy);
        tower.towerToEnemy = (int) (Math.sqrt((tower.getTowerToEnemyCol() * tower.getTowerToEnemyCol()) + (tower.getTowerToEnemyRow() * tower.getTowerToEnemyRow())));
    }

    public void start() throws InterruptedException {
        grid.draw();
        drawEnemies();
        tower = new Tower(grid, 800, 448, 1, 1, 200);
        tower.draw(Color.BLUE);

        while (enemies.size() != -1) { //Move
            moveAllEnemies();
            Thread.sleep(20);
        }
    }

    public void moveAllEnemies() {
        for (Enemy e : enemies) {
            System.out.println(e);
            setPositions(e);
            System.out.println(e);
            e.move();
            System.out.println(e);
            if (tower.getTowerToEnemyDistance() < tower.getRange()) {
                tower.shoot(e, tower);
            }
        }
    }

    public void drawEnemies() throws InterruptedException {
        for (Enemy e : enemies) {
            e.draw();
        }
    }

}
