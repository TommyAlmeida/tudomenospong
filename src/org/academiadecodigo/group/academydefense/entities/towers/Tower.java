package org.academiadecodigo.group.academydefense.entities.towers;

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
    private int col, row;

    private TiledGridPosition position;
    private Rectangle rangeRect;

    public Tower(TiledGrid grid, int fireRate, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.position = new TiledGridPosition(0, 0, GridColor.BLUE, grid);
        draw();
    }

    public Tower(TiledGrid grid, int col, int row, int fireRate, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.position = new TiledGridPosition(col, row, GridColor.BLUE, grid);
        draw();
    }

    public void draw(){
        position.setColor(GridColor.GREEN);
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
                ", col=" + col +
                ", row=" + row +
                ", rangeRect=" + rangeRect +
                '}';
    }
}
