package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.enemy.MonicaEnemy;
import org.academiadecodigo.group.academydefense.entities.enemy.Enemy;
import org.academiadecodigo.group.academydefense.entities.Bullet;
import org.academiadecodigo.group.academydefense.entities.tower.Tower;
import org.academiadecodigo.group.academydefense.game.states.InGame;
import org.academiadecodigo.group.academydefense.grid.tiles.TiledGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.*;

public class Player implements MouseHandler, KeyboardHandler {

    private static List<Tower> towersCreated;

    private int lifes;
    private int money;

    private TiledGrid grid;
    private InGame game;
    private Tower tower;

    public Player(TiledGrid grid, InGame game){
        this.lifes = 3;
        this.money = 100;
        this.grid = grid;
        this.game = game;

        towersCreated = new ArrayList<>();
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
        int x = ((int) (mouseEvent.getX() - TiledGrid.PADDING) / TiledGrid.CELL_SIZE) * TiledGrid.CELL_SIZE + TiledGrid.CELL_SIZE;
        int y = ((int) mouseEvent.getY() / TiledGrid.CELL_SIZE) * TiledGrid.CELL_SIZE + TiledGrid.PADDING - TiledGrid.CELL_SIZE;

        tower = new Tower(grid, x, y, 1, 1, 100);

        if(towersCreated.add(tower)){
            tower.draw();
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //On space pressed
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

    public static List<Tower> getTowersCreated() {
        return towersCreated;
    }

    public int getLifes() {
        return lifes;
    }

    public void addMoney(Enemy enemy) {
        this.money += enemy.getValue();
    }

    public void loseMoney(Enemy enemy) {
        this.money -= enemy.getValue();
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
