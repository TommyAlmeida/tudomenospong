package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private int damage, speed;
    private Rectangle representable;
    private Tower tower;

    public Bullet(int damage, int speed, Tower tower){
        this.damage = damage;
        this.speed = speed;
        this.representable = new Rectangle(tower.getCol()+4, tower.getRow()+4, 24, 24);
        representable.setColor(Color.RED);

        draw();
    }

    public void draw(){
        representable.fill();
    }

    public void move(){
        representable.translate(10, speed);
    }

    public int getSpeed() {
        return speed;
    }

    /*
        * Activated if collided
        */
    public void hit(Enemy target){
        target.recieveDamage(this);
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "damage=" + damage +
                ", speed=" + speed +
                ", x=" + representable.getX() +
                ", Y=" + representable.getY() +
                '}';
    }
}
