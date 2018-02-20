package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.Sound;
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

    public Enemy(){

    }

    public Enemy(EnemyType enemyType, int maxHealth, int speed, int value) {
        this.enemyType = enemyType;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.dead = false;
        this.value = value;

        this.sprite = new TilePictured(0, GridUtils.rowToY(10), "res/monicawtf.png");


        this.healthHud = new Text(sprite.getPicture().getX(),sprite.getPicture().getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);

        draw();
    }


    public void setHealthHud(Text healthHud) {
        this.healthHud = healthHud;
    }

    public void draw() {
        sprite.draw();

        healthHud.setColor(Color.BLUE);
        healthHud.draw();
    }

    public void move(){

        if(hasReachedTheEnd()){
            setDead(true);

        }

        if(isDead()){
            sprite.hide();
            healthHud.delete();
        }else{
            healthHud.delete();
            healthHud = new Text(sprite.getPicture().getX(), sprite.getPicture().getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);
            healthHud.setColor(Color.BLUE);
            healthHud.draw();
            healthHud.translate(speed, 0);
            getSprite().moveRight(speed);
        }
    }

    public void receiveDamage(Bullet bullet){
        if(bullet.getDamage() >= currentHealth){
            currentHealth = 0;
        }

        if(currentHealth <= 0){
            dead = true;
        }

        currentHealth -= bullet.getDamage();
    }

    public boolean hasReachedTheEnd(){
        return sprite.getPicture().getX() == 1500;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public TilePictured getSprite() {
        return sprite;
    }

    public int getValue() {
        return value;
    }


}

