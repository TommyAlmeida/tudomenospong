package org.academiadecodigo.group.academydefense.entities.player;

import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.game.Game;
import org.academiadecodigo.group.academydefense.grid.Tile;
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
    private Tower tower;
    private Game game;


    private static List<Tower> towersCreated;
    private TiledGrid grid;

    public Player(Game game, TiledGrid grid){
        this.lifes = 3;
        this.money = 100;
        this.totalScore = 0;
        this.grid = grid;
        this.game = game;
        towersCreated = new ArrayList<>();

        mouseEvents();
    }

    private void mouseEvents(){
        Mouse m = new Mouse(this);
        MouseEventType createTower = MouseEventType.MOUSE_CLICKED;

        m.addEventListener(createTower);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = ((int) (mouseEvent.getX()-TiledGrid.PADDING)/ TiledGrid.CELL_SIZE) * TiledGrid.CELL_SIZE + TiledGrid.CELL_SIZE;
        int y = ((int) mouseEvent.getY()/ TiledGrid.CELL_SIZE) * TiledGrid.CELL_SIZE + TiledGrid.PADDING - TiledGrid.CELL_SIZE;

        System.out.println(mouseEvent.getX() + "----> " + x + " " + mouseEvent.getY() +"-----> " + y);


        tower = new Tower(grid, x, y, 1, 1, 100);
        Bullet newBullet = new Bullet(1,1,tower);

        tower.draw();

        towersCreated.add(tower);

        for(Enemy e : game.getEnemies()){
            setPositions(tower, e);
        }
    }

    public void setPositions(Tower tower, Enemy enemy) {
        tower.setTowerToEnemyCol(enemy);
        tower.setTowerToEnemyRow(enemy);
        tower.towerToEnemy = (int) (Math.sqrt((tower.getTowerToEnemyCol() * tower.getTowerToEnemyCol()) + (tower.getTowerToEnemyRow() * tower.getTowerToEnemyRow())));
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        //Not using
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
}
