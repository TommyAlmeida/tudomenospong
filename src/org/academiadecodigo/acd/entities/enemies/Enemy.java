package org.academiadecodigo.acd.entities.enemies;

import org.academiadecodigo.acd.GameConsts;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy {

    private String name;

    private int currentHealth, maxHealth;
    private int speed;
    private int givenMoney;

    private Rectangle healthBar;
    private Picture sprite;

    public Enemy(String name, String imagePath, int maxHealth,
                 int givenMoney, int speed){
        this.name = name;
        this.maxHealth = maxHealth;
        this.givenMoney = givenMoney;
        this.speed = speed;
        this.sprite = new Picture(0,0,
                GameConsts.RESOURCES_PATH + imagePath.trim());
    }

    public void init(){
        healthBar = new Rectangle(Math.floor(sprite.getX() / 3),
                sprite.getY() - 10,
                maxHealth - currentHealth, 10);

        sprite.draw();
        healthBar.setColor(Color.RED);
        healthBar.fill();
    }

    public void move(){
        System.out.println(isOutOfBounds());

        if(isOutOfBounds()) return;

        healthBar.translate(speed,0);
        sprite.translate(speed, 0);
    }


    public boolean isDead(){
        return currentHealth <= 0;
    }

    public boolean isOutOfBounds(){
        return getX() > GameConsts.WINDOW_WIDTH;
    }

    public int getX(){
        return sprite.getX();
    }

    public int getY(){
        return sprite.getX();
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                ", speed=" + speed +
                ", givenMoney=" + givenMoney +
                '}';
    }
}
