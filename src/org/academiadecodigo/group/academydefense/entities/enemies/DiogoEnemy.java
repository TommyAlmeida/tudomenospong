package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.grid.Grid;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class DiogoEnemy extends Enemy {

    private Grid grid;

    public DiogoEnemy(Grid grid){
        super(EnemyType.DIOGO,1,1,1, grid);
        this.grid = grid;
    }



}
