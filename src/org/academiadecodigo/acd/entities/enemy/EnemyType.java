package org.academiadecodigo.acd.entities.enemy;

import org.academiadecodigo.acd.game.GameConsts;

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
