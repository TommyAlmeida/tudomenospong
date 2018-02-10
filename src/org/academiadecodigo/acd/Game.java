package org.academiadecodigo.acd;

import org.academiadecodigo.acd.entities.Player;
import org.academiadecodigo.acd.entities.enemies.Enemy;
import org.academiadecodigo.acd.entities.enemies.EnemyFactory;
import org.academiadecodigo.acd.screens.GameScreen;
import org.academiadecodigo.acd.screens.Screen;
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
                new GameScreen().start();
                break;
            case GAME_OVER:
                break;
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
