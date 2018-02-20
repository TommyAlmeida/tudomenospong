package org.academiadecodigo.group.academydefense.entities.enemy;

/**
 * Creates of enemy
 */
public class EnemyFactory {

    public static Enemy makeEnemy(){
        return new MonicaEnemy();
    }
}