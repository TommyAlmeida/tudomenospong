package org.academiadecodigo.group.ad.gfx.enemies;

import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.grid.position.GridPosition;
import org.academiadecodigo.group.ad.gfx.map.Map;
import org.academiadecodigo.group.ad.gfx.map.Position;
import org.academiadecodigo.group.ad.gfx.map.Waypoint;
import org.academiadecodigo.group.ad.gfx.map.levels.FirstMap;
import org.academiadecodigo.group.ad.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Arrays;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */

public class Enemy {

    private int life;
    private int speed;
    private boolean dead;
    private int value;
    private EnemyType enemyType;
    private GridPosition gridPosition;
    private Position currentPosition;
    private Grid grid;
    private Rectangle enemyDrawed;
    private Waypoint[] waypoints;
    private SimpleGfxGrid simpleGfxGrid;
    private FirstMap map = new FirstMap();

    public Enemy(EnemyType enemyType, int life, int speed, int value, Grid grid) {
        this.enemyType = enemyType;
        this.life = life;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.gridPosition = grid.makeGridPosition(0, 0);
        enemyDrawed = new Rectangle(50, 50, 20, 20);


        draw();
    }


    private void draw() {

        enemyDrawed.setColor(Color.BLUE);
        enemyDrawed.fill();

    }


    public void move() {
        currentPosition = new Position(enemyDrawed.getX(),enemyDrawed.getY(),grid);
        map = new FirstMap();
        int moveX, moveY;
        int currentX;
        currentX = currentPosition.getX();
        int currentY;
        currentY = currentPosition.getY();
        System.out.println(map.waypoints.length);
        for (int i = 0; i < map.waypoints.length; i++) {
            while (map.getCurrentWaypoint() != waypoints[i]) {
                moveX = map.getCurrentWaypoint().getX() - waypoints[i].getX();
                moveY = map.getCurrentWaypoint().getY() - waypoints[i].getY();


                if (moveX > 0) {
                    map.getCurrentWaypoint().setX((currentX - speed) * simpleGfxGrid.getCellSize());
                    enemyDrawed.translate(speed,0);
                } else if (moveX < 0) {
                    map.getCurrentWaypoint().setX((currentX + speed) * simpleGfxGrid.getCellSize());
                    enemyDrawed.translate(-speed,0);
                } else if (moveY > 0) {
                    map.getCurrentWaypoint().setY((currentY - speed) * simpleGfxGrid.getCellSize());
                    enemyDrawed.translate(0,speed);
                } else if (moveY < 0) {
                    map.getCurrentWaypoint().setY((currentY + speed) * simpleGfxGrid.getCellSize());
                    enemyDrawed.translate(0,-speed);
                }
            }
        }
    }


    public GridPosition getPos() {
        return gridPosition;
    }

    public boolean isDead() {
        return dead;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "life=" + life +
                ", speed=" + speed +
                ", dead=" + dead +
                ", value=" + value +
                ", enemyType=" + enemyType +
                ", gridPosition=" + gridPosition +
                ", currentPosition=" + currentPosition +
                ", grid=" + grid +
                ", enemyDrawed=" + enemyDrawed +
                ", waypoints=" + Arrays.toString(waypoints) +
                ", simpleGfxGrid=" + simpleGfxGrid +
                ", map=" + map +
                '}';
    }
}

