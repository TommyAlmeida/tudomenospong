package org.academiadecodigo.acd.entities.enemies;

import org.academiadecodigo.acd.entities.Entity;
import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy implements Entity{

    private int currentHealth, maxHealth;
    private int speed;
    private int value; //how much is this enemy worth in €€€?
    private boolean dead;

    private int x, y;
    private Position pos;

    private Rectangle healthBar;
    private Picture sprite;

    private EnemyType enemyType;

    public Enemy(EnemyType enemyType, int x, int y, int maxHealth, int moneyValue, int speed){
        this.x = x;
        this.y = y;

        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.value = moneyValue;
        this.speed = speed;
        this.enemyType = enemyType;

        dead = false;
        pos = new Position(x, y);
        sprite = new Picture(x,y,
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
        healthBar.translate(speed,0);
        sprite.translate(speed, 0);
    }

    /**
     * Draw the health bar
     */
    private void drawHpBar(){
        healthBar = new Rectangle(Math.floor(getX() / 3),
                getY() - 5,
                currentHealth, 10);

        healthBar.setColor(Color.RED);
        healthBar.fill();
    }

    public void takeHit(Player player, int damage) {
        currentHealth -= damage; //tower.getDamage();

        if(currentHealth < 0){
            dead = true;
            player.addMoney(this);
        }
    }

    @Override
    public void dispose(){
        sprite.delete();
        healthBar.delete();
    }

    public boolean isDead(){
        return dead;
    }

    public int getX(){
        return pos.getX();
    }

    public int getY(){
        return pos.getY();
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
