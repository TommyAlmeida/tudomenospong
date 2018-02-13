package org.academiadecodigo.acd.entities.enemy;

import org.academiadecodigo.acd.graphics.representations.DiogoEnemyRepresentation;

public class DiogoEnemy extends Enemy {

    public DiogoEnemy() {
        super(new DiogoEnemyRepresentation(), EnemyType.DIOGO, 20, 10, 5);
    }

}
