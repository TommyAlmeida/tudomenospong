package org.academiadecodigo.acd;

import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.entities.enemies.Enemy;
import org.academiadecodigo.acd.entities.enemies.EnemyFactory;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private GameState gameState;

    public void init(){
        gameState = GameState.IN_GAME;
    }

    public void start(){
        switch (gameState){
            case MAIN_MENU:
                break;
            case IN_GAME:
                Enemy enemy = EnemyFactory.makeEnemy();
                Player player = new Player();
                new Rectangle(10, 10, 800, 600).draw();
                break;
            case GAME_OVER:
                break;
        }
    }

}
