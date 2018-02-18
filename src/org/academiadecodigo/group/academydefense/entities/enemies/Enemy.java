package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.grid.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {

    private int currentHealth, maxHealth;
    private int speed;
    private boolean dead;
    private int value;

    private EnemyType enemyType;
    private Text healthHud;
    private TilePictured sprite;

    public Enemy(EnemyType enemyType, int maxHealth, int speed, int value) {
        this.enemyType = enemyType;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.sprite = new TilePictured(0, GridUtils.rowToY(10), "/Users/codecadet/groupWork/tudomenospong/res/bruno-tower.png");
        this.healthHud = new Text(sprite.getPicture().getX(),
                sprite.getPicture().getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);
    }

    public void draw(){
        sprite.draw();

        healthHud.setColor(Color.BLUE);
        healthHud.draw();
    }

    public void move(){
        healthHud.translate(speed, 0);
        getSprite().moveRight(speed);
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
        return sprite.getPicture().getY() == 10/2;
    }

    public boolean isDead() {
        return dead;
    }

    public TilePictured getSprite() {
        return sprite;
    }

    public int getValue() {
        return value;
    }

}

