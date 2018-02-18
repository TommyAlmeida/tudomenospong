package org.academiadecodigo.group.academydefense.entities.towers;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private int damage, speed;
    private Rectangle representable;

    public Bullet(int damage, int speed){
        this.damage = damage;
        this.speed = speed;
        this.representable = new Rectangle(12, 12, 16, 16);
        representable.setColor(Color.WHITE);
        draw();
    }

    public void draw(){
        representable.fill();
    }

    public void move(Enemy target){
        representable.translate(target.getRepresentation().getY() * speed, target.getRepresentation().getY() * speed);
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
