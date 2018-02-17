package org.academiadecodigo.group.ad.gfx.towers;

import org.academiadecodigo.group.ad.gfx.enemies.Enemy;
import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.grid.GridColor;
import org.academiadecodigo.group.ad.gfx.grid.position.GridPosition;
import org.academiadecodigo.group.ad.gfx.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Tower {


    private int fireRate, range;
    private GridPosition position;

    private Rectangle rangeRect;

    public Tower(Grid grid, int fireRate, int range) {
        this.range = range;
        this.fireRate = fireRate;
        this.position = grid.makeGridPosition(0, 0);
        this.rangeRect = new Rectangle(position.getCol(), position.getRow(), range, range);

        draw();
    }

    private void draw(){
        position.setColor(GridColor.GREEN);
        rangeRect.setColor(Color.BLUE);
        rangeRect.draw();
    }

    public void shoot(){
        Bullet b = BulletFactory.make(BulletType.NORMAL);

        if (b != null) {
            b.move();
        }
    }

}
