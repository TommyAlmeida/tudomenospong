package org.academiadecodigo.group.academydefense.entities;

import java.util.ArrayList;
import java.util.List;

public class ObjectPool {

    private List<GameObject> gameObjects;

    public ObjectPool(){
        this.gameObjects = new ArrayList<>();
    }

    public void create(GameObject gameObject){
        if(gameObjects.contains(gameObject)){
            return;
        }

        gameObjects.add(gameObject);
    }

    public void dispose(){
        gameObjects.forEach(gameObject -> {
            if(gameObject == null){
                System.gc();
            }
        });
    }
}
