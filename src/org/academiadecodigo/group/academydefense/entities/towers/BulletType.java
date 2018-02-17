package org.academiadecodigo.group.academydefense.entities.towers;

public enum BulletType {

    NORMAL(1, 7);

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
