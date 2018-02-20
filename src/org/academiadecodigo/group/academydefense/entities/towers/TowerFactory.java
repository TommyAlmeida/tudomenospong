package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;

public class TowerFactory {

    public static TilePictured make(int x, int y){
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
}
