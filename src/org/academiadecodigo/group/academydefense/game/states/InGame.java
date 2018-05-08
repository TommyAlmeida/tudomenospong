package org.academiadecodigo.group.academydefense.game.states;

import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.entities.tower.Tower;
import org.academiadecodigo.group.academydefense.entities.tower.TowerFactory;
import org.academiadecodigo.group.academydefense.game.Game;
import org.academiadecodigo.group.academydefense.game.InputHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Every in-game logic goes here
 */
public class InGame {

    private List<Enemy> enemies;
    private List<Tower> towers;

    public InGame(){
        this.enemies = new LinkedList<>();
        this.towers = new ArrayList<>();
    }

    public void create(Game game){
        new InputHandler(this);

        Picture background = new Picture(10,10, "res/background.png");
        Picture pidgeon = new Picture(10,10, "res/foreground-pigeon.png");

        background.draw();
        pidgeon.draw();

        try {
            while (game.getGameState() != GameState.GAME_OVER) {
                updateEnemy();
                Thread.sleep(15);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw the enemy to the screen
     */
    private void updateEnemy(){
        Iterator<Enemy> iterator = enemies.iterator();

        while(iterator.hasNext()){
            Enemy currentEnemy = iterator.next();

            if(currentEnemy.isDead()){
                iterator.remove();
            }

            currentEnemy.draw();
            currentEnemy.move();
            makeTowersShoot(currentEnemy);
        }
    }

    private void makeTowersShoot(Enemy enemy){
        for(Tower t : towers){
            t.shoot(enemy);
        }
    }

    /**
     * Create a new tower
     * @param x tower x
     * @param y tower y
     */
    public void addTower(int x, int y) {
        towers.add(TowerFactory.make(x, y));
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
