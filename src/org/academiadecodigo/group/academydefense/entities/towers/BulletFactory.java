package org.academiadecodigo.group.academydefense.entities.towers;

public class BulletFactory {


    public Bullet make(BulletType type){
        switch (type){
            case NORMAL:
                return new Bullet(type.getDamage(), type.getSpeed());

        }
        return new Bullet(type.getDamage(), type.getSpeed());
    }
}
