package org.academiadecodigo.group.academydefense.gfx;

import org.academiadecodigo.simplegraphics.graphics.Shape;

public interface Representable {

    void draw();

    Shape getShape();
    int getX();
    int getY();
    int getWidth();
    int getHeight();

}
