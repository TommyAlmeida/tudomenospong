package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public enum  EnemyType {

    DIOGO(Color.BLUE);

    private String path;
    private Color color;



    EnemyType(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }

    public String getPath() {
        return path;
    }
}

