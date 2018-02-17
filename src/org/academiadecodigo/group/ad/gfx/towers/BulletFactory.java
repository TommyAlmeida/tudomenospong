package org.academiadecodigo.group.ad.gfx.towers;

public class BulletFactory {

    public static Bullet make(BulletType type){
        switch (type){
            case NORMAL:
                return new Bullet(type.getDamage(), type.getSpeed());

        }

        return null;
    }
}
