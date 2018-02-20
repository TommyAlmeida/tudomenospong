package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.entities.tower.Tower;
import org.academiadecodigo.group.academydefense.grid.tiles.TiledGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is where the game is created
 */
public class Game {

    private Player player;
    private TiledGrid grid;

    private List<Enemy> enemies;

    public Game() {
        grid = new TiledGrid();
        enemies = new ArrayList<>();
        player = new Player(this, grid);
    }

    /**
     * Draw everything into to the screen
     * and runs a game loop
     * Every frame is refreshed in 15ms
     */
    public void start(){
        Picture background = new Picture(10,10, "res/background.png");
        Picture pidgeon = new Picture(10,10, "res/foreground-pigeon.png");

        grid.draw();
        background.draw();

        try {
            drawEnemies();
            pidgeon.draw();
            while (enemies.size() != -1) { //Move
                updateEnemies();
                Thread.sleep(15);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw the enemy to the screen
     */
    private void drawEnemies(){
        for (Enemy e : enemies) {
            e.draw();
        }
    }

    /**
     * Move all the enemy
     * and make all the tower created to shoot at the enemy
     */
    private void updateEnemies() {
        for (Enemy e : enemies) {
            e.move();
            for(Tower t : Player.getTowersCreated()){
                t.shoot(e, t);
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}

