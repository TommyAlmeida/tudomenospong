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
    private Bullet bullet;


    public Tower(TiledGrid grid, int x, int y,
                 int fireRate, int range, int damage) {
        this.range = range;
        this.fireRate = fireRate;
        this.grid = grid;
        this.damage = damage;
        this.currentTile = (TileShape) grid.getTile(x, y);
    }

    public void draw(Color color){
        this.currentTile.setColor(color);
    }

    public void shoot(Enemy enemy){
        if (bullet != null) {
            //bullet.move(th);
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
