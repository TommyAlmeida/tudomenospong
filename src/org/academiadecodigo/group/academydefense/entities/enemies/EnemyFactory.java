package org.academiadecodigo.group.academydefense.entities.enemies;


import org.academiadecodigo.group.academydefense.grid.TiledGrid;


public class EnemyFactory {

    public static Enemy makeEnemy(){
        return new DiogoEnemy();
    }
}