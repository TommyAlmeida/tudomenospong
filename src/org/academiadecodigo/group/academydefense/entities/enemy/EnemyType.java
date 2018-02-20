package org.academiadecodigo.group.academydefense.entities.enemy;


/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public enum  EnemyType {

    DIOGO("");

    private String name;

    EnemyType(String name) {
        this.name = name;
    }

    public String loadResource() {
        return "/Users/codecadet/Desktop/Groups/G_RDT/tudomenospong/res" + name;
    }
}

