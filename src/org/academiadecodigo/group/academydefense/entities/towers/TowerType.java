package org.academiadecodigo.group.academydefense.entities.towers;



/**
 * Created by codecadet on 19/02/2018.
 */
public enum TowerType {

    BRUNO(""),
    BRIGHENTI(""),
    RODOLFO("");

    private String path;

    TowerType(String path) {
        this.path = path;
    }

    public String getName() {
        return "res/bruno-tower.png";
    }
}
