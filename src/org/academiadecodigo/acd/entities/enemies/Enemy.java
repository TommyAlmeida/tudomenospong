package org.academiadecodigo.acd.entities.enemies;

import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy {

    private int currentHealth, maxHealth;
    private Rectangle healthBar;
    private Picture picture;

    private int moveSpeed;
    private int money;

    private Position currentPosition;

    public Enemy(Picture picture, int maxHealth, int money, int moveSpeed, Rectangle healthBar){
        this.maxHealth = maxHealth;
        this.money = money;
        this.moveSpeed = moveSpeed;
        this.healthBar = healthBar;
        this.picture = picture;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Rectangle getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(Rectangle healthBar) {
        this.healthBar = healthBar;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}
