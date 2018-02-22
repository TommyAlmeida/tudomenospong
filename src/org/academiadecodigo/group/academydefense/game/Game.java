package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.game.states.GameState;
import org.academiadecodigo.group.academydefense.game.states.InGame;

/**
 * This class is where the game is created
 */
public class Game {

    //Defines the current game state
    private GameState gameState;

    public Game() {
        gameState = GameState.IN_GAME;
    }

    /**
     * Draw everything into to the screen
     * and runs a game loop
     * Every frame is refreshed in 15ms
     */
    public void start(){
        switch (gameState){
            case MENU:
                break;
            case IN_GAME:
                new InGame().create(this);
                break;
            case GAME_OVER:
                break;
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}

