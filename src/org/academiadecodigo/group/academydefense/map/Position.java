package org.academiadecodigo.group.academydefense.map;

import org.academiadecodigo.group.academydefense.grid.Grid;
import org.academiadecodigo.group.academydefense.grid.position.AbstractGridPosition;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Position extends AbstractGridPosition {

    private int x, y;
    private Grid grid;

    public Position(int x, int y, Grid grid){
        super(x, y, grid);
        this.x = x;
        this.y = y;
        this.grid = grid;
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

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
