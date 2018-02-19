package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.grid.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Tower {


    private int fireRate, damage;
    private Rectangle rangeRect;
    private TileShape currentTile;
    private TiledGrid grid;
    private Bullet bullet;
    private TilePictured sprite;


    public Tower(TiledGrid grid, int x, int y, int fireRate, int damage) {
        this.fireRate = fireRate;
        this.grid = grid;
        this.damage = damage;
        this.currentTile = (TileShape) grid.getTile(x, y);
        this.sprite = sprite = new TilePictured(0, GridUtils.rowToY(10), "res/bruno-tower.png");

    }


    public void draw(Color color) {
        this.currentTile.setColor(color);
        sprite.draw();
    }

    public void shoot(Enemy enemy){
        if (bullet != null && getTowerToEnemyDistance() < 1000 ) {
            System.out.println("Bang Bang!!");
            bullet.move();

        }
    }

    public int getDamage() {
        return damage;
    }

    public int getCol() {
        return currentTile.getCol();
    }

    public int getRow() {
        return currentTile.getRow();
    }

    @Override
    public String toString() {
        return "Tower{" +
                "fireRate=" + fireRate +
                ", rangeRect=" + rangeRect +
                ", currentTile=" + currentTile +
                '}';
    }

    private int towerToEnemyRow;
    private int towerToEnemyCol;
    private int towerToEnemy;
    private int enemyPosX;
    private int enemyPosY;
    private int towerPosX;
    private int towerPosY;



    public int setTowerToEnemyRow(Enemy enemy) {

        enemyPosY = enemy.getSprite().getY(); //menos towerToEnemyRow
        System.out.println(enemyPosY);
        towerPosY = getRow();
        System.out.println(towerPosY);
        return towerToEnemyRow = Math.abs(enemyPosY - towerPosY);
    }

    public int setTowerRoEnemyCol(Enemy enemy) {

        enemyPosX= enemy.getSprite().getX(); //menos towerToEnemyRow
        System.out.println(enemyPosX);
        towerPosX = getCol();
        System.out.println(towerPosX);
        return towerToEnemyCol = Math.abs(enemyPosX - towerPosX);
    }

    public int getTowerToEnemyDistance() {
        return towerToEnemy;
    }

    public int getTowerToEnemyRow() {
        return towerToEnemyRow;
    }

    public int getTowerToEnemyCol() {
        return towerToEnemyCol;
    }

    public int setTowerToEnemy(int towerToEnemyRow, int towerToEnemyCol) {

        return (int) (Math.sqrt((towerToEnemyCol * towerToEnemyCol) + (towerToEnemyRow * towerToEnemyRow)));                                                                                                            // com catetos desses fico com ela hipotesuda
    }

}
