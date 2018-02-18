package org.academiadecodigo.group.academydefense.entities.player;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player implements MouseHandler {

    private int lifes;
    private int money;
    private int totalScore;

    private List<Tower> towersCreated;
    private TiledGrid grid;

    public Player(TiledGrid grid){
        this.lifes = 3;
        this.money = 100;
        this.totalScore = 0;
        this.grid = grid;
        this.towersCreated = new ArrayList<>();

        mouseEvents();
    }

    private void mouseEvents(){
        Mouse m = new Mouse(this);
        MouseEventType createTower = MouseEventType.MOUSE_CLICKED;

        m.addEventListener(createTower);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = (int) Math.round(mouseEvent.getX());
        int y = (int ) Math.round(mouseEvent.getY());

        Tower newTower = new Tower(grid, x, y, 0, 1, 1);
        newTower.draw(Color.BLUE);
        towersCreated.add(newTower);
        System.out.println(towersCreated);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        //Not using
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
