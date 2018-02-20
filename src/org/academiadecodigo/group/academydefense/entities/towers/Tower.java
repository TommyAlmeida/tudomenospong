package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;
import org.academiadecodigo.group.academydefense.grid.tiles.TiledGrid;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Tower {


    private int fireRate, range, damage;

    private TiledGrid grid;
    private Bullet bullet;
    private TilePictured currentTile;

    private int towerToEnemyRow;
    private int towerToEnemyCol;
    public int towerToEnemy;
    private int enemyPosX;
    private int enemyPosY;
    private int towerPosX;
    private int towerPosY;


    public Tower(TiledGrid grid, int x, int y, int fireRate, int damage, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.grid = grid;
        this.damage = damage;
        this.currentTile = TowerFactory.make(x, y);
    }

    public int setTowerToEnemyRow(Enemy enemy) {

        enemyPosY = enemy.getSprite().getY(); //menos towerToEnemyRow
        towerPosY = getRow();
        return towerToEnemyRow = Math.abs(enemyPosY - towerPosY);
    }


    public int setTowerToEnemyCol(Enemy enemy) {
        enemyPosX = enemy.getSprite().getX(); //menos towerToEnemyRow
        towerPosX = getCol();
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

    public void draw() {
        currentTile.draw();
    }

    public void shoot(Enemy enemy, Tower tower) {
        setTowerToEnemyCol(enemy);
        setTowerToEnemyRow(enemy);

        towerToEnemy = (int) (Math.sqrt((towerToEnemyCol * towerToEnemyCol) + (towerToEnemyRow * towerToEnemyRow)));

        if (getTowerToEnemyDistance() < range) {
            if (enemy.getCurrentHealth() <= 0) {
                enemy.dead();
            }
            if (!enemy.isDead()) {
                bullet = new Bullet(1, 1, tower);
                //System.out.println("Bang Bang!!");
                enemy.receiveDamage(bullet);
            }

        }
    }

    public int getDamage() {
        return damage;
    }

    public int getCol() {
        return currentTile.getCol();
    }

    public int getRange() {
        return range;
    }

    public int getRow() {
        return currentTile.getRow();
    }



}
