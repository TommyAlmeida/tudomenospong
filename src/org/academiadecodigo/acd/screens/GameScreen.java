package org.academiadecodigo.acd.screens;

import org.academiadecodigo.acd.GameConsts;
import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.entities.enemies.Enemy;
import org.academiadecodigo.acd.entities.enemies.EnemyFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameScreen implements Screen, KeyboardHandler{

    private boolean exit; //debug force exit

    private Enemy enemy;
    private Player player;
    private Rectangle tempGrid;


    public GameScreen(){
        this.exit = false;
        this.enemy = EnemyFactory.makeEnemy();
        this.player = new Player();
        this.tempGrid = new Rectangle(10, 10, GameConsts.WINDOW_WIDTH, GameConsts.WINDOW_HEIGHT);

        keyEvents();
    }

    @Override
    public void start() {
        tempGrid.setColor(Color.WHITE);
        tempGrid.fill();

        enemy.init();
        while (!exit || player.getLifes() > 0){
            try {
                Thread.sleep(GameConsts.GAME_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            enemy.move();
        }
    }

    private void keyEvents(){
        Keyboard k = new Keyboard(this);
        KeyboardEvent ev = new KeyboardEvent();

        ev.setKey(KeyboardEvent.KEY_E);
        k.addEventListener(ev);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        if(e.getKey() == KeyboardEvent.KEY_E){
            exit = true;
            System.out.println("Exit");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
