package org.academiadecodigo.acd.graphics.representations;

import org.academiadecodigo.acd.game.GameConsts;
import org.academiadecodigo.acd.graphics.Representable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 13/02/2018.
 */
public class BrunoTowerRepresentation implements Representable {

    private Picture picture;

    public BrunoTowerRepresentation() {
        this.picture = new Picture(0, 0,
                GameConsts.RESOURCES_PATH + "bruno.png");
    }

    @Override
    public void render() {
        picture.draw();
    }

    @Override
    public void delete() {
        picture.delete();
    }

    @Override
    public Picture getSprite() {
        return picture;
    }


}
