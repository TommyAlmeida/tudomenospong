package org.academiadecodigo.acd.screens;

import org.academiadecodigo.acd.GameConsts;
import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.entities.enemies.Enemy;
import org.academiadecodigo.acd.entities.enemies.EnemyFactory;
import org.academiadecodigo.acd.map.Grid;
import org.academiadecodigo.acd.map.Map;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameScreen implements Screen, KeyboardHandler{

    private boolean exit; //debug force exit

    private Enemy enemy;
    private Player player;
    private Grid grid;

    public GameScreen(){
        this.exit = false;
        this.enemy = EnemyFactory.makeEnemy();
        this.player = new Player();
        keyEvents();
    }

    @Override
    public void start() {
        grid = new Grid(GameConsts.WINDOW_WIDTH, GameConsts.WINDOW_HEIGHT);

        enemy.render();

        while (!exit || player.getLifes() > 0){
            try {
                Thread.sleep(GameConsts.GAME_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            enemy.update();
        }
    }

    private void keyEvents(){
        Keyboard k = new Keyboard(this);
        KeyboardEvent ev = new KeyboardEvent();

        ev.setKey(KeyboardEvent.KEY_E);
        ev.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(ev);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        if(e.getKey() == KeyboardEvent.KEY_E){
            enemy.takeHit(player, 1); //DEBUG
            exit = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
