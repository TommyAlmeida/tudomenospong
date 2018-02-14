package org.academiadecodigo.acd.entities;

import org.academiadecodigo.acd.entities.enemy.Enemy;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Player implements MouseHandler {

    private int lifes;
    private int money;
    private int totalScore;

    public Player(){
        this.lifes = 3;
        this.money = 100;
        this.totalScore = 0;
        mouseEvents();
    }

    private void mouseEvents(){
        Mouse m = new Mouse(this);
        MouseEventType createTower = MouseEventType.MOUSE_CLICKED;

        m.addEventListener(createTower);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public int getLifes() {
        return lifes;
    }

    public void addMoney(Enemy enemy){
        this.money += enemy.getMoney();
    }
}
