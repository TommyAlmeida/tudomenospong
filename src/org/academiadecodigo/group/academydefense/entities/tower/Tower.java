package org.academiadecodigo.group.academydefense.entities.tower;

import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;

/**
 * Tower
 */
public class Tower {

    private int fireRate, range, damage;

    private TilePictured currentTile;

    //Tower
    private int towerToEnemyRow;
    private int towerToEnemyCol;
    private int towerPosX;
    private int towerPosY;

    //Enemy
    private int enemyPosX;
    private int enemyPosY;
    public int enemyDistance;


    public Tower(int x, int y, int fireRate, int damage, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.damage = damage;
        this.currentTile = TowerFactory.makeTilePictured(x, y);

        draw();
    }

    /**
     * Updates the tower to enemy row
     * @param enemy target
     */
    public void updateTowerToEnemyRow(Enemy enemy) {

        enemyPosY = enemy.getSprite().getY(); //menos towerToEnemyRow
        towerPosY = getRow();
        towerToEnemyRow = Math.abs(enemyPosY - towerPosY);
    }

    /**
     * Updates the tower to enemy col
     * @param enemy target
     */
    public void updateTowerToEnemyCol(Enemy enemy) {
        enemyPosX = enemy.getSprite().getX(); //menos towerToEnemyRow
        towerPosX = getCol();
        towerToEnemyCol = Math.abs(enemyPosX - towerPosX);
    }

    /**
     * Draw current tower
     */
    public void draw() {
        currentTile.draw();
    }

    /**
     * Get the enemy position and shoot
     *
     * @param enemy target
     */
    public void shoot(Enemy enemy) {
        updateTowerToEnemyCol(enemy);
        updateTowerToEnemyRow(enemy);

        enemyDistance = (int) (Math.sqrt((towerToEnemyCol * towerToEnemyCol) + (towerToEnemyRow * towerToEnemyRow)));

        if(getTowerToEnemyDistance() > range){
            return;
        }

        if (enemy.getCurrentHealth() <= 0) {
            enemy.die();
        }
        if (!enemy.isDead()) {
            enemy.receiveDamage(damage);
        }
    }

    /**
     * Get the enemy distance from the tower
     * @return enemy distance
     */
    public int getTowerToEnemyDistance() {
        return enemyDistance;
    }

    public int getTowerToEnemyRow() {
        return towerToEnemyRow;
    }

    public int getTowerToEnemyCol() {
        return towerToEnemyCol;
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
