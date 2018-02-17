package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.grid.Grid;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */


public class EnemyFactory {

    public static Enemy makeEnemy(Grid grid){
        return new DiogoEnemy(grid);
    }
}