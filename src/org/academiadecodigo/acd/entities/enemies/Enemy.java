package org.academiadecodigo.acd.entities.enemies;

import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy {

    private int currentHealth, maxHealth;
    private Rectangle healthBar;
    private Picture picture;
    private String name;
    private int moveSpeed;
    private int givenMoney;
    private Position currentPosition;

    public Enemy(String name, Picture picture, int maxHealth, int givenMoney, int moveSpeed){
        this.maxHealth = maxHealth;
        this.givenMoney = givenMoney;
        this.moveSpeed = moveSpeed;
        this.healthBar = new Rectangle(0, 2, getCurrentHealth(), 10);
        this.picture = picture;
        this.name = name;
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
        return givenMoney;
    }

    public void setMoney(int money) {
        this.givenMoney = money;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}
