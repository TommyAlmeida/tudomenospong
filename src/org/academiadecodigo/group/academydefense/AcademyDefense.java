package org.academiadecodigo.group.academydefense;


import org.academiadecodigo.group.academydefense.game.Game;


public class AcademyDefense {
    public static void main(String[] args) {
        System.out.println("Cuidado com os pombos!");
        Game g = new Game();

        try {
            g.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
