package org.academiadecodigo.acd.entities;

public interface Entity {

    int getX();
    int getY();

    void render();
    void update();
    void dispose();
}
