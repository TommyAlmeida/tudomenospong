package org.academiadecodigo.group.academydefense.game.states;

import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.entities.tower.Tower;
import org.academiadecodigo.group.academydefense.game.Game;
import org.academiadecodigo.group.academydefense.game.Player;
import org.academiadecodigo.group.academydefense.grid.tiles.TiledGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * Every in-game logic goes here
 */
public class InGame {

    private Player player;
    private List<Enemy> enemies;

    public InGame(){
        this.enemies = new ArrayList<>();
    }


    public void create(Game game){
        TiledGrid grid = new TiledGrid();
        player = new Player(grid, this);

        Picture background = new Picture(10,10, "res/background.png");
        Picture pidgeon = new Picture(10,10, "res/foreground-pigeon.png");

        grid.draw();
        background.draw();

        try {
            drawEnemies();
            pidgeon.draw();

            while (game.getGameState() != GameState.GAME_OVER) {
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

    /**
     * Update range towers
     * @param tower tower placed
     * @param enemy target
     */
    public void updateRange(Tower tower, Enemy enemy) {
        tower.updateTowerToEnemyCol(enemy);
        tower.updateTowerToEnemyRow(enemy);
        tower.enemyDistance = (int) (Math.sqrt((tower.getTowerToEnemyCol() * tower.getTowerToEnemyCol()) + (tower.getTowerToEnemyRow() * tower.getTowerToEnemyRow())));
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
