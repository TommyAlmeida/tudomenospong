package org.academiadecodigo.group.academydefense.entities.tower;

import org.academiadecodigo.group.academydefense.entities.Bullet;
import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;
import org.academiadecodigo.group.academydefense.grid.tiles.TiledGrid;

/**
 * Tower
 */
public class Tower {


    private int fireRate, range, damage;

    private TiledGrid grid;
    private TilePictured currentTile;
    private Bullet bullet;

    //Tower
    private int towerToEnemyRow;
    private int towerToEnemyCol;
    private int towerPosX;
    private int towerPosY;

    //Enemy
    private int enemyPosX;
    private int enemyPosY;
    public int enemyDistance;


    public Tower(TiledGrid grid, int x, int y, int fireRate, int damage, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.grid = grid;
        this.damage = damage;
        this.currentTile = TowerFactory.make(grid, x, y);
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
     * @param tower tower placed
     */
    public void shoot(Enemy enemy, Tower tower) {
        updateTowerToEnemyCol(enemy);
        updateTowerToEnemyRow(enemy);

        enemyDistance = (int) (Math.sqrt((towerToEnemyCol * towerToEnemyCol) + (towerToEnemyRow * towerToEnemyRow)));

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
