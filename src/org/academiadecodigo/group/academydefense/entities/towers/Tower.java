package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.grid.Grid;
import org.academiadecodigo.group.academydefense.grid.GridColor;
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

    private GridPosition position;
    private Rectangle rangeRect;

    public Tower(Grid grid, int fireRate, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.position = grid.makeGridPosition(0, 0);
        this.rangeRect = new Rectangle(position.getCol(), position.getRow(), range, range);
        draw();
    }

    public void draw(){
        position.setColor(GridColor.GREEN);
        rangeRect.setColor(Color.BLUE);
        rangeRect.draw();
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
