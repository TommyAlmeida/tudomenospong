package org.academiadecodigo.group.ad.gfx.towers;

import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Tower {
    private Bullet bullet;
    private Rectangle range;
    private int fireRate;
    private Position position;
    private Grid grid;

    public Tower(int fireRate) {
        this.fireRate = fireRate;
        position = new Position(5,5, grid);

    }


    public void shoot(Bullet bullet){

    }


}
