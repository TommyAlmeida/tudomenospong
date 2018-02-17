package org.academiadecodigo.group.ad.gfx.map;

import org.academiadecodigo.group.ad.gfx.grid.Grid;

/**
 * Created on 17/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Waypoint {
    private Position position;
    private Grid grid;

    private int x;
    private int y;

    public Waypoint(int x, int y){
        this.position = new Position(x, y, grid);

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
