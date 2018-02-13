package org.academiadecodigo.acd.entities.enemy;

import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.graphics.Representable;
import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy{

    private int currentHealth, maxHealth;
    private int speed;
    private int money; //how much is this enemy worth in €€€
    private boolean dead;

    private Position startPosition;

    private Text healthHUD;

    private Representable representable;
    private Picture sprite;

    private EnemyType enemyType;

    public Enemy(Representable representable, EnemyType enemyType,
                 int maxHealth, int moneyValue, int speed){
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.money = moneyValue;
        this.speed = speed;
        this.enemyType = enemyType;
        this.representable = representable;

        startPosition = new Position(0, 0);
        dead = false;
        sprite = representable.getSprite();
    }

    /**
     * Init representations
     */
    public void render(){
        drawHpBar();
        representable.render();
    }

    /**
     * Everything it needs to be on the main game loop
     */
    public void update(){
        if(isDead()){
            representable.delete();
            healthHUD.delete();
            return;
        }

        move();
    }

    /**
     * Make the enemy move and the health bar follows
     */
    public void move(){
        healthHUD.translate(speed, 0);
        sprite.translate(speed, 0);
    }

    /**
     * Draw the health bar
     */
    private void drawHpBar(){
        healthHUD = new Text(sprite.getX(), sprite.getY() - 5, String.valueOf(currentHealth));
        healthHUD.setColor(Color.RED);
        healthHUD.draw();
    }

    public void takeHit(Player player, int damage) {
        currentHealth -= damage; //tower.getDamage();
        healthHUD.setText(String.valueOf(currentHealth));

        if(currentHealth <= 0){
            dead = true;
            player.addMoney(this);
        }
    }

    public boolean isDead(){
        return dead;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                " currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                ", speed=" + speed +
                ", money=" + money +
                '}';
    }
}
