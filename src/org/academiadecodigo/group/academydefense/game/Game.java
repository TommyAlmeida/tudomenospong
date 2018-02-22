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

    private GameState gameState;
    private List<Enemy> enemies;

    public Game() {
        gameState = GameState.IN_GAME;
        enemies = new ArrayList<>();
    }

    /**
     * Draw everything into to the screen
     * and runs a game loop
     * Every frame is refreshed in 15ms
     */
    public void start(){
        switch (gameState){
            case MENU:
                break;
            case IN_GAME:
                inGame();
                break;
            case GAME_OVER:
                break;
        }
    }

    private void inGame(){
        TiledGrid grid = new TiledGrid();
        Player player = new Player(this, grid);

        Picture background = new Picture(10,10, "res/background.png");
        Picture pidgeon = new Picture(10,10, "res/foreground-pigeon.png");

        grid.draw();
        background.draw();

        try {
            drawEnemies();
            pidgeon.draw();

            while (gameState != GameState.GAME_OVER) { //Move
                moveAllEnemies();
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
    private void moveAllEnemies() {
        for (Enemy e : enemies) {
            e.move();
            makeTowersShoot(e);
        }
    }

    private void makeTowersShoot(Enemy enemy){
        for(Tower t : Player.getTowersCreated()){
            t.shoot(enemy, t);
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}

