package org.academiadecodigo.group.academydefense.entities.enemy;


import org.academiadecodigo.group.academydefense.entities.Bullet;
import org.academiadecodigo.group.academydefense.grid.*;
import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Enemy {

    private int currentHealth;
    private int maxHealth;
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

        this.sprite = new TilePictured(0, GridUtils.rowToY(10), "res/monicawtf.png");
        this.healthHud = new Text(sprite.getPicture().getX(),sprite.getPicture().getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);

        draw();
    }

    /**
     * Draw our enemy to the screen
     */
    public void draw() {
        sprite.draw();

        healthHud.setColor(Color.BLUE);
        healthHud.draw();
    }

    /**
     * Make our enemy move if not dead
     * and if it is or if it has reached the end
     * the enemy will be deleted from the screen
     */
    public void move(){

        if(hasReachedTheEnd()){
            dead();
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

    /**
     * Receive damage if hitted by a bullet
     * @param bullet bullet
     */
    public void receiveDamage(Bullet bullet){
        if(bullet.getDamage() >= currentHealth){
            currentHealth = 0;
        }

        if(currentHealth <= 0){
            dead = true;
        }

        currentHealth -= bullet.getDamage();
    }

    /**
     * Vertical bound
     * @return
     */
    public boolean hasReachedTheEnd(){
        return sprite.getPicture().getX() == 1500;
    }

    public void dead() {
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public TilePictured getSprite() {
        return sprite;
    }

    public int getValue() {
        return value;
    }
}

