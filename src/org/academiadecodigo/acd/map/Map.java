package org.academiadecodigo.acd.map;

import org.academiadecodigo.acd.entities.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private String name;

    private Waypoint[] waypoints;
    private Waypoint currentWaypoint;
    private Grid grid;
    private List<Enemy> enemies;

    public Map(String name, Waypoint[] waypoints, Waypoint currentWaypoint) {
        this.name = name;
        this.waypoints = waypoints;
        this.currentWaypoint = currentWaypoint;
        this.enemies = new ArrayList<>();
    }

    public void move() {
        int moveX, moveY;
        int currentX = grid.getX(), currentY = grid.getY();

        for (int i = 0; i < waypoints.length; i++) {
            while (currentWaypoint != waypoints[i]) {
                moveX = currentWaypoint.getX() - waypoints[i].getX();
                moveY = currentWaypoint.getY() - waypoints[i].getY();

                if (moveX > 0) {
                    currentWaypoint.setX((currentX - 1) * grid.getCellSize());
                }else if (moveX < 0) {
                    currentWaypoint.setX((currentX + 1) * grid.getCellSize());
                }else if (moveY > 0) {
                    currentWaypoint.setY((currentY - 1) * grid.getCellSize());
                }else if (moveY < 0) {
                    currentWaypoint.setY((currentY + 1) * grid.getCellSize());
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Waypoint[] getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(Waypoint[] waypoints) {
        this.waypoints = waypoints;
    }

    public Waypoint getCurrentWaypoint() {
        return currentWaypoint;
    }

    public void setCurrentWaypoint(Waypoint currentWaypoint) {
        this.currentWaypoint = currentWaypoint;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
}
