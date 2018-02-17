package org.academiadecodigo.group.ad.gfx.enemies;

import org.academiadecodigo.group.ad.gfx.grid.Grid;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class DiogoEnemy extends Enemy {

    private Grid grid;

    public DiogoEnemy(Grid grid){
        super(EnemyType.DIOGO,1,10,1, grid);
        this.grid = grid;
    }



}
