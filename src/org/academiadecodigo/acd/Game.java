package org.academiadecodigo.acd;

import org.academiadecodigo.acd.entities.enemies.Enemy;
import org.academiadecodigo.acd.entities.enemies.EnemyFactory;

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

                break;
            case GAME_OVER:
                break;
        }
    }

}
