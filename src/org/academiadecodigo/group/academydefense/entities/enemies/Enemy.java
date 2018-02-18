package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.gfx.Tile;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;

public class Enemy {

    private int life;
    private int speed;
    private boolean dead;
    private int value;

    private EnemyType enemyType;
    private Tile representation;

    public Enemy(EnemyType enemyType, TiledGrid grid, int life, int speed, int value) {
        this.enemyType = enemyType;
        this.life = life;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.representation = grid.getTile(0, 0);
        draw();
    }

    public Enemy(EnemyType enemyType, TiledGrid grid, int x, int y, int life, int speed, int value) {
        this.enemyType = enemyType;
        this.life = life;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.representation = grid.getTile(x, y);
        draw();
    }

    private void draw(){
        representation.setColor(enemyType.getColor());
        representation.draw();
    }

    public void move() {

    }

    public Tile getRepresentation() {
        return representation;
    }

    public int getValue() {
        return value;
    }

}

