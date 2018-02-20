package org.academiadecodigo.group.academydefense.grid.tiles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A tile with a form of a picture
 */
public class TilePictured extends Tile{

    private Picture picture;

    public TilePictured(int col, int row, String path) {
        super(col, row, 64);
        this.picture = new Picture(col, row, path);
        setMovable(picture);
    }

    public void hide(){
        picture.delete();
    }

    public int getX(){
        return picture.getX();
    }

    public int getY(){
        return picture.getY();
    }

    public Picture getPicture() {
        return picture;
    }

    @Override
    public void draw() {
        picture.draw();
    }
}
