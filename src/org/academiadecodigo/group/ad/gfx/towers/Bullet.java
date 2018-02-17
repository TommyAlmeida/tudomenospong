package org.academiadecodigo.group.ad.gfx.towers;

import org.academiadecodigo.group.ad.gfx.enemies.Enemy;
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

    public void move(){
        representable.translate(0, speed);

        System.out.println(this);
    }

    public void hit(Enemy target){
        //do damage
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
