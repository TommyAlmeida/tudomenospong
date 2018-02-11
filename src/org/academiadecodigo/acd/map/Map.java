package org.academiadecodigo.acd.map;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Map {

    private Path path;
    private Picture picture;
    private Grid grid;

    public Map(Path path, Picture picture) {
        this.path = path;
        this.picture = picture;
        this.grid = new Grid(30, 30);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Picture getPicture() {
        return picture;
    }


    public void setPicture(Picture picture) {
        this.picture = picture;
    }

}
