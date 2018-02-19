package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.grid.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.group.academydefense.grid.path.Path;

public class Enemy {

    private int currentHealth, maxHealth;
    private int speed;
    private boolean dead;
    private int value;

    private EnemyType enemyType;
    private Text healthHud;
    private TilePictured sprite;
    //private Path path = new Path();

    //Constructor to check if it passes up the location of the enemy
    public Enemy(){

    }

    public Enemy(EnemyType enemyType, int maxHealth, int speed, int value) {
        this.enemyType = enemyType;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.sprite = new TilePictured(0, GridUtils.rowToY(10), "res/bruno-tower.png");
        this.healthHud = new Text(sprite.getPicture().getX(),sprite.getPicture().getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);
    }

    public void draw(){
        sprite.draw();

        healthHud.setColor(Color.BLUE);
        healthHud.draw();
    }

    public void move() {
        healthHud.translate(speed, 0);
        //getSprite().moveUp(speed);
        //path.changeDir();
        while (sprite.getY() != -1 && sprite.getX() != -1) {
            if (sprite.getX() == GridUtils.columnToX(5)) {
                getSprite().moveUp(speed);
                if (sprite.getY() == GridUtils.rowToY(5)) {
                    getSprite().moveRight(speed);
                    if (sprite.getX() == GridUtils.columnToX(10)) {
                        getSprite().moveDown(speed);
                    }
                } else if (sprite.getY() == GridUtils.rowToY(12)) {
                    getSprite().moveLeft(speed);
                } else {
                    getSprite().moveRight(speed);
                }
            }
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

    public int getSpeed() {
        return speed;
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

    @Override
    public String toString() {
        return "Enemy{" +
                "currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                ", speed=" + speed +
                ", dead=" + dead +
                ", value=" + value +
                ", enemyType=" + enemyType +
                ", healthHud=" + healthHud +
                ", sprite=" + sprite.getX() +
                ", sprite=" + sprite.getY() +
                '}';
    }
}

