package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.enemy.MonicaEnemy;
import org.academiadecodigo.group.academydefense.game.states.InGame;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.Timer;
import java.util.TimerTask;

public class InputHandler implements MouseHandler, KeyboardHandler {

    private InGame game;

    public InputHandler(InGame game){
        this.game = game;
        inputEvents();
    }

    /**
     * Register keyboard and move events
     */
    private void inputEvents(){
        Mouse m = new Mouse(this);
        Keyboard kb = new Keyboard(this);

        MouseEventType createTower = MouseEventType.MOUSE_CLICKED;
        KeyboardEvent ke = new KeyboardEvent();
        ke.setKey(KeyboardEvent.KEY_SPACE);
        ke.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(ke);
        m.addEventListener(createTower);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = ((int) (mouseEvent.getX() - GameConsts.PADDING) / GameConsts.CELL_SIZE) * GameConsts.CELL_SIZE + GameConsts.CELL_SIZE;
        int y = ((int) mouseEvent.getY() / GameConsts.CELL_SIZE) * GameConsts.CELL_SIZE + GameConsts.PADDING - GameConsts.CELL_SIZE;

        game.addTower(x, y);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            //Every half a second creates a enemy
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    game.getEnemies().add(new MonicaEnemy());
                }
            }, 500);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //Not using
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        //Not using
    }
}
