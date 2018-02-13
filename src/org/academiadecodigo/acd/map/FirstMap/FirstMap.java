package org.academiadecodigo.acd.map.FirstMap;
import org.academiadecodigo.acd.entities.enemy.Enemy;
import org.academiadecodigo.acd.map.Grid;
import org.academiadecodigo.acd.map.Position;
import org.academiadecodigo.acd.map.Waypoint;


/**
 * Created on 13/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class FirstMap {

    private Waypoint[] waypoints;
    private Waypoint currentPosition;
    private Grid grid;
    private Enemy enemy;

    public FirstMap(Waypoint[] waypoints){

        this.waypoints = waypoints;
        currentPosition = new Waypoint(0,0);
        waypoints[0] = new Waypoint(0,5);
        waypoints[1] = new Waypoint(7,5);
        waypoints[2] = new Waypoint(7,2);
    }


   public void move() {
        int moveX;
        int moveY;
        int currentX = grid.getX();
        int currentY = grid.getY();

        for (int i = 0; i < waypoints.length; i++) {
            while (currentPosition != waypoints[i]){
                moveX = currentPosition.getX() - waypoints[i].getX();
                moveY = currentPosition.getY() - waypoints[i].getY();
                if(moveX > 0){
                    currentPosition.setX((currentX - 1) * grid.getCellSize());

                }
                if(moveX < 0){
                    currentPosition.setX((currentX + 1) * grid.getCellSize());
                }
                if(moveY > 0){
                    currentPosition.setY((currentY - 1) * grid.getCellSize());
                }
                if(moveY < 0){
                    currentPosition.setY((currentY + 1) * grid.getCellSize());
                }



            }
        }
    }





    /*Waypoint waypoint1;
    Waypoint waypoint2 = new Waypoint(3,5);

    waypoints[0] = waypoint1;*/
}
