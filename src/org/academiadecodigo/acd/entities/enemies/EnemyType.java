package org.academiadecodigo.acd.entities.enemies;

import org.academiadecodigo.acd.GameConsts;

public enum  EnemyType {

    DIOGO("enemy.png");

    private String path;

    EnemyType(String path){
        this.path = path;
    }

    public String getImagePath() {
        return GameConsts.RESOURCES_PATH + path.trim();
    }
}
