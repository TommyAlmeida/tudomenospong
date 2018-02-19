package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.grid.*;
import org.academiadecodigo.group.academydefense.grid.path.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.group.academydefense.grid.path.Path;

public class Enemy{

    private int currentHealth, maxHealth;
    private int speed;
    private boolean dead;
    private int value;

    private EnemyType enemyType;
    private Text healthHud;
    private TilePictured sprite;
    private Movement movement = new Movement();


    //Constructor to check if it passes up the location of the enemy
    public Enemy() {

    }

    public Enemy(EnemyType enemyType, int maxHealth, int speed, int value) {
        this.enemyType = enemyType;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.sprite = new TilePictured(0, GridUtils.rowToY(10), "res/bruno-tower.png");
        this.healthHud = new Text(sprite.getPicture().getX(), sprite.getPicture().getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);
    }

    public void draw() {
        sprite.draw();

        healthHud.setColor(Color.BLUE);
        healthHud.draw();
    }



    public void move() {
        healthHud.translate(speed, 0);
        switch (generateDirection()) {
            case UP:
                pos.moveUp();
                break;
            case DOWN:
                pos.moveDown();
                break;
            case LEFT:
                pos.moveLeft();
                break;
            case RIGHT:
                pos.moveRight();
        }

        private Direction generateDirection() {
            Direction nextDirection;

                lastDirection = nextDirection;
            } else {
                nextDirection = lastDirection;
            }



            return nextDirection;
        }

        //getSprite().moveUp(speed);
        //path.changeDir();
       /* while (dead == false) {
            movement.setEnemyMove();
            if (movement.getEnemyMove() == 0) {
                getSprite().moveUp(speed);
                System.out.println("moveup");
            } else if (movement.getEnemyMove() == 1) {
                getSprite().moveRight(speed);
                System.out.println("moveright");
            } else if (movement.getEnemyMove() == 2) {
                getSprite().moveDown(speed);
                System.out.println("movedown");
            } else {
                getSprite().moveLeft(speed);
                System.out.println("moveleft");
            }

        }*/
    }


    public void recieveDamage(Bullet bullet) {
        if (bullet.getDamage() >= currentHealth) {
            currentHealth = 0;
        }

        if (currentHealth <= 0) {
            dead = true;
        }

        currentHealth -= bullet.getDamage();
    }

    public int getSpeed() {
        return speed;
    }

    public boolean hasReachedTheEnd() {
        return sprite.getPicture().getY() == 10 / 2;
    }

    public boolean isDead() {
        return dead;
    }

    public TilePictured getSprite() {
        return sprite;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                ", speed=" + speed +
                ", dead=" + dead +
                ", value=" + value +
                ", enemyType=" + enemyType +
                ", healthHud=" + healthHud +
                ", sprite=" + sprite.getX() +
                ", sprite=" + sprite.getY() +
                '}';
    }
}

