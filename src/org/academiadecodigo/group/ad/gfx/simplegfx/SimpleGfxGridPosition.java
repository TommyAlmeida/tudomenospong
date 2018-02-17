package org.academiadecodigo.group.ad.gfx.simplegfx;


import org.academiadecodigo.group.ad.gfx.grid.GridColor;
import org.academiadecodigo.group.ad.gfx.grid.GridDirection;
import org.academiadecodigo.group.ad.gfx.grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid) {

        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.simpleGfxGrid = grid;

        rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
        show();

    }

    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {

        super(col, row, grid);
        this.simpleGfxGrid = grid;

        rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
        show();
    }


    @Override
    public void show() {
        rectangle.fill();
    }


    @Override
    public void hide() {
        rectangle.delete();
    }


    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        int lastCol = getCol();
        int lastRow = getRow();

        super.moveInDirection(direction, distance);
        rectangle.translate((getCol() - lastCol) * simpleGfxGrid.getCellSize(), (getRow() - lastRow) * simpleGfxGrid.getCellSize());
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
    }
}
