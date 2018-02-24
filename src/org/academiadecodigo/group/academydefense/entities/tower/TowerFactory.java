package org.academiadecodigo.group.academydefense.entities.tower;

import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;

public class TowerFactory {

    public static TilePictured makeTilePictured(int x, int y){
        int size = TowerType.values().length;
        TowerType type = TowerType.values()[(int) (Math.random() * size)];

        switch (type){
            case BRUNO:
                return new TilePictured(x, y, type.loadResource());

            case BRICENAS:
                return new TilePictured(x, y, type.loadResource());

            case FERRAO:
                return new TilePictured(x, y, type.loadResource());

            case RODOLFO:
                return new TilePictured(x, y, type.loadResource());
        }

        return null;
    }

    public static Tower make(int x, int y){
        return new Tower(x, y, 1, 1, 100);
    }
}
