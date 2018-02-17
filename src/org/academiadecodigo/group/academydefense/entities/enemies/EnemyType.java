package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.grid.GridColor;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public enum  EnemyType {

    DIOGO(GridColor.BLUE);

    private String path;
    private GridColor color;



    EnemyType(GridColor color) {
        this.color = color;
    }


    public GridColor getColor() {
        return color;
    }

    public String getPath() {
        return path;
    }
}

