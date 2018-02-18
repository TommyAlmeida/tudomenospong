package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.grid.*;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Enemy {

    private int life;
    private int speed;
    private boolean dead;
    private int value;

    private EnemyType enemyType;
    private Tile representation;

    public Enemy(EnemyType enemyType, int life, int speed, int value) {
        this.enemyType = enemyType;
        this.life = life;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.representation = TileFactory.make(0, GridUtils.rowToY(10), enemyType.getColor());
    }

    public Enemy(EnemyType enemyType, TiledGrid grid, int x, int y, int life,
                 int speed, int value) {
        this.enemyType = enemyType;
        this.life = life;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.representation = grid.getTile(x, y);
    }

    public void draw(){
        if(!dead){
            representation.setColor(Color.RED);
            representation.draw();
        }
    }

    public void move() {
        if(dead){
            return;
        }

        representation.moveRight(speed);
    }

    public Tile getRepresentation() {
        return representation;
    }

    public int getValue() {
        return value;
    }

}

