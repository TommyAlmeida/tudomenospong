package org.academiadecodigo.acd.screens;

import org.academiadecodigo.acd.game.GameConsts;
import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.entities.enemy.Enemy;
import org.academiadecodigo.acd.entities.enemy.EnemyFactory;
import org.academiadecodigo.acd.map.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen implements Screen, KeyboardHandler{

    private boolean exit; //debug force exit

    private Player player;
    private Grid grid;

    public GameScreen(){
        this.exit = false;
        this.player = new Player();
        keyEvents();
    }

    @Override
    public void start() throws InterruptedException {
        grid = new Grid(GameConsts.WINDOW_WIDTH, GameConsts.WINDOW_HEIGHT);

        while (!exit || player.getLifes() > 0){
            Thread.sleep(GameConsts.GAME_DELAY);
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
            exit = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
