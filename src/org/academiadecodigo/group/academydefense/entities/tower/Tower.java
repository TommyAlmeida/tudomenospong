package org.academiadecodigo.group.academydefense.entities.tower;

import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;

/**
 * Tower
 */
public class Tower {

    private int fireRate, range, damage;
    private TilePictured currentTile;

    public Tower(int x, int y, int fireRate, int damage, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.damage = damage;
        this.currentTile = TowerFactory.makeTilePictured(x, y);

        draw();
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
        if(!isWithinRange(enemy)){
            return;
        }

        if (enemy.getCurrentHealth() <= 0) {
            enemy.die();
            return;
        }

        enemy.hit(damage);
    }

    /**
     * Check if enemy is within range
     *
     * @param enemy target
     * @return distance is greater than range
     */
    private boolean isWithinRange(Enemy enemy){
        int towerToEnemyRow = Math.abs(enemy.getSprite().getY() - getRow());
        int towerToEnemyCol = Math.abs(enemy.getSprite().getX() - getCol());

        double distance = Math.sqrt((towerToEnemyCol * towerToEnemyCol) + (towerToEnemyRow * towerToEnemyRow));
        return distance > range;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getRow() {
        return currentTile.getRow();
    }

    public int getCol() {
        return currentTile.getCol();
    }

}
