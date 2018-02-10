package org.academiadecodigo.acd.screens;

import org.academiadecodigo.acd.Game;
import org.academiadecodigo.acd.GameState;
import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.entities.enemies.Enemy;
import org.academiadecodigo.acd.entities.enemies.EnemyFactory;
import org.academiadecodigo.acd.ui.UITowerSelector;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameScreen implements Screen, KeyboardHandler{

    private boolean exit;

    private Enemy enemy;
    private Player player;

    private UITowerSelector uiTowerSelector;

    public GameScreen(){
        this.exit = false;
        this.enemy = EnemyFactory.makeEnemy();
        this.player = new Player();
        this.uiTowerSelector = new UITowerSelector();

        keyEvents();
    }

    @Override
    public void start() {
        while (!exit){
            uiTowerSelector.draw();
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
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
