package org.academiadecodigo.group.ad.gfx.towers;

public enum BulletType {

    NORMAL(1, 1);

    private int damage, speed;

    BulletType(int damage, int speed){
        this.damage = damage;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }
}
