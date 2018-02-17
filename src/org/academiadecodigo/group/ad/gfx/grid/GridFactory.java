package org.academiadecodigo.group.ad.gfx.grid;


import org.academiadecodigo.group.ad.gfx.simplegfx.SimpleGfxGrid;

/**
 * A factory of different types of grids
 */
public class GridFactory {

    /**
     * Creates a new grid
     *
     * @param cols     the number of columns of the grid
     * @param rows     the number of rows of the grid
     * @return the new grid
     */
    public static Grid makeGrid(int cols, int rows) {
        return new SimpleGfxGrid(cols,rows);
    }

}