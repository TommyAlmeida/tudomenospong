package org.academiadecodigo.acd.entities.enemy;

public class EnemyFactory {

    public static Enemy makeEnemy(){
        return new DiogoEnemy();
    }
}
