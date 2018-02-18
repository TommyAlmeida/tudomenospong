package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.gfx.Tile;
import org.academiadecodigo.group.academydefense.grid.Grid;
import org.academiadecodigo.group.academydefense.grid.GridColor;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;
import org.academiadecodigo.group.academydefense.grid.TiledGridPosition;
import org.academiadecodigo.group.academydefense.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Tower {


    private int fireRate, range;
    private Rectangle rangeRect;
    private Tile currentTile;


    public Tower(TiledGrid grid, int x, int y,
                 int fireRate, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.currentTile = grid.getTile(x, y);
    }

    public void draw(Color color){
        this.currentTile.setColor(color);
    }

    public void shoot(Bullet bullet){
        if (bullet != null) {
            bullet.move();
        }
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
