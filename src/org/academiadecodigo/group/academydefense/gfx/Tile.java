package org.academiadecodigo.group.academydefense.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tile {

    private int col;
    private int row;
    private int cellSize;

    protected Color color;
    private Rectangle rectangle;

    public Tile(int col, int row, int cellSize, Color color) {
        this.col = col;
        this.row = row;
        this.color = color;
        this.cellSize = cellSize;
        this.rectangle = new Rectangle(col, row, cellSize, cellSize);
    }

    public void draw() {
        rectangle.setColor(color);
        rectangle.draw();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        rectangle.setColor(this.color);
    }

    public int getCellSize() {
        return cellSize;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "col=" + col +
                ", row=" + row +
                ", color=" + color +
                ", rectangle=" + rectangle +
                '}';
    }
}
