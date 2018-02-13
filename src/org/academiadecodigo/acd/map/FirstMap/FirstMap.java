package org.academiadecodigo.acd.map.FirstMap;
import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.acd.map.Waypoint;

/**
 * Created on 13/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class FirstMap {

    private Waypoint[] waypoints;
    private Waypoint currentPosition;

    public FirstMap(Waypoint[] waypoints){

        this.waypoints = waypoints;
        waypoints[0] = new Waypoint(6,9);
        waypoints[1] = new Waypoint(7,5);
        waypoints[2] = new Waypoint(7,2);
    }


    public void move() {
        int moveX;
        int moveY;

        for (int i = 0; i < waypoints.length; i++) {
            while (currentPosition != waypoints[i]){
                moveX = currentPosition.getX() - waypoints[i].getX();
                moveY = currentPosition.getY() - waypoints[i].getY();
                if(moveX > 0){
                    currentPosition.setX();
                }
                if(moveX < 0){
                    currentPosition.setX();
                }
                if(moveY > 0){
                    currentPosition.setY();
                }
                if(moveY < 0){
                    currentPosition.setY();
                }

            }
        }
    }





    /*Waypoint waypoint1;
    Waypoint waypoint2 = new Waypoint(3,5);

    waypoints[0] = waypoint1;*/
}
