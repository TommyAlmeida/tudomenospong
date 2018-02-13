package org.academiadecodigo.acd.map.FirstMap;
import org.academiadecodigo.acd.map.Waypoint;

/**
 * Created on 13/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Map {

    private Waypoint[] waypoints;

    public Map(Waypoint[] waypoints){

        this.waypoints = waypoints;
        waypoints[0] = new Waypoint(0,5);
        waypoints[1] = new Waypoint(7,5);
    }


    /*Waypoint waypoint1;
    Waypoint waypoint2 = new Waypoint(3,5);

    waypoints[0] = waypoint1;*/
}
