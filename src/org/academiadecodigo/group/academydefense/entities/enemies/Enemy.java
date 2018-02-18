package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.grid.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Enemy {

    private int currentHealth, maxHealth;
    private int speed;
    private boolean dead;
    private int value;

    private EnemyType enemyType;
    private Text healthHud;
    private Tile representation;

    public Enemy(EnemyType enemyType, int maxHealth, int speed, int value) {
        this.enemyType = enemyType;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.representation = TileFactory.make(0, GridUtils.rowToY(10), enemyType.getColor());
        this.healthHud = new Text(representation.getX(),
                representation.getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);
    }

    public void draw(){
        representation.setColor(Color.RED);
        representation.draw();

        healthHud.setColor(Color.BLUE);
        healthHud.draw();
    }

    public void move() {
        if(dead){
            representation.hide();
            return;
        }

        representation.moveUp(speed);

        switch (representation.getCurrentDirection()){
            case UP:
                healthHud.translate(0, -speed);
                break;
            case DOWN:
                healthHud.translate(0, speed);
                break;
            case RIGHT:
                healthHud.translate(speed, 0);
                break;
            case LEFT:
                healthHud.translate(-speed, 0);
                break;
        }

    }

    public void recieveDamage(Bullet bullet){
        if(bullet.getDamage() >= currentHealth){
            currentHealth = 0;
        }

        if(currentHealth <= 0){
            dead = true;
        }

        currentHealth -= bullet.getDamage();
    }

    public boolean hasReachedTheEnd(){
        return this.getRepresentation().getY() == 10/2;
    }

    public Tile getRepresentation() {
        return representation;
    }

    public int getValue() {
        return value;
    }

}

