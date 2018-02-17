package org.academiadecodigo.group.ad.gfx;


import org.academiadecodigo.group.ad.gfx.game.Game;


public class AcademyDefense {
    public static void main(String[] args) throws InterruptedException {


        Game g = new Game(70, 40, 200);
        g.init();
        g.start();
    }
}
