package org.academiadecodigo.group.academydefense.entities.towers;


/**
 * Created on 19/02/2018.
 * Good Luck, Have Fun codecadet
 */
public enum TowerType {

    BRICENAS("brighenti-tower.png"), BRUNO("bruno-tower.png"), FERRAO("ferrao-tower.png"), RODOLFO("rodolfo-tower.png");

    private String name;

    TowerType(String name) {
        this.name = name;
    }

    public String loadResource() {
        return "res/" + name;

    }
}
