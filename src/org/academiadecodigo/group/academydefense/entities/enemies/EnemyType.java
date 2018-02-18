package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public enum  EnemyType {

    DIOGO(""), BRUNO("bruno-tower.png");

    private String name;

    EnemyType(String name) {
        this.name = name;
    }

    public String loadResource() {
        return "/Users/codecadet/groupWork/tudomenospong/res/" + name;
    }
}

