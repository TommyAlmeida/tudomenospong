package org.academiadecodigo.group.academydefense.entities.towers;

public class BulletFactory {


    public Bullet make(BulletType type, Tower tower){
        switch (type){
            case NORMAL:
                return new Bullet(type.getDamage(), type.getSpeed(), tower);

        }
        return new Bullet(type.getDamage(), type.getSpeed(), tower);
    }
}
