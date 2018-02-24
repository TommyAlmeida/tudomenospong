package org.academiadecodigo.group.academydefense.entities.enemy;


import org.academiadecodigo.group.academydefense.game.GameConsts;
import org.academiadecodigo.group.academydefense.grid.tiles.TilePictured;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Enemy {

    private int currentHealth;
    private int maxHealth;
    private int speed;

    private EnemyType enemyType;
    private Text healthHud;
    private TilePictured sprite;

    public Enemy(EnemyType enemyType, int maxHealth, int speed, int value) {
        this.enemyType = enemyType;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.speed = speed;

        this.sprite = new TilePictured(0, 10 * GameConsts.CELL_SIZE + GameConsts.PADDING, "res/monicawtf.png");
        this.healthHud = new Text(sprite.getX(),sprite.getY() - 15, String.valueOf(currentHealth) + "/" + maxHealth);
    }

    /**
     * Draw our enemy to the screen
     */
    public void draw() {
        sprite.draw();

        healthHud.setColor(Color.BLUE);
        healthHud.draw();
    }

    /**
     * Make our enemy move if not dead
     * and if it is or if it has reached the end
     * the enemy will be deleted from the screen
     */
    public void move(){
        if(isDead()){
            return;
        }

        if(hasReachedTheEnd()){
            die();
            return;
        }

        updateHealthBar();
        getSprite().moveRight(speed);
    }

    /**
     * Receive damage if hitted by a tower
     */
    public void receiveDamage(int damage){
        if(damage >= currentHealth){
            die();
            return;
        }

        currentHealth -= damage;
    }

    public void die() {
        currentHealth = 0;

        sprite.hide();
        healthHud.delete();
    }

    private void updateHealthBar() {
        healthHud.setText(String.valueOf(currentHealth) + "/" + maxHealth);
        healthHud.setColor(Color.RED);
        healthHud.draw();
        healthHud.translate(speed, 0);
    }

    public boolean hasReachedTheEnd(){
        return sprite.getX() == 1500;
    }

    public boolean isDead() {
        return currentHealth <= 0;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public TilePictured getSprite() {
        return sprite;
    }
}

