package org.academiadecodigo.group.ad.gfx.enemies;

import org.academiadecodigo.group.ad.gfx.grid.Grid;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */


public class EnemyFactory {

    private static Grid grid;

    public static Enemy makeEnemy(Grid grid){
        return new DiogoEnemy(grid);
    }
}