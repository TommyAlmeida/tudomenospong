package org.academiadecodigo.group.academydefense.grid.tiles;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * A tile with a form of a shape
 */
public class TileShape extends Tile {

    private Color color;
    private Rectangle rectangle;

    public TileShape(int col, int row, int cellSize, Color color) {
        super(col, row, cellSize);
        this.color = color;
        this.rectangle = new Rectangle(col, row, cellSize, cellSize);
        setMovable(rectangle);
    }


    @Override
    public void draw() {
        rectangle.setColor(color);
        rectangle.draw();
    }

}
