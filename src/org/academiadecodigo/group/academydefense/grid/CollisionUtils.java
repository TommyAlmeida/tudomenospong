package org.academiadecodigo.group.academydefense.grid;

public class CollisionUtils {

    public static boolean samePos(Tile me, Tile other){
        return me.getCol() == other.getCol() && me.getRow() == other.getRow();
    }
}
