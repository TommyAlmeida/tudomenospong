package org.academiadecodigo.group.ad.gfx.map;

import org.academiadecodigo.group.ad.gfx.enemies.Enemy;
import org.academiadecodigo.group.ad.gfx.grid.Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
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

