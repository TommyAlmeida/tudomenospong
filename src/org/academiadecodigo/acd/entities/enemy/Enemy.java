package org.academiadecodigo.acd.entities.enemy;

import org.academiadecodigo.acd.entities.Entity;
import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy implements Entity{

    private int currentHealth, maxHealth;
    private int speed;
    private int value; //how much is this enemy worth in €€€
    private boolean dead;

    private Position startPosition;

    private Text healthHUD;
    private Picture sprite;

    private EnemyType enemyType;

    public Enemy(EnemyType enemyType, int maxHealth, int moneyValue, int speed){
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.value = moneyValue;
        this.speed = speed;
        this.enemyType = enemyType;

        startPosition = new Position(0, 0);
        dead = false;
        sprite = new Picture(startPosition.getX(),startPosition.getY(),
                enemyType.getImagePath());
    }

    /**
     * Init representations
     */
    @Override
    public void render(){
        drawHpBar();
        sprite.draw();
    }

    /**
     * Everything it needs to be on the main game loop
     */
    @Override
    public void update(){
        if(isDead()){
            dispose();
            return;
        }

        move();
    }

    /**
     * Make the enemy move and the healthbar follows
     */
    public void move(){
        healthHUD.translate(speed, 0);
        sprite.translate(speed, speed);
    }

    /**
     * Draw the health bar
     */
    private void drawHpBar(){
        healthHUD = new Text(sprite.getX(), sprite.getY() - 5, String.valueOf(currentHealth));
        healthHUD.setColor(Color.RED);
        healthHUD.draw();
    }

    public void takeHit(Player player, int damage) {
        currentHealth -= damage; //tower.getDamage();
        healthHUD.setText(String.valueOf(currentHealth));

        if(currentHealth <= 0){
            dead = true;
            player.addMoney(this);
        }
    }

    @Override
    public void dispose(){
        sprite.delete();
        healthHUD.delete();
    }

    public boolean isDead(){
        return dead;
    }

    public void setSprite(Picture sprite) {
        this.sprite = sprite;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                " currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                ", speed=" + speed +
                ", value=" + value +
                '}';
    }
}
