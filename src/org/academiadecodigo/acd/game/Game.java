package org.academiadecodigo.acd.game;

import org.academiadecodigo.acd.screens.GameScreen;

public class Game {

    private GameState gameState;

    public Game(){
        gameState = GameState.IN_GAME;
    }

    public void start(){
        switch (gameState){
            case MAIN_MENU:
                break;
            case IN_GAME:
                GameScreen gs = new GameScreen();
                try {
                    gs.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case GAME_OVER:
                break;
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
