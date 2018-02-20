package org.academiadecodigo.group.academydefense.entities;

import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.entities.tower.Tower;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Bullet Class
 */
public class Bullet {

    private int damage, speed;
    private Rectangle representable;
    private Tower tower;

    public Bullet(int damage, int speed, Tower tower) {
        this.damage = damage;
        this.speed = speed;
        this.representable = new Rectangle(tower.getCol() + 4, tower.getRow() + 4, 14, 14);
        representable.setColor(Color.RED);

    }

    /*
     * Hit a target and then the target receives damage
     */
    public void hit(Enemy target) {
        target.receiveDamage(this);
    }

    /**
     * Draw the bullet to the screen
     */
    public void draw() {
        representable.fill();
    }

    /**
     * Make the bullet movable
     */
    public void move() {
        representable.translate(10, speed);
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }


}
