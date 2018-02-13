package org.academiadecodigo.acd.map;

/**
 * Created on 13/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Waypoint{

    private Position position;

    private int x;
    private int y;







    public Waypoint(int x,, int y){
        this.position = new Position(x, y);

    }

   /* public void move() {
        int moveSet;

        for (int i = 0; i <waypoints.length; i++) {
            while (currentPosition != waypoints[i]){
                moveSet = currentPosition - waypoints;

            }
        }
    }*/

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



}
