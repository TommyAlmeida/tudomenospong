package org.academiadecodigo.acd.map.FirstMap;
import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.acd.map.Waypoint;

/**
 * Created on 13/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Map {

    private Waypoint[] waypoints;
    private Position currentPosition;

    public Map(Waypoint[] waypoints){

        this.waypoints = waypoints;
        waypoints[0] = new Position(6,9);
        waypoints[1] = new Waypoint(position, 7,5);
        waypoints[2] = new Waypoint(position, 7,2);
    }


    public void move() {
        int moveSet;

        for (int i = 0; i <waypoints.length; i++) {
            while (currentPosition != waypoints[i]){
                moveSet = currentPosition - waypoints;

            }
        }
    }


    /*Waypoint waypoint1;
    Waypoint waypoint2 = new Waypoint(3,5);

    waypoints[0] = waypoint1;*/
}
