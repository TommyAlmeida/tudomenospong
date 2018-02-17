package org.academiadecodigo.group.academydefense.entities.player;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.grid.Grid;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Player implements MouseHandler {

    private int lifes;
    private int money;
    private int totalScore;

    private Grid grid;

    public Player(Grid grid){
        this.lifes = 3;
        this.money = 100;
        this.totalScore = 0;
        this.grid = grid;

        mouseEvents();
    }

    private void mouseEvents(){
        Mouse m = new Mouse(this);
        MouseEventType createTower = MouseEventType.MOUSE_CLICKED;


        m.addEventListener(createTower);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(new Tower(grid, 1, 2));
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

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
}
