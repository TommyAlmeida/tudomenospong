package org.academiadecodigo.group.academydefense.gfx.representations;

import org.academiadecodigo.group.academydefense.gfx.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class NormalEnemyRepresentation implements Representable {

    private Rectangle rectangle;

    public NormalEnemyRepresentation(int x, int y, int width, int height){
        this.rectangle = new Rectangle(x, y, width, height);
    }

    @Override
    public void draw() {
        rectangle.setColor(Color.PINK);
        rectangle.draw();
    }

    @Override
    public Shape getShape() {
        return rectangle;
    }

    @Override
    public int getX() {
        return rectangle.getX();
    }

    @Override
    public int getY() {
        return rectangle.getY();
    }

    @Override
    public int getWidth() {
        return rectangle.getWidth();
    }

    @Override
    public int getHeight() {
        return rectangle.getHeight();
    }

}
