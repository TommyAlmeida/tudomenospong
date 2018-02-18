package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.player.Player;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private TiledGrid grid;

    private List<Enemy> enemies;

    public Game() {
        grid = new TiledGrid();
        enemies = new ArrayList<>();
        player = new Player(grid);
    }

    public void start() throws InterruptedException {
        grid.draw();

        while(enemies.size() != -1){ //Move
            Thread.sleep(20);
        }
    }

    public void moveAllEnemies(){
        for (Enemy e: enemies) {
            e.move();
        }
    }

}
