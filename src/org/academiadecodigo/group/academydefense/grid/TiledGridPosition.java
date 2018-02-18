package org.academiadecodigo.group.academydefense.grid;


import org.academiadecodigo.group.academydefense.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class TiledGridPosition implements GridPosition {

    private int col;
    private int row;

    private Rectangle rectangle;
    private TiledGrid grid;
    private GridColor color;

    public TiledGridPosition(int col, int row, GridColor color, TiledGrid grid) {
        this.col = col;
        this.row = row;
        this.color = color;
        this.grid = grid;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    @Override
    public GridColor getColor() {
        return color;
    }

    @Override
    public void setColor(GridColor color) {
        this.color = color;
        show();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    public TiledGrid getGrid() {
        return grid;
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        switch (direction) {
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

    }

    /**
     * Moves the position up
     *
     * @param dist the number of positions to move
     */
    public void moveUp(int dist) {

        int maxRowsUp = dist < getRow() ? dist : getRow();
        setPos(getCol(), getRow() - maxRowsUp);

    }

    /**
     * Moves the position down
     *
     * @param dist the number of positions to move
     */
    public void moveDown(int dist) {

        int maxRowsDown = dist > getGrid().getWidth() - (getRow() + 1) ? getGrid().getHeight() - (getRow() + 1) : dist;
        setPos(getCol(), getRow() + maxRowsDown);

    }

    /**
     * Moves the position left
     *
     * @param dist the number of positions to move
     */
    public void moveLeft(int dist) {

        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());

    }

    /**
     * Moves the position right
     *
     * @param dist the number of positions to move
     */
    public void moveRight(int dist) {
        int maxRowsRight = dist > getGrid().getWidth() - (getCol() + 1) ? getGrid().getHeight() - (getCol() + 1) : dist;
        setPos(getCol() + maxRowsRight, getRow());
    }

    @Override
    public boolean equals(GridPosition position) {
        return false;
    }
}
