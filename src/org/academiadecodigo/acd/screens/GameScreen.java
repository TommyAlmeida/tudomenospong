package org.academiadecodigo.acd.screens;

import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.entities.enemies.Enemy;
import org.academiadecodigo.acd.entities.enemies.EnemyFactory;
import org.academiadecodigo.acd.ui.UITowerSelector;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameScreen implements Screen {

    private boolean exit;

    private Enemy enemy;
    private Player player;

    private UITowerSelector uiTowerSelector;

    @Override
    public void init() {
        exit = false;
        enemy = EnemyFactory.makeEnemy();
        player = new Player();
        uiTowerSelector.draw();
    }

    @Override
    public void start() {
        while (!exit){

        }
    }
}
