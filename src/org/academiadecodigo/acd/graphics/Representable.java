package org.academiadecodigo.acd.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * The class that implements representable
 * has the responsability to deal with the graphics
 */
public interface Representable {

    void render();
    void delete();
    Picture getSprite();
}
