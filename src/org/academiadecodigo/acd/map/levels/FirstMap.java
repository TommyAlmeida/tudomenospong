package org.academiadecodigo.acd.map.levels;
import org.academiadecodigo.acd.entities.enemy.Enemy;
import org.academiadecodigo.acd.map.Grid;
import org.academiadecodigo.acd.map.Map;
import org.academiadecodigo.acd.map.Waypoint;


/**
 * Created on 13/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class FirstMap extends Map{

    private Waypoint[] waypoints;
    private Waypoint currentPosition;
    private Grid grid;
    private Enemy enemy;

    public FirstMap(){
        super("Level 01", new Waypoint[]{
                new Waypoint(0,5),
                new Waypoint(7,5),
                new Waypoint(7,2)
        }, new Waypoint(0,5));
    }
}
