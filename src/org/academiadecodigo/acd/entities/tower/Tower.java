package org.academiadecodigo.acd.entities.tower;

import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tower {

    private Position currentPosition;
    private Picture picture;

    private int range, fireRate, damage, level; //Level: if X level returns = not upgradable

    public Tower(Position currentPosition, Picture picture, int range, int fireRate, int damage) {
        this.currentPosition = currentPosition;
        this.picture = picture;
        this.range = range;
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

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
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
