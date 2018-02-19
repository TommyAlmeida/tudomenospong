package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.grid.Tile;
import org.academiadecodigo.group.academydefense.grid.TileShape;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Tower {


    private int fireRate, range, damage;
    private Rectangle rangeRect;

    private TileShape currentTile;
    private TiledGrid grid;
    private BulletFactory bulletFactory;
    private Bullet bullet;


    public Tower(TiledGrid grid, int x, int y,
                 int fireRate, int damage) {
        //this.range = range;
        this.fireRate = fireRate;
        this.grid = grid;
        this.damage = damage;
        this.currentTile = (TileShape) grid.getTile(x, y);


    }


    private int towerToEnemyRow;
    private int towerToEnemyCol;
    public int towerToEnemy;
    private int enemyPosX;
    private int enemyPosY;
    private int towerPosX;
    private int towerPosY;



    public int setTowerToEnemyRow(Enemy enemy) {

        enemyPosY = enemy.getSprite().getY(); //menos towerToEnemyRow
        System.out.println(enemyPosY + "olololol");
        towerPosY = getRow();
        System.out.println(towerPosY);
        return towerToEnemyRow = Math.abs(enemyPosY - towerPosY);
    }

    public int setTowerToEnemyCol(Enemy enemy) {

        enemyPosX = enemy.getSprite().getX(); //menos towerToEnemyRow
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

   /* public int setTowerToEnemy(int towerToEnemyRow, int towerToEnemyCol) {

        return (int) (Math.sqrt((this.towerToEnemyCol * this.towerToEnemyCol) + (this.towerToEnemyRow * this.towerToEnemyRow)));                                                                                                            // com catetos desses fico com ela hipotesuda
    }*/

    public void draw(Color color) {
        this.currentTile.setColor(color);
    }

    public void shoot(Enemy enemy) {

        setTowerToEnemyCol(enemy);
        setTowerToEnemyRow(enemy);
        towerToEnemy = (int) (Math.sqrt((towerToEnemyCol * towerToEnemyCol) + (towerToEnemyRow * towerToEnemyRow)));
        //setTowerToEnemy(getTowerToEnemyRow(), getTowerToEnemyCol());
        System.out.println("damage: " + damage);
        System.out.println("tower to enemy dist: " + getTowerToEnemyDistance() + "---" + (int) (Math.sqrt((towerToEnemyCol * towerToEnemyCol) + (towerToEnemyRow * towerToEnemyRow))));
        System.out.println("tower x: " + towerPosX);
        System.out.println("enemy x: " + enemyPosX);
        System.out.println("tower to enemy X: " + getTowerToEnemyCol());
        System.out.println("tower y: " + towerPosY);
        System.out.println("enemy y: " + enemyPosY);
        System.out.println("tower to enemy y: " + getTowerToEnemyRow());

        if (getTowerToEnemyDistance() < 200) {
            if (enemy.getCurrentHealth() <= 0) {
                enemy.setDead(true);
            }
            if (!enemy.isDead()) {
                bullet = new Bullet(1, 1);
                System.out.println("Bang Bang!!");
                bullet.draw();
                bullet.move();
                enemy.recieveDamage(bullet);
            }

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
                ", range=" + range +
                ", rangeRect=" + rangeRect +
                ", currentTile=" + currentTile +
                '}';
    }

}
