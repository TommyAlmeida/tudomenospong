package org.academiadecodigo.group.ad.gfx.towers;

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

    public Tower(int fireRate) {
        this.fireRate = fireRate;
        position = new Position(5,5);

    }


    public void shoot(Bullet bullet){

    }


}
