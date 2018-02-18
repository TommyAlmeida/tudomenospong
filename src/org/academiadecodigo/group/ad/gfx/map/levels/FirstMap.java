package org.academiadecodigo.group.ad.gfx.map.levels;

import org.academiadecodigo.group.ad.gfx.enemies.Enemy;
import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.map.Map;
import org.academiadecodigo.group.ad.gfx.map.Waypoint;

/**
 * Created on 17/02/2018.
 * Good Luck, Have Fun codecadet
 */

public class FirstMap extends Map {
    private Waypoint[] waypoints;
    private Waypoint currentPosition;
    private Grid grid;
    private Enemy enemy;

    public FirstMap(){
        super("Level 01", new Waypoint[]{
                new Waypoint(0,50),
                new Waypoint(70,50),
                new Waypoint(70,20),
                new Waypoint(10,20)
        }, new Waypoint(50,50));
    }
}
