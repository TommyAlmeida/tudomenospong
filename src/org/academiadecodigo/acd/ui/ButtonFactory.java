package org.academiadecodigo.acd.ui;

public class ButtonFactory {

    public static Button build(int startX, int endX, int startY, int endY){
        return new Button(startX, startY, endX, endY);
    }
}
