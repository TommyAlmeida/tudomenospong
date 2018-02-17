package org.academiadecodigo.group.ad.gfx;


import org.academiadecodigo.group.ad.gfx.game.Game;


public class AcademyDefense {
    public static void main(String[] args) {

        Game g = new Game(70, 40);

        try {
            g.init();
            g.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
