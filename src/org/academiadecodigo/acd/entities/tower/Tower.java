package org.academiadecodigo.acd.entities.tower;

import org.academiadecodigo.acd.graphics.Representable;
import org.academiadecodigo.acd.map.Position;

public class Tower {

    private Position currentPosition;
    private Representable representable;

    private int range, fireRate, damage, level; //Level: if X level returns = not upgradable

    public Tower(Representable representable, int range, int fireRate, int damage) {
        this.representable = representable;
        this.range = range; // range = raio
        this.fireRate = fireRate;
        this.damage = damage;
        this.level = 0;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Representable getRepresentable() {
        return representable;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
